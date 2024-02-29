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
import org.springframework.transaction.annotation.Transactional;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InstitutionProfileServiceTest {
    
    @Autowired private InstitutionProfileService service;

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionById() {
        service.getInstitutionProfileById(0);
    }

    @Test
    public void shouldSaveInstitutionProfileWithSuccess() {
        
        PropectionRecordDto profilDto=new PropectionRecordDto();
        profilDto.setEmail("exemple@imasoftgroup.com");
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
        profilDto.setEmail("exemple@imasoftgroup.com");
        InstitutionProfile profil=service.addInstitutionProfile(profilDto);
        profilDto.setId(profil.getId());
        profilDto.setEmail(profil.getEmail());
        profilDto.setSchoolName("my school");

        profil=service.updateInstitutionProfile(profilDto);

        assertNotNull(profil);
        assertNotNull(profil.getId());
        assertEquals(profilDto.getSchoolName(), profil.getSchoolName());
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
