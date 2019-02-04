package br.com.uol.customerapi.client.fallback;

import br.com.uol.customerapi.domain.ipvigilante.IpVigilante;
import br.com.uol.customerapi.client.IpVigilanteClient;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpVigilanteClientFallback implements IpVigilanteClient {

    private final Throwable cause;

    private Logger logger = LoggerFactory.getLogger(IpVigilanteClientFallback.class);

    IpVigilanteClientFallback(Throwable throwable) {
        this.cause = throwable;
    }


    @Override
    public IpVigilante getLocalByIp(String format, String IP, String params) {
        if (cause instanceof FeignException) {
            logger.error("[IPVIGILANTE] HTTP Error " + ((FeignException) cause).status());
        } else {
            logger.error("[IPVIGILANTE] Unknown error ");
        }

        return new IpVigilante();
    }
}
