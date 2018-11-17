package com.example.demo.config;

import com.example.demo.entities.IP;
import com.example.demo.entities.OS;
import com.example.demo.repositories.BrowserRepository;
import com.example.demo.repositories.IPRepository;
import com.example.demo.repositories.OSRepository;
import com.example.demo.services.LocationLookupService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class RequestTrackFilter implements Filter {

    @Autowired
    OSRepository osRepository;

    @Autowired
    IPRepository ipRepository;

    @Autowired
    BrowserRepository browserRepository;

    @Autowired
    LocationLookupService locationLookupService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        String header = servletRequest.getHeader("User-Agent");

        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        String requestURI = servletRequest.getRequestURI();

        String os = userAgent.getOperatingSystem().getName();
        OS opsys = new OS(os, requestURI);
        osRepository.save(opsys);

        final String ip = request.getRemoteAddr();
        IP address = new IP(ip, requestURI);
        ipRepository.save(address);
        locationLookupService.updateLoc(ip);

        Browser browser = userAgent.getBrowser();
        String browserName = browser.getName();
        com.example.demo.entities.Browser browserInfo = new com.example.demo.entities.Browser(browserName, requestURI);
        browserRepository.save(browserInfo);


        //Tuleb teha korda location lookup!
        //Pollapist tuleb võtta ja teha nii, et liiga palju erqueste ei ajaks asja kokku
    }

    @Override
    public void destroy() {}
}
