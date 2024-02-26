package enetAfrica.eduScan.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.ProspectionRecordDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;
import enetAfrica.eduScan.service.ProspectionRecordService;

@Service
public class ProspectionRecordServiceImp implements ProspectionRecordService{

    @Autowired private ProspectionRecordDB prospectionRecordDB;

    @Override
    public ProspectionRecord addProspectionRecord(PropectionRecordDto prospectDto) {
        if (prospectDto != null) {
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
            prospect.setSchoolPhoto(prospectDto.getSchoolPhoto());
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
        } else {
            throw new IllegalArgumentException("Le fichier de prospection ne peut pas être null pour l'ajout.");
        }
    }

    @Override
    public ProspectionRecord updateProspectionRecord(PropectionRecordDto prospectDto) {
        if (prospectionRecordDB.existsById(prospectDto.getId())) {
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
            prospect.setSchoolPhoto(prospectDto.getSchoolPhoto());
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
        } else {
            throw new IllegalArgumentException("Le fichier de prospection n'existe pas.");
        }
    }

    @Override
    public void deleteProspectionRecord(int id) {
        if (prospectionRecordDB.existsById(id)) {
            prospectionRecordDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("La fichier n'existe pas.");
        }
    }

    @Override
    public ProspectionRecord getProspectionRecordById(int id) {
        if (prospectionRecordDB.existsById(id)) {
            return prospectionRecordDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("La fichier n'existe pas.");
        }
    }


    @Override
    public Iterable<ProspectionRecord> getAllProspectionRecord(){
        return prospectionRecordDB.findAll();
    }
}
