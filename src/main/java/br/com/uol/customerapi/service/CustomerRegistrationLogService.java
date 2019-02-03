package br.com.uol.customerapi.service;

import br.com.uol.customerapi.domain.Location;
import br.com.uol.customerapi.domain.Weather;
import br.com.uol.customerapi.model.Customer;
import br.com.uol.customerapi.model.CustomerRegistrationLog;
import br.com.uol.customerapi.repository.CustomerRegistrationLogRepository;
import br.com.uol.customerapi.service.thirdparties.IpLocalizerService;
import br.com.uol.customerapi.service.thirdparties.MetaWeatherService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerRegistrationLogService {

    IpLocalizerService ipLocalizerService;

    MetaWeatherService metaWeatherService;

    CustomerRegistrationLogRepository customerRegistrationLogRepository;

    public CustomerRegistrationLogService(IpLocalizerService ipLocalizerService, MetaWeatherService metaWeatherService, CustomerRegistrationLogRepository customerRegistrationLogRepository) {
        this.ipLocalizerService = ipLocalizerService;
        this.metaWeatherService = metaWeatherService;
        this.customerRegistrationLogRepository = customerRegistrationLogRepository;
    }

    public CustomerRegistrationLog createNew(Customer customer, String IP) {

        CustomerRegistrationLog customerRegistrationLog = new CustomerRegistrationLog();

        Location location = ipLocalizerService.getLocalByIp(IP);
        Weather weather = metaWeatherService.getWeather(location, new Date());
        customerRegistrationLog.setMaxTemperature(weather.getMaxTemperature());
        customerRegistrationLog.setMinTemperature(weather.getMinTemperature());
        customerRegistrationLog.setCustomer(customer);

        return customerRegistrationLogRepository.save(customerRegistrationLog);

    }

}
