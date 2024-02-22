package enetAfrica.eduScan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;

@Service
public class InstitutionProfileService {

    @Autowired private InstitutionProfileDB institutionProfileDB;

    public InstitutionProfile addInstitutionProfile(PropectionRecordDto profileDto) {
    if (profileDto != null) {
            InstitutionProfile profile=new InstitutionProfile();
            profile.setSchoolName(profileDto.getSchoolName());
            profile.setMunicipality(profileDto.getMunicipality());
            profile.setDistrict(profileDto.getDistrict());
            profile.setGeographicAddress(profileDto.getGeographicAddress());
            profile.setSchoolType(profileDto.getSchoolType());
            profile.setTeachingType(profileDto.getTeachingType());
            profile.setTeachingLevel(profileDto.getTeachingLevel());
            profile.setEnrollment(profileDto.getEnrollment());
            profile.setContactPhone(profileDto.getContactPhone());
            profile.setEmail(profileDto.getEmail());
            profile.setHasComputer(profileDto.isHasComputer());
            profile.setTotalComputers(profileDto.getTotalComputers());
            profile.setSchoolPhoto(profileDto.getSchoolPhoto());
            profile.setHasInternet(profileDto.isHasInternet());
            profile.setConnectionType(profileDto.getConnectionType());
            profile.setRouterType(profileDto.getRouterType());
            profile.setTelecomOperator(profileDto.getTelecomOperator());
            profile.setHasComputerRoom(profileDto.isHasComputerRoom());
            profile.setHasElectricity(profileDto.isHasElectricity());
            profile.setHasManagementSoftware(profileDto.isHasManagementSoftware());
            profile.setSoftwareName(profileDto.getSoftwareName());
            profile.setVisitTime(profileDto.getVisitTime());
            profile.setEndTime(profileDto.getEndTime());

            return institutionProfileDB.save(profile);
        } else {
            throw new IllegalArgumentException("Le profile ne peut pas être null pour l'ajout.");
        }
        
    }


    /**
     * 
     * @param id
     */
    public void deleteInstitutionProfileById(int id) {
        if (institutionProfileDB.existsById(id)) {
            institutionProfileDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'identifiant du profile ne peut pas être null pour la suppression.");
        }
    }

    /**
     * 
     * @param id
     * @return 
     */
    public InstitutionProfile getInstitutionProfileById(int id) {
        if (institutionProfileDB.existsById(id)) {
            return institutionProfileDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("Ce profile n'existe pas.");
        }
    }

    public InstitutionProfile updateInstitutionProfile(PropectionRecordDto profileDto) {
        if (institutionProfileDB.existsById(profileDto.getId())) {
            InstitutionProfile profile=institutionProfileDB.findById(profileDto.getId()).get();
            profile.setSchoolName(profileDto.getSchoolName());
            profile.setMunicipality(profileDto.getMunicipality());
            profile.setDistrict(profileDto.getDistrict());
            profile.setGeographicAddress(profileDto.getGeographicAddress());
            profile.setSchoolType(profileDto.getSchoolType());
            profile.setTeachingType(profileDto.getTeachingType());
            profile.setTeachingLevel(profileDto.getTeachingLevel());
            profile.setEnrollment(profileDto.getEnrollment());
            profile.setContactPhone(profileDto.getContactPhone());
            profile.setEmail(profileDto.getEmail());
            profile.setHasComputer(profileDto.isHasComputer());
            profile.setTotalComputers(profileDto.getTotalComputers());
            profile.setSchoolPhoto(profileDto.getSchoolPhoto());
            profile.setHasInternet(profileDto.isHasInternet());
            profile.setConnectionType(profileDto.getConnectionType());
            profile.setRouterType(profileDto.getRouterType());
            profile.setTelecomOperator(profileDto.getTelecomOperator());
            profile.setHasComputerRoom(profileDto.isHasComputerRoom());
            profile.setHasElectricity(profileDto.isHasElectricity());
            profile.setHasManagementSoftware(profileDto.isHasManagementSoftware());
            profile.setSoftwareName(profileDto.getSoftwareName());
            profile.setVisitTime(profileDto.getVisitTime());
            profile.setEndTime(profileDto.getEndTime());
            return institutionProfileDB.save(profile);
        } else {
            throw new IllegalArgumentException("Ce profile n'existe pas");
        }
    }

    /**
     * 
     * @return
     */
    public Iterable<InstitutionProfile> getAll(){
        return institutionProfileDB.findAll();
    }
    
}
