package br.com.uol.customerapi.service.thirdparties;

import br.com.uol.customerapi.domain.Location;
import br.com.uol.customerapi.domain.Weather;
import br.com.uol.customerapi.domain.metaweather.ConsolidatedWeatherMetaWeather;
import br.com.uol.customerapi.domain.metaweather.LocationSearchMetaWeather;
import br.com.uol.customerapi.exception.LocationNotFoundException;
import br.com.uol.customerapi.exception.WeatherNotFoundException;
import br.com.uol.customerapi.feign.MetaWeatherFeign;
import br.com.uol.customerapi.util.DateUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class MetaWeatherService {

    private MetaWeatherFeign metaWeatherFeign;

    public MetaWeatherService(MetaWeatherFeign metaWeatherFeign) {
        this.metaWeatherFeign = metaWeatherFeign;
    }

    public Weather getWeather(Location location, Date date) {

        LocationSearchMetaWeather locationWithMinLocation = getLocationOfNearestCity(location);
        ConsolidatedWeatherMetaWeather consolidatedWeatherMetaWeather = getConsolidatedWeatherOnTheDateOfLocationSearch(locationWithMinLocation, date);

        return new Weather(new BigDecimal(consolidatedWeatherMetaWeather.getMaxTemp()), new BigDecimal(consolidatedWeatherMetaWeather.getMinTemp()));

    }

    private LocationSearchMetaWeather getLocationOfNearestCity(Location location) {

        String queryString = location.getLatitude().toString() + "," + location.getLongitude().toString();

        List<LocationSearchMetaWeather> locationSearchMetaWeather = metaWeatherFeign.searchWeatherOfCoordinates(queryString);

        return locationSearchMetaWeather.stream()
                .min(Comparator.comparing(LocationSearchMetaWeather::getDistance))
                .orElseThrow(LocationNotFoundException::new);

    }

    private ConsolidatedWeatherMetaWeather getConsolidatedWeatherOnTheDateOfLocationSearch(LocationSearchMetaWeather locationSearchMetaWeather, Date date) {

        List<ConsolidatedWeatherMetaWeather> locationMetaWeather = metaWeatherFeign.getConsolidatedWeatherOfLocation(locationSearchMetaWeather.getWoeid(), DateUtil.convertToPattern("yyyy/MM/dd", date));

        return locationMetaWeather.stream()
                .findFirst()
                .orElseThrow(WeatherNotFoundException::new);

    }


}
