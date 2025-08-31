package br.com.antoniolps.WeatherAPI.presentation.controller;

import br.com.antoniolps.WeatherAPI.application.service.WeatherService;
import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherResponse getWeatherByCity(@PathVariable String city) {
        return weatherService.getWeather(city);
    }
}
