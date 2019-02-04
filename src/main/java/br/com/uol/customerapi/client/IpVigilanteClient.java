package br.com.uol.customerapi.client;

import br.com.uol.customerapi.domain.ipvigilante.IpVigilante;
import br.com.uol.customerapi.client.fallback.IpVigilanteClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ipVigilante", url = "${feign.ipvigilante.url}", fallbackFactory = IpVigilanteClientFallbackFactory.class)
public interface IpVigilanteClient {

    @GetMapping("{format}/{IP}/{params}")
    IpVigilante getLocalByIp(@PathVariable("format") String format, @PathVariable("IP") String IP, @PathVariable("params") String params);

}