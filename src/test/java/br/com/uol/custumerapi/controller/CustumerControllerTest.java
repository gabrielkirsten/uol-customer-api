package br.com.uol.custumerapi.controller;

import br.com.uol.custumerapi.model.dto.CustumerDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CustumerControllerTest extends AbstractControllerTest {

    private CustumerDTO custumerDTO = new CustumerDTO();

    @Test
    public void shouldPostCustumer() throws Exception {

        when(custumerService.addNewCustumer(any(CustumerDTO.class))).thenReturn(custumerDTO);

        mockMvc.perform(post("/custumers").accept(MediaType.APPLICATION_JSON)
                .contentType(APPLICATION_JSON_UTF8)
                .content("{\"id\" : 1, \"nome\" : \"Gabriel Kirsten Menezes\", \"age\" : 24}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(custumerDTO.getId().intValue())))
                .andExpect(jsonPath("$.name", is(custumerDTO.getName())))
                .andExpect(jsonPath("$.age", is(custumerDTO.getAge())));

    }

    @Test
    public void shouldGetCliente() throws Exception {

        when(custumerService.getCustumerById(custumerDTO.getId())).thenReturn(custumerDTO);

        mockMvc.perform(get("/custumers/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(custumerDTO.getId().intValue())))
                .andExpect(jsonPath("$.name", is(custumerDTO.getName())))
                .andExpect(jsonPath("$.age", is(custumerDTO.getAge())));

    }

    @Test
    public void shouldGetClienteList() throws Exception {

        List<CustumerDTO> custumerList = new ArrayList<>();

        custumerList.add(custumerDTO);

        when(custumerService.getAllCustumers()).thenReturn(custumerList);

        mockMvc.perform(get("/custumers/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id", is(custumerDTO.getId().intValue())))
                .andExpect(jsonPath("$[0].name", is(custumerDTO.getName())))
                .andExpect(jsonPath("$[0].age", is(custumerDTO.getAge())));

    }

    @Before
    public void setUp() {
        super.setUp();

        custumerDTO.setId(1L);
        custumerDTO.setName("Gabriel Kirsten Menezes");
        custumerDTO.setAge(24);
    }
}