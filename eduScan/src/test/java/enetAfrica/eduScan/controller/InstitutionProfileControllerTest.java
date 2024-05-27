package enetAfrica.eduScan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import enetAfrica.eduScan.dto.InstitutionDto;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;

@RunWith(SpringRunner.class)
@WebMvcTest(InstitutionProfileController.class)
public class InstitutionProfileControllerTest {
    
    @Autowired private MockMvc mvc;

    @MockBean private InstitutionProfileService service;
/*
    @Test
    public void testGetInstitutionByIdFailure() throws Exception{
        Mockito.when(service.getInstitutionProfileById(null)).thenReturn(null);
            mvc.perform(get("/api/institution/get/null"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testNoInstitutionExist() throws Exception {
        List<InstitutionProfile> emptyList = new ArrayList<>();
        Mockito.when(service.getAll()).thenReturn(emptyList);

        mvc.perform(get("/api/institution/getall"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetInstitutionByIdSuccess() throws Exception {
        int id = 1; 
        InstitutionProfile institutionProfile = new InstitutionProfile();
        institutionProfile.setId(id);

        Mockito.when(service.getInstitutionProfileById(id)).thenReturn(institutionProfile);

        mvc.perform(get("/api/institution/get/{id}", id))
           .andExpect(status().isOk());
    }


    @Test
    public void testAddInstitutionProfileSuccess() throws Exception {
        PropectionRecordDto profileDto = new PropectionRecordDto(); 

        InstitutionProfile institutionProfile = new InstitutionProfile(); 

        Mockito.when(service.addInstitutionProfile(Mockito.any(InstitutionDto.class))).thenReturn(institutionProfile);

        ObjectMapper objectMapper = new ObjectMapper();
        String profileDtoJson = objectMapper.writeValueAsString(profileDto);

        mvc.perform(post("/api/institution/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(profileDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateInstitutionProfileSuccess() throws Exception {
        PropectionRecordDto profileDto = new PropectionRecordDto(); 
        InstitutionProfile institutionProfile = new InstitutionProfile(); 
    
        Mockito.when(service.updateInstitutionProfile(Mockito.any(InstitutionDto.class))).thenReturn(institutionProfile);
    
        ObjectMapper objectMapper = new ObjectMapper();
        String profileDtoJson = objectMapper.writeValueAsString(profileDto);
    
        mvc.perform(put("/api/institution/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(profileDtoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteInstitutionProfileSuccess() throws Exception {
        Integer id = 1; 
        mvc.perform(delete("/api/institution/delete/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testDeleteInstitutionProfileNotFound() throws Exception {
        Integer id = null; 
        mvc.perform(delete("/api/institution/delete/{id}", id))
           .andExpect(status().isNotFound());
    }
*/
}
