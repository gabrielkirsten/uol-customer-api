package br.com.uol.customerapi.feign.hystrix;

import br.com.uol.customerapi.feign.IpVigilanteFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class IpVigilanteClientFallbackFactory implements FallbackFactory<IpVigilanteFeign> {
    @Override
    public IpVigilanteFeign create(Throwable throwable) {
        return new IpVigilanteClientFallback(throwable);
    }
}
