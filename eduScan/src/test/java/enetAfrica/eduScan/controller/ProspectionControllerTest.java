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

import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.service.ProspectionRecordService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProspectionController.class)
public class ProspectionControllerTest {
    
    @Autowired private MockMvc mvc;

    @MockBean private ProspectionRecordService service;

    @Test
    public void testGetProspectionRecordByIdFailure() throws Exception{
        Mockito.when(service.getProspectionRecordById(null)).thenReturn(null);
            mvc.perform(get("/api/prospection/get/-11"))
            .andExpect(status().isOk());
    }

    @Test
    public void testNoProspectionRecordExist() throws Exception {
        List<ProspectionRecord> emptyList = new ArrayList<>();
        Mockito.when(service.getAllProspectionRecord()).thenReturn(emptyList);

        mvc.perform(get("/api/prospection/getall"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$").isEmpty());
    }
}
