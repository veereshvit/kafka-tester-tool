package com.veeresh.kafkatestertool.controller;


import com.veeresh.kafkatestertool.subscriber.BaseClassConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

@Autowired
    BaseClassConsumer baseClassConsumer;

    @RequestMapping(value = "/ValidateTopicData", method = RequestMethod.GET)
    public String RecordData(){
        return baseClassConsumer.getBaseClassRecord();

    }



}
