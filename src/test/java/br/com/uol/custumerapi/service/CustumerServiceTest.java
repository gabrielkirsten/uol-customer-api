package br.com.uol.custumerapi.service;

import br.com.uol.custumerapi.model.Custumer;
import br.com.uol.custumerapi.model.dto.CustumerDTO;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustumerServiceTest extends AbstractServiceTest {

    private CustumerDTO custumerDTOWithoutID = new CustumerDTO();

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

    @Override
    @Before
    public void setUp() {
        super.setUp();

        custumerDTOWithoutID.setAge(24);
        custumerDTOWithoutID.setName("Gabriel Kirsten Menezes");
    }
}