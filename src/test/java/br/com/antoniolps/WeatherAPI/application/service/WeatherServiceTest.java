package br.com.antoniolps.WeatherAPI.application.service;

import br.com.antoniolps.WeatherAPI.domain.dto.Main;
import br.com.antoniolps.WeatherAPI.domain.dto.Weather;
import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import br.com.antoniolps.WeatherAPI.infra.client.WeatherClient;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

@SpringBootTest
public class WeatherServiceTest {

    @MockitoBean
    private WeatherClient weatherClient;

    @Autowired
    private WeatherService weatherService;

    @Test
    void shouldReturnSimulatedWeatherWhenCityIsSaoPaulo() {
        Main main = new Main();
        main.setTemp(25.0);
        main.setHumidity(60.0);

        Weather weather = new Weather();
        weather.setDescription("Céu limpo");

        WeatherResponse fakeResponse = new WeatherResponse();
        fakeResponse.setMain(main);
        fakeResponse.setWeather(List.of(weather));

        Mockito.when(weatherClient.getCurrentWeather(
                Mockito.eq("São Paulo"),
                Mockito.anyString(),
                Mockito.eq("metric"),
                Mockito.eq("pt_br")
        )).thenReturn(fakeResponse);

        WeatherResponse result = weatherService.getWeather("São Paulo");

        Assertions.assertEquals(25.0, result.getMain().getTemp());
        Assertions.assertEquals(60.0, result.getMain().getHumidity());
    }

}
