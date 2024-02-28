package enetAfrica.eduScan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import enetAfrica.eduScan.service.AgendaService;

@RunWith(SpringRunner.class)
@WebMvcTest(AgendaController.class)
public class AgendaControllerTest {

    @Autowired private MockMvc mvc;

    @MockBean private AgendaService agendaService;

    @Test
    public void testGetAgendaByIdFailure() throws Exception{
        Mockito.when(agendaService.getAgendaById(11)).thenReturn(null);
            mvc.perform(get("/api/agenda/get/11"))
            .andExpect(status().isOk());
    }

    
}
