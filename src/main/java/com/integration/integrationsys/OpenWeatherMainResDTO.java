package com.integration.integrationsys;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMainResDTO {

    private String cod;

    private Integer message;

    private String cnt;

    private List<OpenWeatherListResDTO> list;

    private Object city;



}
