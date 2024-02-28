package enetAfrica.eduScan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;

@RunWith(SpringRunner.class)
@WebMvcTest(InstitutionProfileController.class)
public class InstitutionProfileControllerTest {
    
    @Autowired private MockMvc mvc;

    @MockBean private InstitutionProfileService service;

    @Test
    public void testGetInstitutionByIdFailure() throws Exception{
        Mockito.when(service.getInstitutionProfileById(null)).thenReturn(null);
            mvc.perform(get("/api/institution/get/-11"))
            .andExpect(status().isOk());
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
}
