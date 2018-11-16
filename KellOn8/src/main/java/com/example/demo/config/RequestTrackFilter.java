package com.example.demo.config;

import com.example.demo.entities.IP;
import com.example.demo.entities.OS;
import com.example.demo.entities.User;
import com.example.demo.repositories.IPRepository;
import com.example.demo.repositories.OSRepository;
import eu.bitwalker.useragentutils.OperatingSystem;
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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        String header = servletRequest.getHeader("User-Agent");

        UserAgent userAgent = UserAgent.parseUserAgentString(header);

        String os = userAgent.getOperatingSystem().getName();
        String requestURI = servletRequest.getRequestURI();
        OS opsys = new OS(os, requestURI);

        //Kontorlli kas on peamine leht või läheb ka staticusse.
        //servletRequest.getRequestURI();

        osRepository.save(opsys);
        System.out.println(os);
        System.out.println(servletRequest.getRequestURI());

        final String ip = request.getRemoteAddr();
        IP address = new IP(ip, requestURI);
        ipRepository.save(address);
        System.out.println(ip);
    }

    @Override
    public void destroy() {}
}
