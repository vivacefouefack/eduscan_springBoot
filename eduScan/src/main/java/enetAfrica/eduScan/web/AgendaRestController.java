package enetAfrica.eduScan.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;
import enetAfrica.eduScan.service.AgendaService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/agenda")
public class AgendaRestController {

    @Autowired  private AgendaService agendaService;

    @PostMapping("/add")
    public ResponseEntity<Agenda> addVisit(@RequestBody AgendaDto agendaDto) {
        try {
            Agenda newAgenda = agendaService.addAgenda(agendaDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAgenda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Agenda> updateVisit(@RequestBody AgendaDto agendaDto) {
        try {
            Agenda updatedaAgenda = agendaService.updateAgenda(agendaDto);
            return ResponseEntity.ok(updatedaAgenda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteVisit(@PathVariable int id) {
        try {
            agendaService.deleteAgenda(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getbyAccountId/{id}")
    public ResponseEntity<List<Agenda>> getAgendaOfAccountExecutive(@PathVariable int id) {
        try {
            List<Agenda> agendas=new ArrayList<>();
            agendas=agendaService.findAllAgendaOfAccountExecutiveById(id);
            return ResponseEntity.ok(agendas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
