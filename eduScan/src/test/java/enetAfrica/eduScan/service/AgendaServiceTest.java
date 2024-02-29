package enetAfrica.eduScan.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.Agenda;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AgendaServiceTest {
    
    @Autowired private AgendaService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getAgendaById(0);
    }

    @Test
    public void shouldSaveAgendaWithSuccess() {
        AgendaDto agendaDto=new AgendaDto();
        agendaDto.setId(1);
        agendaDto.setAccountExecutive(10);
        agendaDto.setInstitution(1);
        agendaDto.setVisitDate(LocalDate.now());
        Agenda agenda=service.addAgenda(agendaDto);
        assertNotNull(agenda);
        assertNotNull(agendaDto);
        assertEquals(agenda.getVisitDate(), agendaDto.getVisitDate());
    }

    @Test
    public void shouldSaveAgendaWithNullDto() {
        AgendaDto agendaDto=null;
        Agenda agenda=service.addAgenda(agendaDto);
        assertNull(agenda);
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getAgendaById(0));

        assertEquals(ErrorCode.AGENDA_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.AGENDA_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }


    @Test
    public void shouldGetAgendaByIdWithSuccess() {
        Agenda agenda=service.getAgendaById(10);
        assertNotNull(agenda);
    }

    @Test
    public void shouldUpdateAgendaWithSuccess() {
        AgendaDto agendaDto=new AgendaDto();
        agendaDto.setId(1);
        agendaDto.setAccountExecutive(10);
        agendaDto.setInstitution(1);
        agendaDto.setVisitDate(LocalDate.now());
        Agenda agendaSave=service.addAgenda(agendaDto);
        agendaDto.setId(agendaSave.getId());
        agendaDto.setAccountExecutive(agendaSave.getAccountExecutive().getId());
        agendaDto.setInstitution(agendaSave.getInstitution().getId());
        agendaDto.setVisitDate(agendaSave.getVisitDate());
        agendaDto.setAccountExecutive(12);
        Agenda agenda=service.updateAgenda(agendaDto);

        assertNotNull(agenda);
        assertNotNull(agenda.getId());
        assertEquals(agenda.getId(), agendaDto.getId());
        assertEquals(agenda.getVisitDate(), agendaDto.getVisitDate());
        assertEquals(agenda.getAccountExecutive().getId(), agendaDto.getAccountExecutive());
    }

    @Test
    public void shouldUpdateAgendaWithNullDto() {
        AgendaDto agendaDto=null;
        Agenda agenda=service.updateAgenda(agendaDto);
        assertNull(agenda);
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
