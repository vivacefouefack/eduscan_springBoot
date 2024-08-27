package enetAfrica.eduScan.service;

import java.util.List;

import enetAfrica.eduScan.dto.AgendaDto;
import enetAfrica.eduScan.model.Agenda;

public interface AgendaService {

   /**
     * Adds a new Agenda.
     *
     * @param agendaDto the data transfer object containing the details of the new Agenda.
     * @return the newly created Agenda.
    */
    public Agenda addAgenda(AgendaDto agendaDto);

    /**
     * Updates an existing {@link Agenda}.
     *
     * @param agendaDto the data transfer object containing the updated details of the Agenda.
     * @return the updated Agenda.
     */
    public Agenda updateAgenda(AgendaDto agendaDto);

    /**
     * Deletes an Agenda by its ID.
     *
     * @param id the ID of the Agenda to delete.
    */
    public void deleteAgenda(Integer id);

    /**
     * Retrieves an Agenda by its ID.
     *
     * @param id the ID of the Agenda to retrieve.
     * @return the Agenda with the given ID.
     */
    public Agenda getAgendaById(Integer id);

    /**
     * Retrieves all Agenda entities associated with a specific Account Executive by their ID.
     *
     * @param id the ID of the Account Executive whose agendas are to be retrieved.
     * @return a list of Agenda entities associated with the specified Account Executive.
    */
    public List<Agenda> findAllAgendaOfAccountExecutiveById(Integer id);

    /**
     * Retrieves all Agenda entities.
     *
     * @return an Iterable of all Agenda entities.
    */
    public Iterable<Agenda> getAll();
}
