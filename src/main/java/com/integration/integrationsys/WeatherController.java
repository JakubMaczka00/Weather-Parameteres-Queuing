package com.integration.integrationsys;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getWindSpeed")
    public String getWindSpeed(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedWindSpeed");
        return message.toString();
    }
    @GetMapping("/getWindDeg")
    public String getWindDeg(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedWindDeg");
        return message.toString();
    }
    @GetMapping("/getWindGust")
    public String getWindGust(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedWindGust");
        return message.toString();
    }
    @GetMapping("/getClouds")
    public String getClouds(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedClouds");
        return message.toString();
    }
    @GetMapping("/getTempMax")
    public String getTempMax(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedTempMax");
        return message.toString();
    }
    @GetMapping("/getTempMin")
    public String getTempMin(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedTempMin");
        return message.toString();
    }
    @GetMapping("/getHumidity")
    public String getHumidity(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedHumidity");
        return message.toString();
    }
    @GetMapping("/getPressure")
    public String getPressure(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedPressure");
        return message.toString();
    }
    @GetMapping("/getSeaLevel")
    public String getSeaLevel(){
        Object message = rabbitTemplate.receiveAndConvert("FormattedSeaLevel");
        return message.toString();
    }


}
