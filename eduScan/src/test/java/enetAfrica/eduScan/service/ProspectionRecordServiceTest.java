package enetAfrica.eduScan.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;

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
        profilDto.setSchoolName("Ecole d informatique");
        profilDto.setMunicipality("Cocody");
        profilDto.setDistrict("District");
        profilDto.setGeographicAddress("Riviera 2");
        profilDto.setSchoolType("Ecole public");
        profilDto.setTeachingType("Type d'enseignement");
        profilDto.setTeachingLevel("Niveau d'enseignement");
        profilDto.setEnrollment(100);
        profilDto.setContactPhone("0523456789"); 
        profilDto.setEmail("eduScan@imasoftGroup.com");
        profilDto.setHasComputer(true);
        profilDto.setTotalComputers(50); 
        //profilDto.setSchoolPhoto("Src/images/photo.jpg");
        profilDto.setSeniority(5); 
        profilDto.setFirstVisitDate(LocalDate.of(2023, 10, 15)); 
        profilDto.setInterlocutorFirstName("Prénom de l'interlocuteur");
        profilDto.setInterlocutorLastName("Nom de l'interlocuteur");
        profilDto.setInterlocutorFunction("Fonction de l'interlocuteur");
        profilDto.setHasInternet(true);
        profilDto.setConnectionType("Fibre optique");
        profilDto.setRouterType("Type de routeur");
        profilDto.setTelecomOperator("Opérateur télécom");
        profilDto.setHasComputerRoom(true);
        profilDto.setHasElectricity(true);
        profilDto.setHasManagementSoftware(true);
        profilDto.setSoftwareName("Enet");
        profilDto.setVisitTime(LocalTime.of(9, 0)); 
        profilDto.setEndTime(LocalTime.of(12, 0));
        ProspectionRecord record=service.addProspectionRecord(profilDto);

        assertNotNull(record);
        assertNotNull(record.getId());
        assertEquals(profilDto.getSchoolName(), record.getSchoolName());
    }

    @Test
    public void shouldSaveProspectionRecordWithFailure() {  
        PropectionRecordDto profilDto=null;
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
        profilDto.setId(1);
        profilDto.setDistrict("abidjan");
        ProspectionRecord recordSave=service.addProspectionRecord(profilDto);
        profilDto.setId(recordSave.getId());
        recordSave.setDistrict("man");
        ProspectionRecord record=service.updateProspectionRecord(profilDto);

        assertNotNull(record);
        assertNotNull(record.getId());
        assertEquals(profilDto.getSchoolName(), record.getSchoolName());
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
