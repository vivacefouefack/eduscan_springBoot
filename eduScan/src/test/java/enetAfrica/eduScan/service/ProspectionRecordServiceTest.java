package enetAfrica.eduScan.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProspectionRecordServiceTest {

    @Autowired private ProspectionRecordService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getProspectionRecordById(-2);
    }

    @Test
    public void shouldSaveProspectionRecordWithSuccess() {
        
        PropectionRecordDto profilDto=new PropectionRecordDto();
        ProspectionRecord record=service.addProspectionRecord(profilDto);

        assertNotNull(record);
        assertNotNull(record.getId());
        assertEquals(profilDto.getSchoolName(), record.getSchoolName());
    }

    @Test
    public void shouldSaveProspectionRecordWithFailure() {
        
        PropectionRecordDto profilDto=null;// à revoir
        ProspectionRecord record=service.addProspectionRecord(profilDto);

        assertNull(record);
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getProspectionRecordById(0));

        assertEquals(ErrorCode.PROSPECTION_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.PROSPECTION_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }


    @Test
    public void shouldGetAllProspectionRecordWithSuccess() {
        int counter = countElement(service.getAllProspectionRecord());
        int all = 1;
      
        assertNotNull(service.getAllProspectionRecord());
        assertEquals(counter, all);
    }

    @Test
    public void shouldGetAllProspectionRecordWithFailure() {
        int counter = countElement(service.getAllProspectionRecord());
        int size=-25;
        assertNotEquals(counter, size);
    }

    @Test
    public void shouldGetProspectionRecordByIdWithSuccess() {
        ProspectionRecord record=service.getProspectionRecordById(1);
        assertNotNull(record);
    }

    @Test
    public void shouldUpdateProspectionRecordWithSuccess() {
        PropectionRecordDto profilDto=new PropectionRecordDto();
        ProspectionRecord record=service.updateProspectionRecord(profilDto);

        assertNotNull(record);
        assertNotNull(record.getId());
        assertEquals(profilDto.getSchoolName(), record.getSchoolName());
    }

    @Test
    public void shouldDeleteProspectionRecordWithSuccess() {
        int currentSize=countElement(service.getAllProspectionRecord());
        service.deleteProspectionRecord(1);
        int afterDeleteSize=countElement(service.getAllProspectionRecord());
        assertEquals(afterDeleteSize, currentSize-1);
    }

    public int countElement(Iterable<ProspectionRecord> list){
        int counter = 0;
        for (Object i :list) {
            System.out.println(i);
            counter++;
        }
        return counter;
    }
}
