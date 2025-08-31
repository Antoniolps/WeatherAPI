package br.com.antoniolps.WeatherAPI.infra.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ProjectDetails {

    @Value("${weather.api.key}")
    private String apiKey;
}
