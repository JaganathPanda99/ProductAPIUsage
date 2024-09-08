package com.example.ProductAPIsUsage.service;
import com.example.ProductAPIsUsage.dtos.OpenWeatherServiceDto;
import com.example.ProductAPIsUsage.models.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class weatherService implements OpenWeatherService{

    @Override
    public Weather getWeatherData (String Location, String apiId) {

        String URL = "https://api.openweathermap.org/data/2.5/weather";
        String newURL = URL + "?q=" + Location + "&appid=" + apiId;

        RestTemplate restTemplate = new RestTemplate();

        OpenWeatherServiceDto openWeatherServiceDto = restTemplate.getForObject(newURL, OpenWeatherServiceDto.class);
        String openWeatherJSONinString = restTemplate.getForObject(newURL, String.class);
        JsonNode objJsonMapper;
        try {
            objJsonMapper = new ObjectMapper().readTree(openWeatherJSONinString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


//        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//        ResponseEntity<OpenWeatherServiceDto> response = restTemplate.getForEntity(newURL, OpenWeatherServiceDto.class);
//        response.getBody();

        //        List<HttpMessageConverter<?>> messageConverters= restTemplate.getMessageConverters();
//        String messageConvStr = messageConverters.toString();
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        messageConverters.add(converter);
//        restTemplate.setMessageConverters(messageConverters);

//        return restTemplate;
//        List<HttpMessageConverter<?>> list = messageConverters.stream().toList();

        return convertOpenWeatherDtoToWeather(openWeatherServiceDto, objJsonMapper );

//        return null;
    }

    public Weather convertOpenWeatherDtoToWeather(OpenWeatherServiceDto openWeatherServiceDto , JsonNode objJsonMapper) {

        Weather weather = new Weather();

        //Create the JSON object received when instantiated
        JsonNode weatherNodeObj = objJsonMapper.get("weather");
        JsonNode coordNodeObj = objJsonMapper.get("coord");    // Get JsonObj-->Weather
        JsonNode main1NodeObj = objJsonMapper.get("main");
        //******************************************************************************

        weather.setId(openWeatherServiceDto.getId());
        weather.setName(openWeatherServiceDto.getName());
        weather.setCod(openWeatherServiceDto.getCod());
        weather.setTimezone(openWeatherServiceDto.getTimezone());

         ArrayList<String> coordObj = openWeatherServiceDto.getCoordsObj( coordNodeObj );
         weather.setCoords(coordObj);
         weather.setWeatherObj( openWeatherServiceDto.getWeatherObj(weatherNodeObj) );

        return weather;
    }
}
