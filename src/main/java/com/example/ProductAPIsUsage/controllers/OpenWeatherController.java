package com.example.ProductAPIsUsage.controllers;

import com.example.ProductAPIsUsage.models.Weather;
import com.example.ProductAPIsUsage.service.OpenWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OpenWeatherController {

    @Autowired
    private OpenWeatherService weatherService;


    @GetMapping("q/{location}" )  //location like <Bangalore,India> // <City>,<Country>
    public ResponseEntity<Weather> getWeatherByLocation( @PathVariable String location ) {

        String appIdDef = "d686918b5126942edef0481cfefe8ec0";     //Default API Key
//        String appIdNew = "9caa87ad89f9e1a239559bab55ab51ab";       //New Generated API key
        Weather weatherObj = weatherService.getWeatherData( location , appIdDef );


        return new ResponseEntity<>(weatherObj,HttpStatusCode.valueOf(200));


    }
}
