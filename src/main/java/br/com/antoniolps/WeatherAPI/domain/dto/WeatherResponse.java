package br.com.antoniolps.WeatherAPI.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private Main main;
    private List<Weather> weather;
}
