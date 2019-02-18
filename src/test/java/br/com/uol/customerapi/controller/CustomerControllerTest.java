package br.com.uol.customerapi.controller;

import br.com.uol.customerapi.model.dto.CustomerDTO;
import br.com.uol.customerapi.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private CustomerDTO customerDTO = new CustomerDTO();

    private MockMvc mockMvc;

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void shouldPostCustomer() throws Exception {

        when(customerService.addNewCustomer(any(CustomerDTO.class), any(String.class))).thenReturn(customerDTO);

        mockMvc.perform(post("/customers").accept(MediaType.APPLICATION_JSON)
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\"name\" : \"Gabriel Kirsten Menezes\", \"age\" : 24}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(customerDTO.getId().toString())))
                .andExpect(jsonPath("$.name", is(customerDTO.getName())))
                .andExpect(jsonPath("$.age", is(customerDTO.getAge())));

    }

    @Test
    public void shouldGetCustomer() throws Exception {

        when(customerService.getCustomerById(customerDTO.getId())).thenReturn(customerDTO);

        mockMvc.perform(get("/customers/"+customerDTO.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(customerDTO.getId().toString())))
                .andExpect(jsonPath("$.name", is(customerDTO.getName())))
                .andExpect(jsonPath("$.age", is(customerDTO.getAge())));

    }

    @Test
    public void shouldGetAllCustomers() throws Exception {

        List<CustomerDTO> customerList = new ArrayList<>();

        customerList.add(customerDTO);

        when(customerService.getAllCustomers()).thenReturn(customerList);

        mockMvc.perform(get("/customers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id", is(customerDTO.getId().toString())))
                .andExpect(jsonPath("$[0].name", is(customerDTO.getName())))
                .andExpect(jsonPath("$[0].age", is(customerDTO.getAge())));

    }

    @Test
    public void shouldPutCustomer() throws Exception {

        when(customerService.updateCostomer(any(CustomerDTO.class))).thenReturn(customerDTO);

        mockMvc.perform(put("/customers")
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\"id\" : \""+customerDTO.getId()+"\", \"name\" : \"Gabriel Kirsten Menezes\", \"age\" : 24}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(customerDTO.getId().toString())))
                .andExpect(jsonPath("$.name", is("Gabriel Kirsten Menezes")))
                .andExpect(jsonPath("$.age", is(24)));

    }

    @Test
    public void shouldDeleteACustomer() throws Exception {

        doNothing().when(customerService).deleteCustomer(any(UUID.class));

        mockMvc.perform(delete("/customers/"+customerDTO.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }

    @Before
    public void setUp() {
        customerDTO.setId(UUID.randomUUID());
        customerDTO.setName("Gabriel Kirsten Menezes");
        customerDTO.setAge(24);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

        Mockito.reset(customerService);
    }
}