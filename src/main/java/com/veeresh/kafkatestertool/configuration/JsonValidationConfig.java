package com.veeresh.kafkatestertool.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veeresh.kafkatestertool.model.BaseClass;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;

@Configuration
public class JsonValidationConfig {

    @Bean
public  String readJsonFile(){
 String expectedJson=null;
    try{
        expectedJson=  new ObjectMapper().readValue(new ClassPathResource("./JsonFiles/basefile.json").getFile(), BaseClass.class).toString();

    }catch (Exception e){
        e.printStackTrace();
    }
    return expectedJson;
}

}
