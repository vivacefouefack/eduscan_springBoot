package enetAfrica.eduScan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.ProspectionRecordDB;
import enetAfrica.eduScan.dto.PropectionRecordDto;
import enetAfrica.eduScan.model.ProspectionRecord;

@Service
public class ProspectionRecordService {

    @Autowired private ProspectionRecordDB prospectionRecordDB;

    /**
     * Permet d'ajouter un nouveau fichier de prospection.
     * @param prospectionRecord le nouveau fichier de prospection à ajouter.
     * @return le fichier de prospection ajouté.
     * @throws IllegalArgumentException si le fichier de prospection est null.
     */
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

    /**
     * Permet de modifier un fichier de prospection existant.
     * @param prospectionRecord le fichier de prospection avec les modifications à apporter.
     * @return le fichier de prospection modifié.
     * @throws IllegalArgumentException si le fichier de prospection est null ou si son identifiant est null.
     */
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

    /**
     * Permet de supprimer un fichier de prospection à travers son identifiant.
     * @param id l'identifiant du fichier de prospection à supprimer.
     * @throws IllegalArgumentException si l'identifiant du fichier de prospection n'existe pas.
     */
    public void deleteProspectionRecord(int id) {
        if (prospectionRecordDB.existsById(id)) {
            prospectionRecordDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("La fichier n'existe pas.");
        }
    }

    /**
     * Permet d'obtenir un fichier de prospection à travers son identifiant.
     * @param id l'identifiant du fichier de prospection à obtenir.
     * @return le fichier de prospection correspondant à l'identifiant donné, s'il existe.
     * @throws IllegalArgumentException si l'identifiant du fichier de prospection n'existe pas.
     */
    public ProspectionRecord getProspectionRecordById(int id) {
        if (prospectionRecordDB.existsById(id)) {
            return prospectionRecordDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("La fichier n'existe pas.");
        }
    }


    /**
     * permet d'obtenir tous les fichiers de prospection.
     * @return liste de tous les fichiers de prospetion.
     */
    public Iterable<ProspectionRecord> getAllProspectionRecord(){
        return prospectionRecordDB.findAll();
    }
}
