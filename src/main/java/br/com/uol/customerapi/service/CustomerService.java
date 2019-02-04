package br.com.uol.customerapi.service;

import br.com.uol.customerapi.model.Customer;
import br.com.uol.customerapi.model.dto.CustomerDTO;
import br.com.uol.customerapi.repository.CustomerRepository;
import org.aspectj.apache.bcel.generic.InstructionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    private List<CustomerDTO> customers;

    private CustomerRepository customerRepository;

    private CustomerRegistrationLogService customerRegistrationLogService;

    private Logger logger = LoggerFactory.getLogger(CustomerService.class);

    public CustomerService(CustomerRepository customerRepository, CustomerRegistrationLogService customerRegistrationLogService) {
        this.customerRepository = customerRepository;
        this.customerRegistrationLogService = customerRegistrationLogService;
    }

    public CustomerDTO addNewCustomer(CustomerDTO customerDto, String requestSourceIP) {

        Customer newCustomer = customerRepository.save(customerDto.fromDTO(customerDto));

        try {
            customerRegistrationLogService.createNew(newCustomer, requestSourceIP);
        } catch (Exception e) {
            logger.error("Error generating Customer Registration Log Service, Log not generated!");
        }

        return new CustomerDTO().toDTO(newCustomer);

    }

    @Cacheable("customers")
    public CustomerDTO getCustomerById(UUID id) {
        return new CustomerDTO().toDTO(customerRepository.getById(id));
    }

    public List<CustomerDTO> getAllCustomers() {

        List<CustomerDTO> allCustomers = new ArrayList<>();

        customerRepository.findAll().forEach(c -> allCustomers.add(new CustomerDTO().toDTO(c)));

        return allCustomers;

    }

    public CustomerDTO updateCostomer(CustomerDTO customerDTO) {
        return new CustomerDTO().toDTO(customerRepository.save(customerDTO.fromDTO(customerDTO)));
    }

    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

}
