package enetAfrica.eduScan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.controller.api.VisitApi;
import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import enetAfrica.eduScan.service.VisitService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/visite")
public class VisitController implements VisitApi {
    
    @Autowired private VisitService visitService;

    @Override
    public ResponseEntity<Visit> addVisit(@RequestBody VisitDto visitDto) {
        try {
            Visit newVisit = visitService.addVisit(visitDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Visit> updateVisit(@RequestBody VisitDto visit) {
        try {
            Visit updatedVisit = visitService.updateVisit(visit);
            return ResponseEntity.ok(updatedVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Integer> deleteVisit(@PathVariable int id) {
        try {
            visitService.deleteVisit(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Visit> getVisitById(@PathVariable int id) {
        try {
            Visit visit = visitService.getVisitById(id);
            return ResponseEntity.ok(visit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Iterable<Visit>> getAllVisits() {
        try {
            Iterable<Visit> visits = visitService.getAllVisit();
            return ResponseEntity.ok(visits);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Visit> valideVisit(@Valid int id) {
        try {
            Visit visit = visitService.valideVisitById(id);
            return ResponseEntity.ok(visit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Visit> valideVisite(@Valid int id) {
        try {
            Visit newVisit = visitService.valide(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(newVisit);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
