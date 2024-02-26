package enetAfrica.eduScan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enetAfrica.eduScan.exception.NotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaServiceTest {
    
    @Autowired private AgendaService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getAgendaById(0);
    }



}
