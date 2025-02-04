package enetAfrica.eduScan.service.implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.database.VisitDB;
import enetAfrica.eduScan.dto.VisitDto;
import enetAfrica.eduScan.model.Visit;
import enetAfrica.eduScan.service.VisitService;
import jakarta.validation.Valid;

@Service
public class VisitServiceImp implements VisitService {

    @Autowired private VisitDB visitDB;
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private InstitutionProfileDB institutionProfileDB;

    @Override
    public Visit addVisit(VisitDto visitDto) {
        if(visitDto==null){
            return null;
        }else{
            Visit visite=new Visit();
            visite.setSupValidation(visitDto.isSupValidation());
            visite.setVisitDate(visitDto.getVisitDate());
            visite.setAccountExecutive(accountExecutiveDB.findById(visitDto.getAccountExecutiveId()).get());
            visite.setInstitutionProfile(institutionProfileDB.findById(visitDto.getInstitutionId()).get());
            return visitDB.save(visite);
        }
    }

    @Override
    public Visit updateVisit(VisitDto visitDto) {
        if(visitDto==null){
            return null;
        }else{
            Visit visite=visitDB.findById(visitDto.getId()).get();
            visite.setSupValidation(visitDto.isSupValidation());
            visite.setVisitDate(visitDto.getVisitDate());
            visite.setAccountExecutive(accountExecutiveDB.findById(visitDto.getAccountExecutiveId()).get());
            visite.setInstitutionProfile(institutionProfileDB.findById(visitDto.getInstitutionId()).get());
            return visitDB.save(visite);
        }
    }

    @Override
    public void deleteVisit(Integer id) {
        if (id!=null) {
            visitDB.deleteById(id);
        }
    }

    @Override
    public Iterable<Visit> getVisitById(Integer id) {
        return visitDB.findByAccountExecutiveId(id);
    }

    @Override
    public Iterable<Visit> getAllVisit(){
        return visitDB.findAll();
    }

    @Override
    public Visit valideVisitById(@Valid int id) {
        Visit visite = visitDB.findById(id).get();
        visite.setSupValidation(true);
        return visitDB.save(visite);
    }

    @Override
    public Visit valide(@Valid int id) {
        Visit visite = visitDB.findById(id).get();
        visite.setSupValidation(true);
        return visitDB.save(visite);
    }


}
