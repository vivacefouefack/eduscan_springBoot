package enetAfrica.eduScan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.ProspectionRecordDB;
import enetAfrica.eduScan.database.VisitDB;
import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;

@Service
public class VisitService {
    
    @Autowired private VisitDB visitDB;
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private ProspectionRecordDB prospectionRecordDB;

    public Visit addVisit(VisitDto visitDto) {
        if (visitDto!= null) {
            Visit visite=new Visit();
            visite.setSupValidation(visitDto.isSupValidation());
            visite.setVisitDate(visitDto.getVisitDate());
            visite.setAccountExecutive(accountExecutiveDB.findById(visitDto.getAccountExecutive()).get());
            visite.setProspectingRecord(prospectionRecordDB.findById(visitDto.getProspectingRecord()).get());
            return visitDB.save(visite);
        } else {
            throw new IllegalArgumentException("L'identifiant de la visite ne peut pas être null");
        }
    }

    public Visit updateVisit(VisitDto visitDto) {
        if (visitDB.existsById(visitDto.getId())) {
            Visit visite=visitDB.findById(visitDto.getId()).get();
            visite.setSupValidation(visitDto.isSupValidation());
            visite.setVisitDate(visitDto.getVisitDate());
            visite.setAccountExecutive(accountExecutiveDB.findById(visitDto.getAccountExecutive()).get());
            visite.setProspectingRecord(prospectionRecordDB.findById(visitDto.getProspectingRecord()).get());
            return visitDB.save(visite);
        } else {
            throw new IllegalArgumentException("L'identifiant de la visite ne peut pas être null pour la modification.");
        }
    }

    public void deleteVisit(int id) {
        if (visitDB.existsById(id)) {
            visitDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("La visite n'existe pas.");
        }
    }

    public Visit getVisitById(int id) {
        if (visitDB.existsById(id)) {
            return visitDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("La visite n'existe pas.");
        }
    }

    public Iterable<Visit> getAllVisit(){
        return visitDB.findAll();
    }


}
