package com.example.ProductAPIsUsage.models;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class Weather {

    String id;
    String name;
    String timezone;
    String cod;
//    ArrayList<coord> coords;
//    ArrayList<weather> weatherObj;
//    ArrayList<main1> main1Obj;


    ArrayList<String> coords = new ArrayList<>();
    ArrayList<String> weatherObj = new ArrayList<>();
    ArrayList<main1> main1Obj = new ArrayList<>();

    public void setCoords(ArrayList<String> coords1) {
      if( coords == null ){
          return;
      }

//        ArrayList<String> coords1 = new ArrayList<>();
          coords = coords1;
    }

    public void setWeatherObj(ArrayList<String> weatherObj1) {
        if( weatherObj == null ){
           return  ;
        }
        weatherObj = weatherObj1;

    }


    @Getter
    @Setter
    public class coord{
        String lat;
        String lon;

     public coord(String lat, String lon) {
         this.lat = lat;
         this.lon = lon;
     }
    }

    @Getter
    @Setter
    public class weather{
        String id;
        String main;
        String description;
        String icon;

        public weather(String id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;

        }
    }

    @Getter
    @Setter
    public class main1{
        String temp;
        String humidity;
        String pressure;
        String feels_like;
        String sea_level;
        String grnd_level;
    }


}
