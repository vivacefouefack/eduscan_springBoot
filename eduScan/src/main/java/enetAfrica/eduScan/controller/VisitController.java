package enetAfrica.eduScan.controller;

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

import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import enetAfrica.eduScan.service.VisitService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/visite")
public class VisitController {
    
    @Autowired private VisitService visitService;

    @PostMapping("/add")
    public ResponseEntity<Visit> addVisit(@RequestBody VisitDto visitDto) {
        try {
            Visit newVisit = visitService.addVisit(visitDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Visit> updateVisit(@RequestBody VisitDto visit) {
        try {
            Visit updatedVisit = visitService.updateVisit(visit);
            return ResponseEntity.ok(updatedVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteVisit(@PathVariable int id) {
        try {
            visitService.deleteVisit(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Visit> getVisitById(@PathVariable int id) {
        try {
            Visit visit = visitService.getVisitById(id);
            return ResponseEntity.ok(visit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Visit>> getAllVisits() {
        try {
            Iterable<Visit> visits = visitService.getAllVisit();
            return ResponseEntity.ok(visits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
