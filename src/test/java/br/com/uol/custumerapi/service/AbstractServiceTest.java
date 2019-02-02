package br.com.uol.custumerapi.service;

import br.com.uol.custumerapi.repository.CustumerRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractServiceTest {

    @MockBean
    protected CustumerRepository custumerRepository;

    @Autowired
    protected CustumerService custumerService;

    @Before
    public void setUp() {
        Mockito.reset(custumerRepository);
    }

}
