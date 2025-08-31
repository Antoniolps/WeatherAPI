package br.com.antoniolps.WeatherAPI.application.service;

import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import br.com.antoniolps.WeatherAPI.infra.client.WeatherClient;
import br.com.antoniolps.WeatherAPI.infra.config.ProjectDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final ProjectDetails projectDetails;
    private final WeatherClient weatherClient;

    public WeatherResponse getWeather(String city) {
        return weatherClient.getCurrentWeather(city, projectDetails.getApiKey(), "metric", "pt_br");
    }
}
