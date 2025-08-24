package br.com.marinho.springboot_weather_webapp.service;

import br.com.marinho.springboot_weather_webapp.model.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherAPI", url = "${weatherapi.url}")
public interface WeatherService {

    @GetMapping("/v1/forecast.json")
    Weather getWeatherDataFrom(
            @RequestParam("key") String apiKey,
            @RequestParam("q") String location,
            @RequestParam("days")  int days,
            @RequestParam("lang") String lang
    );
}
