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
import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import enetAfrica.eduScan.service.VisitService;

@RunWith(SpringRunner.class)
@WebMvcTest(VisitController.class)
public class VisitControllerTest {

    @Autowired private MockMvc mvc;
    @MockBean private VisitService service;  

    @Test
    public void testGetVisitByIdFailure() throws Exception{
        Mockito.when(service.getVisitById(null)).thenReturn(null);
            mvc.perform(get("/api/visite/get/null"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetVisitByIdWithSuccess() throws Exception{
        Integer id=1;
        Mockito.when(service.getVisitById(id)).thenReturn(null);
            mvc.perform(get("/api/visite/get/null"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetVisitByIdSuccess() throws Exception {
        Integer id = 1; 
        Visit visit=new Visit();
        visit.setId(id);

        Mockito.when(service.getVisitById(id)).thenReturn(visit);

        mvc.perform(get("/api/visite/get/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testNoVisiteExist() throws Exception {
        List<Visit> emptyList = new ArrayList<>();
        Mockito.when(service.getAllVisit()).thenReturn(emptyList);

        mvc.perform(get("/api/visite/getall"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testDeleteVisiteSuccess() throws Exception {
        Integer id = 1; 
        mvc.perform(delete("/api/visite/delete/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testDeleteVisiteNotFound() throws Exception {
        Integer id = null; 
        mvc.perform(delete("/api/visite/delete/{id}", id))
           .andExpect(status().isNotFound());
    }

    @Test
    public void testAddVisitSuccess() throws Exception {
        VisitDto visitDto=new VisitDto();
        visitDto.setId(2);

        Visit visit=new Visit();
        visit.setId(2);

        Mockito.when(service.addVisit(Mockito.any(VisitDto.class))).thenReturn(visit);
        ObjectMapper objectMapper = new ObjectMapper();
        String visitDtoJson = objectMapper.writeValueAsString(visit);

        mvc.perform(post("/api/visite/add")
           .contentType(MediaType.APPLICATION_JSON)
           .content(visitDtoJson))
           .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateVisitSuccess() throws Exception {
        VisitDto visitDto=new VisitDto();
        visitDto.setId(1);

        Visit visit=new Visit();
        visit.setId(1);

        Mockito.when(service.updateVisit(Mockito.any(VisitDto.class))).thenReturn(visit);
        ObjectMapper objectMapper = new ObjectMapper();
        String visitDtoJson = objectMapper.writeValueAsString(visitDto);

        mvc.perform(put("/api/visite/update")
           .contentType(MediaType.APPLICATION_JSON)
           .content(visitDtoJson))
           .andExpect(status().isOk());
    }

}
