package enetAfrica.eduScan.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;

public interface VisitApi {
    
    @PostMapping("/add")
    public ResponseEntity<Visit> addVisit(@RequestBody VisitDto visitDto);

    @PutMapping("/update")
    public ResponseEntity<Visit> updateVisit(@RequestBody VisitDto visit);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteVisit(@PathVariable int id);

    @GetMapping("/get/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable int id);

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Visit>> getAllVisits();
}
