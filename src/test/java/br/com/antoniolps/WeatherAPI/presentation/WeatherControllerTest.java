package br.com.antoniolps.WeatherAPI.presentation;

import br.com.antoniolps.WeatherAPI.application.service.WeatherService;
import br.com.antoniolps.WeatherAPI.domain.dto.Main;
import br.com.antoniolps.WeatherAPI.domain.dto.Weather;
import br.com.antoniolps.WeatherAPI.domain.dto.WeatherResponse;
import br.com.antoniolps.WeatherAPI.presentation.controller.WeatherController;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WeatherService weatherService;

    @Test
    void shouldReturnJsonWithWeatherDataOfTheCity() throws Exception {
        Main main = new Main();
        main.setTemp(20.0);
        main.setHumidity(80.0);

        Weather weather = new Weather();
        weather.setDescription("Chuva fraca");

        WeatherResponse fakeResponse = new WeatherResponse();
        fakeResponse.setMain(main);
        fakeResponse.setWeather(List.of(weather));

        Mockito.when(weatherService.getWeather("Curitiba")).thenReturn(fakeResponse);

        Assertions.assertDoesNotThrow(() ->
                mockMvc.perform(get("/weather/Curitiba"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.main.temp").value(20.0))
                        .andExpect(jsonPath("$.main.humidity").value(80.0))
                        .andExpect(jsonPath("$.weather[0].description").value("Chuva fraca"))
        );

    }
}
