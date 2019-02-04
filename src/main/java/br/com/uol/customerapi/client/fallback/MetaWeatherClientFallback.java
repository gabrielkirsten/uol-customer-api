package br.com.uol.customerapi.client.hystrix;

import br.com.uol.customerapi.domain.metaweather.ConsolidatedWeatherMetaWeather;
import br.com.uol.customerapi.domain.metaweather.LocationSearchMetaWeather;
import br.com.uol.customerapi.exception.WeatherNotFoundException;
import br.com.uol.customerapi.client.MetaWeatherClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MetaWeatherClientFallback implements MetaWeatherClient {

    private final Throwable cause;

    private Logger logger = LoggerFactory.getLogger(MetaWeatherClientFallback.class);

    MetaWeatherClientFallback(Throwable throwable) {
        this.cause = throwable;
    }

    @Override
    public List<LocationSearchMetaWeather> searchWeatherOfCoordinates(String latitudeAndLongitude) {
        if (cause instanceof FeignException) {
            logger.error("[METAWEATHER] HTTP Error " + ((FeignException) cause).status());
        } else {
            logger.error("[METAWEATHER] Unknown error ");
        }
        throw new WeatherNotFoundException();
    }

    @Override
    public List<ConsolidatedWeatherMetaWeather> getConsolidatedWeatherOfLocation(String whereOnEarthID, String date) {
        if (cause instanceof FeignException) {
            logger.error("[METAWEATHER] HTTP Error " + ((FeignException) cause).status());
        } else {
            logger.error("[METAWEATHER] Unknown error ");
        }
        throw new WeatherNotFoundException();
    }
}
