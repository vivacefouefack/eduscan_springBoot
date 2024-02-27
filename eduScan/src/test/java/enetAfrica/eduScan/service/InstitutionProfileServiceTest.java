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

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstitutionProfileServiceTest {
    
    @Autowired private InstitutionProfileService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getInstitutionProfileById(0);
    }

    @Test
    public void shouldSaveInstitutionProfileWithSuccess() {
        
        PropectionRecordDto profilDto=new PropectionRecordDto();
        InstitutionProfile profil=service.addInstitutionProfile(profilDto);

        assertNotNull(profil);
        assertNotNull(profil.getId());
        assertEquals(profilDto.getSchoolName(), profil.getSchoolName());
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getInstitutionProfileById(0));

        assertEquals(ErrorCode.INSTITUTION_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.INSTITUTION_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }


    @Test
    public void shouldGetAllProfilWithSuccess() {
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
    public void shouldGetInstitutionByIdWithSuccess() {
        InstitutionProfile profil=service.getInstitutionProfileById(1);
        assertNotNull(profil);
    }

    @Test
    public void shouldUpdateInstitutionProfileWithSuccess() {
        PropectionRecordDto profilDto=new PropectionRecordDto();
        InstitutionProfile profil=service.updateInstitutionProfile(profilDto);

        assertNotNull(profil);
        assertNotNull(profil.getId());
        assertEquals(profilDto.getSchoolName(), profil.getSchoolName());
    }

    @Test
    public void shouldDeleteProfileWithSuccess() {
        int currentSize=countElement(service.getAll());
        service.deleteInstitutionProfileById(1);
        int afterDeleteSize=countElement(service.getAll());
        assertEquals(afterDeleteSize, currentSize-1);
    }

    public int countElement(Iterable<InstitutionProfile> list){
        int counter = 0;
        for (Object i :list) {
            System.out.println(i);
            counter++;
        }
        return counter;
    }
}
