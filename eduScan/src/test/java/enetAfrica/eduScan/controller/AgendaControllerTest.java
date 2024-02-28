package enetAfrica.eduScan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;
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
            .andExpect(status().isNotFound());
    }

    @Test
    public void testGetAgendaByNullIdFailure() throws Exception{
        Mockito.when(agendaService.getAgendaById(null)).thenReturn(null);
        mvc.perform(get("/api/agenda/get/null"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteNotExistAgenda() throws Exception {
        int id = 100;
        Mockito.doNothing().when(agendaService).deleteAgenda(id);
        mvc.perform(delete("/api/account/delete/{id}", id))
           .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteExistAgenda() throws Exception {
        int id = 1;
        Mockito.doNothing().when(agendaService).deleteAgenda(id);
        mvc.perform(delete("/api/account/delete/{id}", id))
           .andExpect(status().isOk());
    }

    @Test
    public void testAddAgendaSuccess() throws Exception {// à revoir
        AgendaDto agendaDto = new AgendaDto(); 
        agendaDto.setVisitDate(LocalDate.now()); 

        Agenda agenda = new Agenda(); 
        agenda.setId(1); 

        Mockito.when(agendaService.addAgenda(Mockito.any(AgendaDto.class))).thenReturn(agenda);
        ObjectMapper objectMapper = new ObjectMapper();
        String agendaDtoJson = objectMapper.writeValueAsString(agendaDto);

        mvc.perform(post("/api/agenda/add")
           .contentType(MediaType.APPLICATION_JSON)
           .content(agendaDtoJson))
           .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateAgendaSuccess() throws Exception {// à revoir
        AgendaDto agendaDto = new AgendaDto(); 
        agendaDto.setId(1); 
        agendaDto.setVisitDate(LocalDate.now()); 

        Agenda agenda = new Agenda();
        agenda.setId(1); 

        Mockito.when(agendaService.updateAgenda(Mockito.any(AgendaDto.class))).thenReturn(agenda);
        ObjectMapper objectMapper = new ObjectMapper();
        String agendaDtoJson = objectMapper.writeValueAsString(agendaDto);
        mvc.perform(put("/api/agenda/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(agendaDtoJson))
                .andExpect(status().isOk());
    }

    
}
