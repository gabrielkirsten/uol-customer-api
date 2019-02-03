package br.com.uol.customerapi.service;

import br.com.uol.customerapi.model.Customer;
import br.com.uol.customerapi.model.dto.CustomerDTO;
import br.com.uol.customerapi.repository.CustomerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<CustomerDTO> customers;

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO addNewCustomer(CustomerDTO customerDto) {
        Customer newCustomer = customerRepository.save(customerDto.fromDTO(customerDto));
        return new CustomerDTO().toDTO(newCustomer);
    }

    @Cacheable("customers")
    public CustomerDTO getCustomerById(Long id) {
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

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
