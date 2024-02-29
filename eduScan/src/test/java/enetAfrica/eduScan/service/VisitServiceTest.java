package enetAfrica.eduScan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.Visit;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VisitServiceTest {
    
    @Autowired private VisitService service;  

    @Test
    public void shouldSaveVisitWithSuccess() {
        VisitDto visitDto=new VisitDto();
        visitDto.setVisitDate(LocalDate.now());
        visitDto.setAccountExecutive(10);
        visitDto.setProspectingRecord(1);
        Visit visit=service.addVisit(visitDto);

        assertNotNull(visit);
        assertNotNull(visit.getId());
        assertEquals(visit.getVisitDate(),visitDto.getVisitDate());
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getVisitById(0));

        assertEquals(ErrorCode.VISIT_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.VISIT_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionIdNotExist() {
        service.getVisitById(0);
    }

    @Test
    public void shouldGetAllVisitWithSuccess() {
        int counter = countElement(service.getAllVisit());
        int current = 0;
      
        assertNotNull(service.getAllVisit());
        assertEquals(counter, current);
    }

    @Test
    public void shouldGetAllVisitNotFound() {
        int counter = countElement(service.getAllVisit());
        int size=25;
         
        assertNotNull(service.getAllVisit());
        assertNotEquals(counter, size);
    }

    @Test
    public void shouldGetVisitByIdWithSuccess() {
        Visit visit=service.getVisitById(1);
        assertNotNull(visit);
    }

    @Test
    public void shouldUpdateVisitWithSuccess() {
        VisitDto visitDto=new VisitDto();
        visitDto.setVisitDate(LocalDate.now());
        visitDto.setAccountExecutive(10);
        visitDto.setProspectingRecord(1);
        Visit visit=service.addVisit(visitDto);
        visitDto.setId(visit.getId());
        visitDto.setAccountExecutive(12);
        visitDto.setProspectingRecord(1);
        visit=service.updateVisit(visitDto);

        assertNotNull(visit);
        assertNotNull(visit.getId());
        assertEquals(visit.getVisitDate(),visitDto.getVisitDate());
        assertEquals(visit.getAccountExecutive().getId(),visitDto.getAccountExecutive());
    }

    public int countElement(Iterable<Visit> list){
        int counter = 0;
        for (Object i :list) {
            System.out.println(i);
            counter++;
        }
        return counter;
    }
}
