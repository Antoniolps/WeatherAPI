package br.com.antoniolps.WeatherAPI.infra.client;

import br.com.antoniolps.WeatherAPI.domain.dto.Main;
import br.com.antoniolps.WeatherAPI.domain.dto.Weather;
import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;

import java.util.List;

public class WeatherClientFallback implements WeatherClient {

    @Override
    public WeatherResponse getCurrentWeather(String city, String apiKey, String units, String lang) {
        WeatherResponse response = new WeatherResponse();
        Main main = new Main();
        main.setTemp(0.0);
        main.setHumidity(0.0);

        Weather weather = new Weather();
        weather.setDescription("Serviço de clima indisponível");

        response.setMain(main);
        response.setWeather(List.of(weather));
        return response;
    }
}
