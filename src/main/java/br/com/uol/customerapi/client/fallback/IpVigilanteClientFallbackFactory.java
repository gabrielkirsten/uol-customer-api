package br.com.uol.customerapi.client.fallback;

import br.com.uol.customerapi.client.IpVigilanteClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class IpVigilanteClientFallbackFactory implements FallbackFactory<IpVigilanteClient> {
    @Override
    public IpVigilanteClient create(Throwable throwable) {
        return new IpVigilanteClientFallback(throwable);
    }
}
