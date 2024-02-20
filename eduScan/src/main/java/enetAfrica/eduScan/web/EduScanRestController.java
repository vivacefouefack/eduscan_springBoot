package enetAfrica.eduScan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.Business;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class EduScanRestController {
    @Autowired private Business service;

    @GetMapping("/AllAccountExecutive")
    public ResponseEntity<Iterable<AccountExecutive>> getAllAccountExecutives() {
        try {
            return ResponseEntity.ok(service.getAllAccountExecutives());
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
