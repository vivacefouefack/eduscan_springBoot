package enetAfrica.eduScan.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.AgendaDB;
import enetAfrica.eduScan.database.InstitutionProfileDB;
import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.Agenda;
import enetAfrica.eduScan.service.AgendaService;
import enetAfrica.eduScan.utils.Constant;

@Service
public class AgendaServiceImp implements AgendaService {
    @Autowired private AgendaDB agendaDB;
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private InstitutionProfileDB institutionProfileDB;

    @Override
    public Agenda addAgenda(AgendaDto agendaDto) {
        if(agendaDto==null){
            return null;
        }else{
            Agenda agenda=new Agenda();
            agenda.setVisitDate(agendaDto.getVisitDate());
            agenda.setAccountExecutive(accountExecutiveDB.findById(agendaDto.getAccountExecutive()).get());
            agenda.setInstitution(institutionProfileDB.findById(agendaDto.getInstitution()).get());
            return agendaDB.save(agenda);
        }
    }

    @Override
    public Agenda updateAgenda(AgendaDto agendaDto) {
        if(agendaDto==null){
            return null;
        }else{
            Agenda agenda=agendaDB.findById(agendaDto.getId()).get();
            agenda.setVisitDate(agendaDto.getVisitDate());
            agenda.setAccountExecutive(accountExecutiveDB.findById(agendaDto.getAccountExecutive()).get());
            agenda.setInstitution(institutionProfileDB.findById(agendaDto.getInstitution()).get());
            return agendaDB.save(agenda);
        }
    }

    @Override
    public void deleteAgenda(Integer id) {
        if (id != null ){
            agendaDB.deleteById(id);
        }
    }

    @Override
    public Agenda getAgendaById(Integer id) {
        return agendaDB.findById(id).orElseThrow(() ->
        new NotFoundException(Constant.AGENDA_NOT_FOUND_MESSAGE, ErrorCode.AGENDA_NOT_FOUND)
    );

    }

    @Override
    public  List<Agenda> findAllAgendaOfAccountExecutiveById(Integer id) {
        return agendaDB.findAllAgendaOfAccountExecutiveById(id);
    }

    @Override
    public Iterable<Agenda> getAll(){
        return agendaDB.findAll();
    }
}
