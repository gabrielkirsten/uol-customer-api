package br.com.uol.custumerapi.service;

import br.com.uol.custumerapi.model.Custumer;
import br.com.uol.custumerapi.model.dto.CustumerDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class CustumerServiceTest extends AbstractServiceTest {

    private CustumerDTO custumerDTOWithoutID = new CustumerDTO();

    private CustumerDTO custumerDTO = new CustumerDTO();

    @Test
    public void shouldSaveANewCustumer() {

        Custumer custumerSaved = new Custumer();
        custumerSaved.setId(1L);
        custumerSaved.setName(custumerDTOWithoutID.getName());
        custumerSaved.setAge(custumerDTOWithoutID.getAge());

        when(custumerRepository.save(any(Custumer.class))).thenReturn(custumerSaved);

        custumerService.addNewCustumer(custumerDTOWithoutID);

        verify(custumerRepository, times(1)).save(any(Custumer.class));

    }

    @Test
    public void shouldGetCostumerById() {

        when(custumerRepository.getById(custumerDTO.getId())).thenReturn(new CustumerDTO().fromDTO(custumerDTO));

        CustumerDTO retornedCustumerDTO = custumerService.getCustumerById(custumerDTO.getId());

        assertTrue(custumerDTO.equals(retornedCustumerDTO));

    }

    @Test
    public void shouldGetAllCustumers() {

        List<Custumer> allCustumers = new ArrayList<>();

        Custumer custumer1 = new Custumer();
        custumer1.setId(1L);
        custumer1.setAge(1);
        custumer1.setName("Jonny");
        allCustumers.add(custumer1);

        Custumer custumer2 = new Custumer();
        custumer2.setId(2L);
        custumer2.setAge(2);
        custumer2.setName("Bob");
        allCustumers.add(custumer2);

        Custumer custumer3 = new Custumer();
        custumer3.setId(3L);
        custumer3.setAge(2);
        custumer3.setName("Alice");
        allCustumers.add(custumer3);

        when(custumerRepository.findAll()).thenReturn(allCustumers);

        assertTrue(custumerService.getAllCustumers().containsAll(allCustumers.stream().map(c -> new CustumerDTO().toDTO(c)).collect(Collectors.toList())));

    }

    @Override
    @Before
    public void setUp() {

        super.setUp();

        custumerDTO.setId(1L);
        custumerDTO.setAge(24);
        custumerDTO.setName("Gabriel Kirsten Menezes");

        custumerDTOWithoutID.setAge(24);
        custumerDTOWithoutID.setName("Gabriel Kirsten Menezes");

    }



}