package br.com.uol.customerapi.feign.hystrix;

import br.com.uol.customerapi.feign.MetaWeatherFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MetaWeatherClientFallbackFactory implements FallbackFactory<MetaWeatherFeign> {
    @Override
    public MetaWeatherFeign create(Throwable throwable) {
        return new MetaWeatherClientFallback(throwable);
    }
}
