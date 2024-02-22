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

    public Visit updateVisit(Visit visit) {
        if (visit.getId() != 0) {
            return visitDB.save(visit);
        } else {
            throw new IllegalArgumentException("L'identifiant de la visite ne peut pas être null pour la modification.");
        }
    }

    public void deleteVisit(int id) {
        if (id != 0) {
            visitDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'identifiant de la visite ne peut pas être null pour la suppression.");
        }
    }

    public Visit getVisitById(int id) {
        if (id != 0) {
            return visitDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("L'identifiant de la visite ne peut pas être null pour la récupération.");
        }
    }

    public Iterable<Visit> getAllVisit(){
        return visitDB.findAll();
    }


}
