package com.integration.integrationsys;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
@Getter
@Setter
@NoArgsConstructor
public class GetDataFromApi {
    private String key = "5cc257dea729ff1b4153d3ca4abd681d";
    private final static String FULLY_5_DAYS_FORECAST = "https://api.openweathermap.org/data/2.5/forecast";
    public final static String DEFAULT_UNIT = "metric";
    public final static String LANG = "en";
    public final static String EXCLUDE = "minutely,hourly";
    private double x = 52.237049;
    private double y = 21.017532;
    private Object response;

    public GetDataFromApi( String key){
        this.key = key;
    }

    public void getWeatherFromApi(){

        RestTemplate restTemplate = new RestTemplate();
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(FULLY_5_DAYS_FORECAST)
                .queryParam("appid", this.key)
                .queryParam("lat", x)
                .queryParam("lon", y)
                .queryParam("units", DEFAULT_UNIT)
                .queryParam("exclude", EXCLUDE)
                .queryParam("lang", LANG)
                .build();
        try {
            this.response = restTemplate.getForObject(builder.toUriString(), Object.class);
        } catch (Exception e) {
            System.out.println("Cannot get response from ");
        }

    }

    @SneakyThrows
    public String getResultAsString(){
        if(this.response == null)
            return null;
        return new ObjectMapper().writeValueAsString(this.response);

    }

    public OpenWeatherMainResDTO getResult(){
        getWeatherFromApi();
        return resultCast();
    }

    private OpenWeatherMainResDTO resultCast(){
        if(this.response == null)
            return null;

        return
                new ObjectMapper().convertValue(
                        this.response,
                        new TypeReference<OpenWeatherMainResDTO>() {});
    }
}
