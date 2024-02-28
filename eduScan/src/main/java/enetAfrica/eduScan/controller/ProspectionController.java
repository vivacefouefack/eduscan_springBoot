package enetAfrica.eduScan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.controller.api.ProspectionApi;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.service.ProspectionRecordService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/prospection")
public class ProspectionController implements ProspectionApi {
    
    @Autowired
    private ProspectionRecordService prospectionRecordService;

    @Override
    public ResponseEntity<ProspectionRecord> addProspectionRecord(@RequestBody PropectionRecordDto prospectDto) {
        try {
            ProspectionRecord newProspectionRecord = prospectionRecordService.addProspectionRecord(prospectDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProspectionRecord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<ProspectionRecord> updateProspectionRecord(@RequestBody PropectionRecordDto prospectDto) {
        try {
            ProspectionRecord updatedProspectionRecord = prospectionRecordService.updateProspectionRecord(prospectDto);
            return ResponseEntity.ok(updatedProspectionRecord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Integer> deleteProspectionRecord(@PathVariable int id) {
        try {
            prospectionRecordService.deleteProspectionRecord(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<ProspectionRecord> getProspectionRecordById(@PathVariable int id) {
        try {
            ProspectionRecord prospectionRecord = prospectionRecordService.getProspectionRecordById(id);
            return ResponseEntity.ok(prospectionRecord);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Iterable<ProspectionRecord>> getAllProspectionRecords() {
        try {
            Iterable<ProspectionRecord> allProspectionRecords = prospectionRecordService.getAllProspectionRecord();
            return ResponseEntity.ok(allProspectionRecords);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
