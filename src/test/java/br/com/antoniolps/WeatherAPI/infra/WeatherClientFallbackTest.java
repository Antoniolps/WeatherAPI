package br.com.antoniolps.WeatherAPI.infra;

import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import br.com.antoniolps.WeatherAPI.infra.client.WeatherClient;
import br.com.antoniolps.WeatherAPI.infra.client.WeatherClientFallback;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherClientFallbackTest {

    private final WeatherClient fallback = new WeatherClientFallback();

    @Test
    void shouldReturnStandardMessageWhenServiceIsUnavailable() {
        WeatherResponse response = fallback.getCurrentWeather("São Paulo", "fake", "metric", "pt_br");

        Assertions.assertEquals(0.0, response.getMain().getTemp());
        Assertions.assertEquals("Serviço de clima indisponível", response.getWeather().get(0).getDescription());
    }
}
