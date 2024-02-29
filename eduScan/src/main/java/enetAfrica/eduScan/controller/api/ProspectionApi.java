package enetAfrica.eduScan.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;
import jakarta.validation.Valid;

public interface ProspectionApi {

    @PostMapping("/add")
    public ResponseEntity<ProspectionRecord> addProspectionRecord(@Valid @RequestBody PropectionRecordDto prospectDto);

    @PutMapping("/update")
    public ResponseEntity<ProspectionRecord> updateProspectionRecord(@Valid @RequestBody PropectionRecordDto prospectDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteProspectionRecord(@PathVariable int id);

    @GetMapping("/get/{id}")
    public ResponseEntity<ProspectionRecord> getProspectionRecordById(@PathVariable int id);

    @GetMapping("/getall")
    public ResponseEntity<Iterable<ProspectionRecord>> getAllProspectionRecords();
}
