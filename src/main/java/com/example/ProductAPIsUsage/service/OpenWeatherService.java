package com.example.ProductAPIsUsage.service;

import com.example.ProductAPIsUsage.models.Weather;

public interface OpenWeatherService {

      public Weather getWeatherData(String Location, String apiId  );
}
