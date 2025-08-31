package br.com.antoniolps.WeatherAPI.infra.client;

import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "https://api.openweathermap.org/data/2.5", fallback = WeatherClientFallback.class)
public interface WeatherClient {

    @GetMapping("/weather")
    WeatherResponse getCurrentWeather(
            @RequestParam("q") String city,
            @RequestParam("appid") String apiKey,
            @RequestParam("units") String units,
            @RequestParam("lang") String lang
    );
}
