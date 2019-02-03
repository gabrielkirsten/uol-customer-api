package br.com.uol.customerapi.service;

import br.com.uol.customerapi.model.Customer;
import br.com.uol.customerapi.model.dto.CustomerDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class CustomerServiceTest extends AbstractServiceTest {

    private CustomerDTO customerDTOWithoutID = new CustomerDTO();

    private CustomerDTO customerDTO = new CustomerDTO();

    @Test
    public void shouldSaveANewCustomer() {

        Customer customerSaved = new Customer();
        customerSaved.setId(1L);
        customerSaved.setName(customerDTOWithoutID.getName());
        customerSaved.setAge(customerDTOWithoutID.getAge());

        when(customerRepository.save(any(Customer.class))).thenReturn(customerSaved);

        customerService.addNewCustomer(customerDTOWithoutID);

        verify(customerRepository, times(1)).save(any(Customer.class));

    }

    @Test
    public void shouldGetCostumerById() {

        when(customerRepository.getById(customerDTO.getId())).thenReturn(new CustomerDTO().fromDTO(customerDTO));

        CustomerDTO retornedCustomerDTO = customerService.getCustomerById(customerDTO.getId());

        assertTrue(customerDTO.equals(retornedCustomerDTO));

    }

    @Test
    public void shouldGetAllCustomers() {

        List<Customer> allCustomers = new ArrayList<>();

        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setAge(1);
        customer1.setName("Jonny");
        allCustomers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setAge(2);
        customer2.setName("Bob");
        allCustomers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setAge(2);
        customer3.setName("Alice");
        allCustomers.add(customer3);

        when(customerRepository.findAll()).thenReturn(allCustomers);

        assertTrue(customerService.getAllCustomers().containsAll(allCustomers.stream().map(c -> new CustomerDTO().toDTO(c)).collect(Collectors.toList())));

    }

    @Test
    public void shouldUpdateACustomer() {

        when(customerRepository.save(any(Customer.class))).thenReturn(customerDTO.fromDTO(customerDTO));

        customerService.updateCostomer(customerDTO);

        verify(customerRepository, times(1)).save(any(Customer.class));

    }

    @Test
    public void shouldDeleteCustomer() {

        doNothing().when(customerRepository).deleteById(any(Long.class));

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(any(Long.class));

    }

    @Override
    @Before
    public void setUp() {

        super.setUp();

        customerDTO.setId(1L);
        customerDTO.setAge(24);
        customerDTO.setName("Gabriel Kirsten Menezes");

        customerDTOWithoutID.setAge(24);
        customerDTOWithoutID.setName("Gabriel Kirsten Menezes");

    }



}