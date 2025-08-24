package br.com.marinho.springboot_weather_webapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record Weather(
        Location location,
        Current current,
        Forecast forecast
) {
    public record Location(
            String name,
            String region,
            String country,
            double lat,
            double lon,
            @JsonProperty("tz_id") String timezoneId,
            @JsonProperty("localtime_epoch") long localtimeEpoch,
            String localtime
    ) { }

    public record Current(
            @JsonProperty("temp_c") int temperatureC,
            Condition condition,
            int humidity,
            @JsonProperty("feelslike_c") int feelsLikeC
    ) { }

    public record Condition(
            String text,
            String icon
    ) { }

    public record Forecast(
            @JsonProperty("forecastday") List<ForecastDay> forecastDays
    ) { }

    public record ForecastDay(
            Day day
    ) { }

    public record Day(
            @JsonProperty("avgtemp_c") int averageTempC,
            Condition condition
    ) { }
}
