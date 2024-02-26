package enetAfrica.eduScan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.controller.api.InstitutionProfileApi;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/institution")
public class InstitutionProfileController implements InstitutionProfileApi {

    @Autowired private InstitutionProfileService institutionProfileService;

    @Override
    public ResponseEntity<InstitutionProfile> addInstitutionProfile(@RequestBody PropectionRecordDto profileDto) {
        try {
            InstitutionProfile newProfile = institutionProfileService.addInstitutionProfile(profileDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Integer> deleteInstitutionProfile(@PathVariable int id) {
        try {
            institutionProfileService.deleteInstitutionProfileById(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<InstitutionProfile> getInstitutionProfile(@PathVariable int id) {
        try {
            InstitutionProfile profile = institutionProfileService.getInstitutionProfileById(id);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<InstitutionProfile> updateInstitutionProfile(@RequestBody PropectionRecordDto profileDto) {
        try {
            InstitutionProfile updatedProfile = institutionProfileService.updateInstitutionProfile(profileDto);
            if (updatedProfile != null) {
                return ResponseEntity.ok(updatedProfile);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Iterable<InstitutionProfile>> getAllInstitutionProfiles() {
        try {
            Iterable<InstitutionProfile> profiles = institutionProfileService.getAll();
            return ResponseEntity.ok(profiles);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
