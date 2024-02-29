package enetAfrica.eduScan.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;
import jakarta.validation.Valid;

public interface AgendaApi {

    @PostMapping("/add")
    public ResponseEntity<Agenda> addVisit(@Valid @RequestBody AgendaDto agendaDto);

    @PutMapping("/update")
    public ResponseEntity<Agenda> updateVisit(@Valid @RequestBody AgendaDto agendaDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteVisit(@PathVariable int id);

    @GetMapping("/getbyAccountId/{id}")
    public ResponseEntity<List<Agenda>> getAgendaOfAccountExecutive(@PathVariable int id);
}
