package enetAfrica.eduScan.service.implement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.ProspectionRecordDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.service.ProspectionRecordService;
import enetAfrica.eduScan.utils.Constant;

@Service
public class ProspectionRecordServiceImp implements ProspectionRecordService{

    @Autowired private ProspectionRecordDB prospectionRecordDB;

    @Override
    public ProspectionRecord addProspectionRecord(PropectionRecordDto prospectDto) {
         if(prospectDto==null){
            return null;
        }else{
            String directory="D:\\6equadri\\imasoft\\pro\\mobile_prospect_app_backend\\eduScan\\src\\main\\resources\\static\\upload\\prospectprofil";
            try {
                Files.copy(prospectDto.getSchoolPhoto().getInputStream(), Paths.get(directory+File.separator+prospectDto.getSchoolPhoto().getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            ProspectionRecord prospect=new ProspectionRecord();
            prospect.setSchoolName(prospectDto.getSchoolName());
            prospect.setMunicipality(prospectDto.getMunicipality());
            prospect.setDistrict(prospectDto.getDistrict());
            prospect.setGeographicAddress(prospectDto.getGeographicAddress());
            prospect.setSchoolType(prospectDto.getSchoolType());
            prospect.setTeachingType(prospectDto.getTeachingType());
            prospect.setTeachingLevel(prospectDto.getTeachingLevel());
            prospect.setEnrollment(prospectDto.getEnrollment());
            prospect.setContactPhone(prospectDto.getContactPhone());
            prospect.setEmail(prospectDto.getEmail());
            prospect.setHasComputer(prospectDto.isHasComputer());
            prospect.setTotalComputers(prospectDto.getTotalComputers());
            prospect.setSchoolPhoto(prospectDto.getSchoolPhoto().getOriginalFilename());
            prospect.setSeniority(prospectDto.getSeniority());
            prospect.setFirstVisitDate(prospectDto.getFirstVisitDate());
            prospect.setInterlocutorFirstName(prospectDto.getInterlocutorFirstName());
            prospect.setInterlocutorLastName(prospectDto.getInterlocutorLastName());
            prospect.setInterlocutorFunction(prospectDto.getInterlocutorFunction());
            prospect.setHasInternet(prospectDto.isHasInternet());
            prospect.setConnectionType(prospectDto.getConnectionType());
            prospect.setRouterType(prospectDto.getRouterType());
            prospect.setTelecomOperator(prospectDto.getTelecomOperator());
            prospect.setHasComputerRoom(prospectDto.isHasComputerRoom());
            prospect.setHasElectricity(prospectDto.isHasElectricity());
            prospect.setHasManagementSoftware(prospectDto.isHasManagementSoftware());
            prospect.setSoftwareName(prospectDto.getSoftwareName());
            prospect.setVisitTime(prospectDto.getVisitTime());
            prospect.setEndTime(prospectDto.getEndTime());

            return prospectionRecordDB.save(prospect);
        }
    }

    @Override
    public ProspectionRecord updateProspectionRecord(PropectionRecordDto prospectDto) {
        if(prospectDto==null){
            return null;
        }else{
            ProspectionRecord prospect=prospectionRecordDB.findById(prospectDto.getId()).get();
            prospect.setSchoolName(prospectDto.getSchoolName());
            prospect.setMunicipality(prospectDto.getMunicipality());
            prospect.setDistrict(prospectDto.getDistrict());
            prospect.setGeographicAddress(prospectDto.getGeographicAddress());
            prospect.setSchoolType(prospectDto.getSchoolType());
            prospect.setTeachingType(prospectDto.getTeachingType());
            prospect.setTeachingLevel(prospectDto.getTeachingLevel());
            prospect.setEnrollment(prospectDto.getEnrollment());
            prospect.setContactPhone(prospectDto.getContactPhone());
            prospect.setEmail(prospectDto.getEmail());
            prospect.setHasComputer(prospectDto.isHasComputer());
            prospect.setTotalComputers(prospectDto.getTotalComputers());
            //prospect.setSchoolPhoto(prospectDto.getSchoolPhoto());
            prospect.setSeniority(prospectDto.getSeniority());
            prospect.setFirstVisitDate(prospectDto.getFirstVisitDate());
            prospect.setInterlocutorFirstName(prospectDto.getInterlocutorFirstName());
            prospect.setInterlocutorLastName(prospectDto.getInterlocutorLastName());
            prospect.setInterlocutorFunction(prospectDto.getInterlocutorFunction());
            prospect.setHasInternet(prospectDto.isHasInternet());
            prospect.setConnectionType(prospectDto.getConnectionType());
            prospect.setRouterType(prospectDto.getRouterType());
            prospect.setTelecomOperator(prospectDto.getTelecomOperator());
            prospect.setHasComputerRoom(prospectDto.isHasComputerRoom());
            prospect.setHasElectricity(prospectDto.isHasElectricity());
            prospect.setHasManagementSoftware(prospectDto.isHasManagementSoftware());
            prospect.setSoftwareName(prospectDto.getSoftwareName());
            prospect.setVisitTime(prospectDto.getVisitTime());
            prospect.setEndTime(prospectDto.getEndTime());
            return prospectionRecordDB.save(prospect);
        }
    }

    @Override
    public void deleteProspectionRecord(Integer id) {
        if (id !=null) {
            prospectionRecordDB.deleteById(id);
        } 
    }

    @Override
    public ProspectionRecord getProspectionRecordById(Integer id) {
        return prospectionRecordDB.findById(id).orElseThrow(() ->
            new NotFoundException(Constant.PROSPECTION_NOT_FOUND_MESSAGE, ErrorCode.PROSPECTION_NOT_FOUND)
        );
    }


    @Override
    public Iterable<ProspectionRecord> getAllProspectionRecord(){
        return prospectionRecordDB.findAll();
    }
}
