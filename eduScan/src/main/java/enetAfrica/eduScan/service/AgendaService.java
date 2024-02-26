package enetAfrica.eduScan.service;

import java.util.List;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;

public interface AgendaService {

    /**
     * 
     * @param agendaDto
     * @return
     */
    public Agenda addAgenda(AgendaDto agendaDto);

    /**
     * 
     * @param agendaDto
     * @return
     */
    public Agenda updateAgenda(AgendaDto agendaDto);

    /**
     * 
     * @param id
     */
    public void deleteAgenda(Integer id) ;

    /**
     * 
     * @param id
     * @return
     */
    public Agenda getAgendaById(Integer id);

    /**
     * 
     * @param id
     * @return 
     */
    public  List<Agenda> findAllAgendaOfAccountExecutiveById(Integer id);

    /**
     * 
     * @return
     */
    public Iterable<Agenda> getAll();
}
