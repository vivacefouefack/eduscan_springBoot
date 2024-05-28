package enetAfrica.eduScan.service.implement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.InstitutionDto; 
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;


@Service
public class InstitutionProfileServiceImp implements InstitutionProfileService {
    
    @Autowired private InstitutionProfileDB institutionProfileDB;
    @Autowired private AccountExecutiveDB accountExecutiveDB;

    @Override
    public InstitutionProfile addInstitutionProfile(InstitutionDto profileDto) {
        if(profileDto==null){
            return null;
        }else{
            String directory="D:\\6equadri\\imasoft\\pro\\mobile_prospect_app_backend\\eduScan\\src\\main\\resources\\static\\upload\\schoolprofil";
            try {
                Files.copy(profileDto.getSchoolPhoto().getInputStream(), Paths.get(directory+File.separator+profileDto.getSchoolPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
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
            profile.setSchoolPhoto(profileDto.getSchoolPhoto().getOriginalFilename());
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
            profile.setLatitude(profileDto.getLatitude());
            profile.setLongitude(profileDto.getLongitude());

            
            profile.setAccountExecutive(accountExecutiveDB.findById(profileDto.getId()).get());
            InstitutionProfile newProfil = institutionProfileDB.save(profile);

            return newProfil;
        }      
    }

    @Override
    public void deleteInstitutionProfileById(Integer id) {
        if (id !=null) {
            institutionProfileDB.deleteById(id);
        } 
    }


    @Override
    public Iterable<InstitutionProfile> getInstitutionProfileById(Integer id) {
        System.out.println("*********************************************************************************"+id);
       return institutionProfileDB.findByAccountExecutiveId(id);
    }

    @Override
    public InstitutionProfile updateInstitutionProfile(InstitutionDto profileDto) {
        if(profileDto==null){
            return null;
        }else{
            InstitutionProfile profile=institutionProfileDB.findById(profileDto.getId()).get();
            if(profileDto.getSchoolPhoto() !=null){
                String directory="D:\\6equadri\\imasoft\\pro\\mobile_prospect_app_backend\\eduScan\\src\\main\\resources\\static\\upload\\schoolprofil";
                try {
                    Files.copy(profileDto.getSchoolPhoto().getInputStream(), Paths.get(directory+File.separator+profileDto.getSchoolPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                    profile.setSchoolPhoto(profileDto.getSchoolPhoto().getOriginalFilename());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                     
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
    }

    @Override
    public Iterable<InstitutionProfile> getAll(){
        return institutionProfileDB.findAll();
    }
}
