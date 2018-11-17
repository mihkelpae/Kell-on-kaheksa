package com.example.demo.services;

import com.example.demo.repositories.IPRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

@Service
public class LocationLookupService {

    @Autowired
    IPRepository ipRepository;

    public void run(String ip) {
        String apiKey = System.getenv("IP_LOCATION_API");
        JSONObject jsonObject = new JSONObject();
        try {
            URL url = new URL("http://api.ipstack.com/" + ip +
                    "?access_key=" + apiKey);
            Scanner scanner = new Scanner(url.openStream());

            jsonObject = new JSONObject(scanner.nextLine());
            /*String country = jsonObject.getString("country_name");
            String city = jsonObject.getString("city");
            Double longitude = jsonObject.getDouble("longitude");
            Double latitude = jsonObject.getDouble("latitude");
*/
            System.out.println(jsonObject.getString("city"));
            //requestLocationRepository.update(ip, country, city, longitude, latitude);
        } catch (UnknownHostException e) {
            System.out.println("No internet connection, cannot find location");
        }
        catch (JSONException e) {
            e.printStackTrace();
            System.err.println(ip + " " + jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
