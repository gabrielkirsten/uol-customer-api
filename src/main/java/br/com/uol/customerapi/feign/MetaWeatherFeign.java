package br.com.uol.customerapi.feign;

import br.com.uol.customerapi.domain.metaweather.ConsolidatedWeatherMetaWeather;
import br.com.uol.customerapi.domain.metaweather.LocationSearchMetaWeather;
import br.com.uol.customerapi.feign.hystrix.MetaWeatherClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "metaWeather", url = "${feign.metaweather.url}", fallbackFactory = MetaWeatherClientFallbackFactory.class)
public interface MetaWeatherFeign {

    @GetMapping("location/search/")
    List<LocationSearchMetaWeather> searchWeatherOfCoordinates(@RequestParam("lattlong") String latitudeAndLongitude);

    @GetMapping("location/{whereOnEarthID}/{date}")
    List<ConsolidatedWeatherMetaWeather> getConsolidatedWeatherOfLocation(@PathVariable("whereOnEarthID") String whereOnEarthID, @PathVariable("date") String date);

}
