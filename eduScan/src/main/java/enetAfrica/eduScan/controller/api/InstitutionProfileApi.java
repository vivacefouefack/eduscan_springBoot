package enetAfrica.eduScan.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileApi {
    @PostMapping("/add")
    public ResponseEntity<InstitutionProfile> addInstitutionProfile(@RequestBody PropectionRecordDto profileDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteInstitutionProfile(@PathVariable int id);

    @GetMapping("/get/{id}")
    public ResponseEntity<InstitutionProfile> getInstitutionProfile(@PathVariable int id);

    @PutMapping("/update")
    public ResponseEntity<InstitutionProfile> updateInstitutionProfile(@RequestBody PropectionRecordDto profileDto);

    @GetMapping("/getall")
    public ResponseEntity<Iterable<InstitutionProfile>> getAllInstitutionProfiles();
}
