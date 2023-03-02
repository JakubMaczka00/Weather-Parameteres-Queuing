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

public class OpenWeatherWindResDTO {
    private BigDecimal speed;

    private BigDecimal deg;

    private BigDecimal gust;

}