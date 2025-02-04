package enetAfrica.eduScan.controller.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import enetAfrica.eduScan.dto.InstitutionDto;
import enetAfrica.eduScan.model.InstitutionProfile;
import jakarta.validation.Valid;

public interface InstitutionProfileApi {


    //@PostMapping(value ="/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //public ResponseEntity<?> addInstitutionProfile(@ModelAttribute PropectionRecordDto profileDto);

    @PostMapping(value ="/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<InstitutionProfile> addInstitutionProfile(@Valid @ModelAttribute InstitutionDto profileDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteInstitutionProfile(@PathVariable int id);

    @GetMapping("/get/{id}")
    public ResponseEntity<Iterable<InstitutionProfile>> getInstitutionProfile(@PathVariable int id);

    @PutMapping("/update")
    public ResponseEntity<InstitutionProfile> updateInstitutionProfile(@Valid @ModelAttribute InstitutionDto profileDto);

    @GetMapping("/getall")
    public ResponseEntity<Iterable<InstitutionProfile>> getAllInstitutionProfiles();
}
