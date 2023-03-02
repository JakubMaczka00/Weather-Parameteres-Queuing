package com.integration.integrationsys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherTempMainResDTO {
    private BigDecimal temp;

    private BigDecimal feels_like;

    private BigDecimal temp_min;

    private BigDecimal temp_max;

    private BigDecimal pressure;

    private BigDecimal sea_level;

    private BigDecimal grnd_level;

    private BigDecimal humidity;

    private BigDecimal temp_kf;
}