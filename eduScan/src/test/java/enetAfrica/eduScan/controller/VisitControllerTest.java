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
            mvc.perform(get("/api/visite/get/0"))
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

 
}
