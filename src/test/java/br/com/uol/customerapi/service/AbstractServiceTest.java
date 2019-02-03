package br.com.uol.customerapi.service;

import br.com.uol.customerapi.repository.CustomerRepository;
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
    protected CustomerRepository customerRepository;

    @Autowired
    protected CustomerService customerService;

    @Before
    public void setUp() {
        Mockito.reset(customerRepository);
    }

}
