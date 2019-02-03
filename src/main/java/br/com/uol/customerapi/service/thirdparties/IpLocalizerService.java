package br.com.uol.customerapi.service.thirdparties;

import br.com.uol.customerapi.domain.Location;
import br.com.uol.customerapi.domain.ipvigilante.IpVigilante;
import br.com.uol.customerapi.feign.IpVigilanteFeign;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IpLocalizerService {

    private IpVigilanteFeign ipVigilanteFeign;

    public IpLocalizerService(IpVigilanteFeign ipVigilanteFeign) {
        this.ipVigilanteFeign = ipVigilanteFeign;
    }

    public Location getLocalByIp(String IP) {

        IpVigilante ipVigilante = ipVigilanteFeign.getLocalByIp("json", IP, "");

        return new Location(new BigDecimal(ipVigilante.getData().getLatitude()), new BigDecimal(ipVigilante.getData().getLongitude()));

    }
}
