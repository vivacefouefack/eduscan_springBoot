package enetAfrica.eduScan.service.implement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.InstitutionProfile;
import enetAfrica.eduScan.service.InstitutionProfileService;
import enetAfrica.eduScan.utils.Constant;

@Service
public class InstitutionProfileServiceImp implements InstitutionProfileService {
    
    @Autowired private InstitutionProfileDB institutionProfileDB;

    @Override
    public InstitutionProfile addInstitutionProfile(PropectionRecordDto profileDto) {
        if(profileDto==null){
            return null;
        }else{
            System.out.println("enregistrement de l'imaage---------------------------------"+profileDto.getSchoolPhoto().getOriginalFilename());

            String directory="D:\\6equadri\\imasoft\\pro\\mobile_prospect_app_backend\\eduScan\\src\\main\\resources\\static\\upload\\schoolprofil";
            try {
                Files.copy(profileDto.getSchoolPhoto().getInputStream(), Paths.get(directory+File.separator+profileDto.getSchoolPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            
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
            profile.setSchoolPhoto(directory+"\\"+profileDto.getSchoolPhoto().getOriginalFilename()); 
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

    /*private String saveImage(String base64Image) throws IOException {
        String uploadDir = "/upload/schoolprofil/";
        String fileName = LocalDateTime.now() + ".jpg";
        Path imagePath = Paths.get(uploadDir, fileName);
        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
        Files.write(imagePath, imageBytes);
        return imagePath.toString();
    } */

    @Override
    public void deleteInstitutionProfileById(Integer id) {
        if (id !=null) {
            institutionProfileDB.deleteById(id);
        } 
    }


    @Override
    public InstitutionProfile getInstitutionProfileById(Integer id) {
        return institutionProfileDB.findById(id).orElseThrow(() ->
            new NotFoundException(Constant.INSTITUTION_NOT_FOUND_MESSAGE, ErrorCode.INSTITUTION_NOT_FOUND)
        );
    }

    @Override
    public InstitutionProfile updateInstitutionProfile(PropectionRecordDto profileDto) {
        if(profileDto==null){
            return null;
        }else{
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
            //profile.setSchoolPhoto(profileDto.getSchoolPhoto());
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
