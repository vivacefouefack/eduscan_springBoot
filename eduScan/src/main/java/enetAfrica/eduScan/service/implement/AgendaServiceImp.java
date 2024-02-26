package enetAfrica.eduScan.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.AgendaDB;
import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;
import enetAfrica.eduScan.service.AgendaService;

@Service
public class AgendaServiceImp implements AgendaService {
    @Autowired private AgendaDB agendaDB;
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private InstitutionProfileDB institutionProfileDB;

    @Override
    public Agenda addAgenda(AgendaDto agendaDto) {
        if (agendaDto != null) {
            Agenda agenda=new Agenda();
            agenda.setVisitDate(agendaDto.getVisitDate());
            agenda.setAccountExecutive(accountExecutiveDB.findById(agendaDto.getAccountExecutive()).get());
            agenda.setInstitution(institutionProfileDB.findById(agendaDto.getInstitution()).get());
            return agendaDB.save(agenda);
        } else {
            throw new IllegalArgumentException("L'agenda ne peut pas être null pour l'ajout.");
        }
    }

    @Override
    public Agenda updateAgenda(AgendaDto agendaDto) {
        if (agendaDto != null) {
            Agenda agenda=agendaDB.findById(agendaDto.getId()).get();
            agenda.setVisitDate(agendaDto.getVisitDate());
            agenda.setAccountExecutive(accountExecutiveDB.findById(agendaDto.getAccountExecutive()).get());
            agenda.setInstitution(institutionProfileDB.findById(agendaDto.getInstitution()).get());
            return agendaDB.save(agenda);
        } else {
            throw new IllegalArgumentException("L'identifiant de l'agenda ne peut pas être null pour la modification.");
        }
    }

    @Override
    public void deleteAgenda(int id) {
        if (id != 0) {
            agendaDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'identifiant de l'agenda ne peut pas être null pour la suppression.");
        }
    }

    @Override
    public Agenda getAgendaById(int id) {
        if (id != 0) {
            return agendaDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("L'identifiant de l'agenda ne peut pas être null pour la récupération.");
        }
    }

    @Override
    public  List<Agenda> findAllAgendaOfAccountExecutiveById(int id) {
        if (id != 0) {
            return agendaDB.findAllAgendaOfAccountExecutiveById(id);
        } else {
            throw new IllegalArgumentException("L'identifiant de l'accountExecutive ne peut pas être null pour la récupération de l'agenda.");
        }
    }

    @Override
    public Iterable<Agenda> getAll(){
        return agendaDB.findAll();
    }
}
