package br.com.uol.custumerapi.controller;

import br.com.uol.custumerapi.model.dto.CustumerDTO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
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

    @Override
    @Before
    public void setUp() {
        super.setUp();

        custumerDTO.setId(1L);
        custumerDTO.setName("Gabriel Kirsten Menezes");
        custumerDTO.setAge(24);
    }
}