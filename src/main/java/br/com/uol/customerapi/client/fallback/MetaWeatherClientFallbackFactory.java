package br.com.uol.customerapi.client.fallback;

import br.com.uol.customerapi.client.MetaWeatherClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class MetaWeatherClientFallbackFactory implements FallbackFactory<MetaWeatherClient> {
    @Override
    public MetaWeatherClient create(Throwable throwable) {
        return new MetaWeatherClientFallback(throwable);
    }
}
