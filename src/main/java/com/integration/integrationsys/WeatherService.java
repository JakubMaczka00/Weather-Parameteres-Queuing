package com.integration.integrationsys;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Component

public class WeatherService {
    private String key = "5cc257dea729ff1b4153d3ca4abd681d";
    private GetDataFromApi getDataFromApi;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public OpenWeatherMainResDTO getWeatherToRabbit() {
        GetDataFromApi getDataFromApi = new GetDataFromApi(this.key);
        OpenWeatherMainResDTO main = getDataFromApi.getResult();
        return main;
    }

    @Scheduled(fixedRate = 20000)
    public void getDataFromApi() {
        System.out.println("Start getting data ");
        System.out.println( "API Data from OpenWeatherAPI : " + getWeatherToRabbit().getList().get(0).getWind().getSpeed().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getWind().getDeg().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getWind().getGust().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getClouds().getAll().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getMain().getTemp_max().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getMain().getTemp_min().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getMain().getHumidity().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getMain().getPressure().toString() + '\n' +
                getWeatherToRabbit().getList().get(0).getMain().getSea_level().toString());

        rabbitTemplate.convertAndSend("WindSpeed", getWeatherToRabbit().getList().get(0).getWind().getSpeed());
        rabbitTemplate.convertAndSend("WindDeg", getWeatherToRabbit().getList().get(0).getWind().getDeg());
        rabbitTemplate.convertAndSend("WindGust", getWeatherToRabbit().getList().get(0).getWind().getGust());
        rabbitTemplate.convertAndSend("Clouds", getWeatherToRabbit().getList().get(0).getClouds().getAll());
        rabbitTemplate.convertAndSend("Temp_max", getWeatherToRabbit().getList().get(0).getMain().getTemp_max());
        rabbitTemplate.convertAndSend("Temp_min", getWeatherToRabbit().getList().get(0).getMain().getTemp_min());
        rabbitTemplate.convertAndSend("Humidity", getWeatherToRabbit().getList().get(0).getMain().getHumidity());
        rabbitTemplate.convertAndSend("Pressure", getWeatherToRabbit().getList().get(0).getMain().getPressure());
        rabbitTemplate.convertAndSend("Sea_level", getWeatherToRabbit().getList().get(0).getMain().getSea_level());

    }
    @RabbitListener(queues = "WindSpeed")
    public void speedListener(String s) {
        System.out.println("Data from WindSpeed queue " + s);
        s = "Wind speed from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedWindSpeed",s);

    }
    @RabbitListener(queues = "WindDeg")
    public void degListener(String s) {
        System.out.println("Data from WindDeg queue " + s);
        s = "Wind deg from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedWindDeg",s);

    }
    @RabbitListener(queues = "WindGust")
    public void gustListener(String s) {
        System.out.println("Data from WindGust queue " + s);
        s = "Wind gust from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedWindGust",s);
    }
    @RabbitListener(queues = "Clouds")
    public void cloudsListener(String s) {
        System.out.println("Data from Clouds queue " + s);
        s = "Clouds from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedClouds",s);

    }
    @RabbitListener(queues = "Temp_max")
    public void tempMaxListener(String s) {
        System.out.println("Data from TempMax queue " + s);
        s = "Temp Max from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedTempMax",s);

    }
    @RabbitListener(queues = "Temp_min")
    public void tempMinListener(String s) {
        System.out.println("Data from TempMin queue " + s);
        s = "Temp Min from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedTempMin",s);

    }
    @RabbitListener(queues = "Humidity")
    public void humidityListener(String s) {
        System.out.println("Data from Humidity queue " + s);
        s = "Humidity from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedHumidity",s);

    }
    @RabbitListener(queues = "Pressure")
    public void pressureListener(String s) {
        System.out.println("Data from Pressure queue " + s);
        s = "Pressure from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedPressure",s);

    }
    @RabbitListener(queues = "Sea_level")
    public void seaLevelListener(String s) {
        System.out.println("Data from SeaLevel queue " + s);
        s = "Sea Level from " + getDate() + " is " + s ;
        rabbitTemplate.convertAndSend("FormattedSeaLevel",s);

    }
    public LocalDateTime getDate(){
        return LocalDateTime.now();
    }






}
