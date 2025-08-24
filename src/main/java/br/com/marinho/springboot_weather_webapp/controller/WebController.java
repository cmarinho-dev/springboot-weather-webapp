package br.com.marinho.springboot_weather_webapp.controller;

import br.com.marinho.springboot_weather_webapp.config.WeatherApiProperties;
import br.com.marinho.springboot_weather_webapp.model.DateHour;
import br.com.marinho.springboot_weather_webapp.model.Weather;
import br.com.marinho.springboot_weather_webapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherApiProperties weatherApiProperties;

    @GetMapping("/")
    public String showHomePage(Model model) {
        Weather weather = weatherService.getWeatherDataFrom(
                weatherApiProperties.getKey(),
                "Brasilia",
                weatherApiProperties.getDays(),
                weatherApiProperties.getLang()
        );
        model.addAttribute("weather", weather);
        model.addAttribute("date", List.of(
                new DateHour(0),
                new DateHour(1),
                new DateHour(2),
                new DateHour(3)
        ));

        return "index";
    }
}
