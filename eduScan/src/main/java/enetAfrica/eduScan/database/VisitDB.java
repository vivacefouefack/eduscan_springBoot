package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Visit;

/**
 * Repository interface for performing CRUD operations on entities.
*/

public interface VisitDB extends CrudRepository<Visit,Integer> {

    /**
     * Retrieves a list of Visit entities associated with a specific account executive.
     *
     * @param id the ID of the account executive whose visits are to be retrieved.
     * @return a List of Visit entities associated with the given account executive ID.
     */
    @Query(value = "SELECT * FROM visit WHERE account_executive_id = :id", nativeQuery = true)
    List<Visit> findByAccountExecutiveId(int id);
}
