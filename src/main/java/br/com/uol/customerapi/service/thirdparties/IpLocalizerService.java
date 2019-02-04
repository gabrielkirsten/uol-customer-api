package br.com.uol.customerapi.service.thirdparties;

import br.com.uol.customerapi.domain.Location;
import br.com.uol.customerapi.domain.ipvigilante.IpVigilante;
import br.com.uol.customerapi.client.IpVigilanteClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IpLocalizerService {

    private IpVigilanteClient ipVigilanteClient;

    public IpLocalizerService(IpVigilanteClient ipVigilanteClient) {
        this.ipVigilanteClient = ipVigilanteClient;
    }

    public Location getLocalByIp(String IP) {

        IpVigilante ipVigilante = ipVigilanteClient.getLocalByIp("json", IP, "");

        return new Location(new BigDecimal(ipVigilante.getData().getLatitude()), new BigDecimal(ipVigilante.getData().getLongitude()));

    }
}
