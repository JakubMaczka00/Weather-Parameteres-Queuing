package com.integration.integrationsys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherListResDTO {


    private Long dt;

    private OpenWeatherTempMainResDTO main;

    private List<OpenWeatherWeatherResDTO> weather;

    private OpenWeatherCloudsResDTO clouds;

    private OpenWeatherWindResDTO wind;
    private Map<String, BigDecimal> snow;

    private Integer visibility;

    private Integer pop;
    private OpenWeatherSysDTO sys;

    private String dt_txt;

    private Map<String, BigDecimal> rain;
}
