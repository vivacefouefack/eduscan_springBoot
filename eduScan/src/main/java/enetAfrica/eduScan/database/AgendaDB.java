package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Agenda;


/**
 * Repository interface for performing CRUD operations on entities.
*/

public interface AgendaDB extends CrudRepository<Agenda,Integer> {
    
    /**
     * Retrieves a list of Agenda entities associated with a specific account executive.
     *
     * @param executiveId the ID of the account executive whose agendas are to be retrieved.
     * @return a List of Agenda entities associated with the given account executive ID.
    */
    @Query("SELECT a FROM Agenda a WHERE a.accountExecutive.id = :executiveId")
    List<Agenda> findAllAgendaOfAccountExecutiveById(int executiveId);
}
