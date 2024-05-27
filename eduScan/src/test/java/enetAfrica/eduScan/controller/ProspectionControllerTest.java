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

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.service.ProspectionRecordService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProspectionController.class)
public class ProspectionControllerTest {
    
    @Autowired private MockMvc mvc;

    @MockBean private ProspectionRecordService service;

   /* @Test
    public void testGetProspectionRecordByIdFailure() throws Exception{
        Mockito.when(service.getProspectionRecordById(null)).thenReturn(null);
            mvc.perform(get("/api/prospection/get/null"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetProspectionRecordByIdSuccess() throws Exception {
        Integer id = 1; 
        ProspectionRecord prospectionRecord = new ProspectionRecord();
        prospectionRecord.setId(id);

        Mockito.when(service.getProspectionRecordById(id)).thenReturn(prospectionRecord);

        mvc.perform(get("/api/prospection/get/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testAddProspectionRecordSuccess() throws Exception {
        PropectionRecordDto prospectDto = new PropectionRecordDto(); 
        ProspectionRecord prospectionRecord = new ProspectionRecord(); 

        Mockito.when(service.addProspectionRecord(Mockito.any(PropectionRecordDto.class))).thenReturn(prospectionRecord);

        ObjectMapper objectMapper = new ObjectMapper();
        String prospectDtoJson = objectMapper.writeValueAsString(prospectDto);

        mvc.perform(post("/api/prospection/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(prospectDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateProspectionRecordSuccess() throws Exception {
        PropectionRecordDto prospectDto = new PropectionRecordDto();
        ProspectionRecord prospectionRecord = new ProspectionRecord(); 

        Mockito.when(service.updateProspectionRecord(Mockito.any(PropectionRecordDto.class))).thenReturn(prospectionRecord);

        ObjectMapper objectMapper = new ObjectMapper();
        String prospectDtoJson = objectMapper.writeValueAsString(prospectDto);

        mvc.perform(put("/api/prospection/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(prospectDtoJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProspectionRecordSuccess() throws Exception {
        Integer id = 1; 
        mvc.perform(delete("/api/prospection/delete/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testDeleteProspectionRecordNotFound() throws Exception {
        Integer id = null; 
        mvc.perform(delete("/api/prospection/delete/{id}", id))
           .andExpect(status().isNotFound());
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
*/
}
