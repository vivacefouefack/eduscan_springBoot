package enetAfrica.eduScan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.Agenda;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaServiceTest {
    
    @Autowired private AgendaService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getAgendaById(0);
    }

    @Test
    public void shouldSaveAgendaWithSuccess() {
        AgendaDto agendaDto=new AgendaDto();
        Agenda agenda=service.addAgenda(agendaDto);

        assertNotNull(agenda);
        assertNotNull(agenda.getId());
        assertEquals(agenda.getVisitDate(), agendaDto.getVisitDate());
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getAgendaById(0));

        assertEquals(ErrorCode.AGENDA_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.AGENDA_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }


    @Test
    public void shouldGetAllAgendaWithSuccess() {
        int counter = countElement(service.getAll());
        int all = 0;
      
        assertNotNull(service.getAll());
        assertEquals(counter, all);
    }

    @Test
    public void shouldGetAllAgendaNotFound() {
        int counter = countElement(service.getAll());
        int size=25;
        assertNotEquals(counter, size);
    }

    @Test
    public void shouldGetAgendaByIdWithSuccess() {
        Agenda agenda=service.getAgendaById(1);
        assertNotNull(agenda);
    }

    @Test
    public void shouldUpdateAgendaWithSuccess() {
        AgendaDto agendaDto=new AgendaDto();
        Agenda agenda=service.updateAgenda(agendaDto);

        assertNotNull(agenda);
        assertNotNull(agenda.getId());
        assertEquals(agenda.getId(), agendaDto.getId());
        assertEquals(agenda.getVisitDate(), agendaDto.getVisitDate());
    }

    @Test
    public void shouldDeleteAgendaWithSuccess() {
        int currentSize=countElement(service.getAll());
        service.deleteAgenda(1);
        int afterDeleteSize=countElement(service.getAll());
        assertEquals(afterDeleteSize, currentSize);
    }

    public int countElement(Iterable<Agenda> list){
        int counter = 0;
        for (Object i :list) {
            System.out.println(i);
            counter++;
        }
        return counter;
    }
}
