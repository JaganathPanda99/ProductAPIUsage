package com.example.ProductAPIsUsage.dtos;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Getter
@Setter

public class OpenWeatherServiceDto {


    String id;
    String name;
    String timezone;
    String cod;
//    ArrayList<Weather.coord> coords;
//    ArrayList<weather> weatherObj;
//    ArrayList<Weather.main1> main1Obj;


    ArrayList<coord> coordsObj = new ArrayList<>();
    ArrayList<String> weatherObj = new ArrayList<String>();
    ArrayList<main1> main1Obj = new ArrayList<>();

    public ArrayList<String> getCoordsObj(JsonNode coordNode) {
//        this.coordsObj = coordsObj;
        JsonNode lon = coordNode.get("lon");
        JsonNode lat = coordNode.get("lat");
        ArrayList<String> coordsObj1 = new ArrayList<>( );
        coordsObj1.add(lon.toString() );
        coordsObj1.add(lat.toString() );
//        coordsObj1.add("14.44");
        return coordsObj1;
    }


    public ArrayList<String> getWeatherObj(JsonNode weatherNode ) {

        ArrayList<String> weatherObj1 = new ArrayList<>( );
//        JsonNode mainNode = weatherNode.at("main");
         JsonNodeType type = weatherNode.getNodeType();
        Iterator<JsonNode> iterator = weatherNode.iterator();
        while( iterator.hasNext() ) {
            weatherObj1.add(iterator.next().toString() );
//            Array data = iterator.next().to;
//            weatherObj1.add(data.toString());
        }

        ArrayNode arrayNode = (ArrayNode) weatherNode.get("main");
        if( arrayNode != null ) {
            StreamSupport.stream(arrayNode.spliterator(), false)
                    .forEach(element -> weatherObj1.add(element.toString()));
        }


//        weatherObj1.add(String.valueOf(.get(id)));
//        weatherObj1.add( weatherNode.get("main").toString() );
//        weatherObj.add( weatherNode.get("description").toString() );
//        weatherObj.add( weatherNode.get("icon").toString() );
        this.weatherObj = weatherObj1;
        return weatherObj;
    }

    @Getter
    @Setter
    public class coord{
        String lat;
        String lon;

        public void setCoords() {
            this.lat = lat;
            this.lon = lon;
        }
    }

    @Getter
    @Setter
    public class weather {
        String main;
        String description;
        String icon;
        String id;

        public weather(String id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;

        }
    }

    @Getter
    @Setter
    public class main1 {
        String temp;
        String humidity;
        String pressure;
        String feels_like;
        String sea_level;
        String grnd_level;
    }


//    JsonNode jsonObject1 = new ObjectMapper().readTree(getId());
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    //Create the JSON object received when instantiated
//    JsonNode jsonObject = objectMapper.createObjectNode();
//    JsonNode weatherHead =  jsonObject.get("weather");    // Get JsonObj-->Weather
//    JsonNode main1 = jsonObject.get("main");             //  Get JsonObj-->Main
//
//     String id = weatherHead.get("id").asText();
//    String description = weatherHead.get("description").asText();
//    String weatherType = weatherHead.get("main").asText();
//    String icon = weatherHead.get("icon").asText();
//    String temp = main1.get("temp").asText();
//    String temp_min = main1.get("temp_min").asText();
//    String temp_max = main1.get("temp_max").asText();
//    String pressure = main1.get("humidity").asText();
//    String feels_like = main1.get("feels_like").asText();
////    String wind_direction = main1.get("wind_direction").asText();
//    String humid = main1.get("humidity").asText();
//

    public OpenWeatherServiceDto() throws JsonProcessingException {


//    JsonNode jsonObject1 = new ObjectMapper().createObjectNode();
////      readTree(JsonNode);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //Create the JSON object received when instantiated
//        JsonNode jsonObject = objectMapper.createObjectNode();
//        JsonNode weatherHead =  jsonObject.get("weather");    // Get JsonObj-->Weather
//        JsonNode main1 = jsonObject.get("main");             //  Get JsonObj-->Main

//        String id = weatherHead.get("id").asText();
//        String description = weatherHead.get("description").asText();
//        String weatherType = weatherHead.get("main").asText();
//        String icon = weatherHead.get("icon").asText();
//        String temp = main1.get("temp").asText();
//        String temp_min = main1.get("temp_min").asText();
//        String temp_max = main1.get("temp_max").asText();
//        String pressure = main1.get("humidity").asText();
//        String feels_like = main1.get("feels_like").asText();
////    String wind_direction = main1.get("wind_direction").asText();
//        String humid = main1.get("humidity").asText();
    }

}
