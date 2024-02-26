package enetAfrica.eduScan.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;

@Service
public class InstitutionProfileServiceImp implements InstitutionProfileService {
    
    @Autowired private InstitutionProfileDB institutionProfileDB;

    @Override
    public InstitutionProfile addInstitutionProfile(PropectionRecordDto profileDto) {
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
        
    }


    @Override
    public void deleteInstitutionProfileById(Integer id) {
        if (id !=null) {
            institutionProfileDB.deleteById(id);
        } 
    }

    
    @Override
    public InstitutionProfile getInstitutionProfileById(Integer id) {
        if (institutionProfileDB.existsById(id)) {
            return institutionProfileDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("Ce profile n'existe pas.");
        }
    }

    @Override
    public InstitutionProfile updateInstitutionProfile(PropectionRecordDto profileDto) {
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
    }

    @Override
    public Iterable<InstitutionProfile> getAll(){
        return institutionProfileDB.findAll();
    }
}
