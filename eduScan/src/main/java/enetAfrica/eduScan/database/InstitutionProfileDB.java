package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.InstitutionProfile;

/**
 * Repository interface for performing CRUD operations on entities.
*/

public interface InstitutionProfileDB extends CrudRepository<InstitutionProfile,Integer> {
    
    /**
     * Retrieves a list of InstitutionProfile entities associated with a specific account executive.
     *
     * @param id the ID of the account executive whose institution profiles are to be retrieved.
     * @return a {@link List} of InstitutionProfile entities associated with the given account executive ID.
    */
    @Query(value = "SELECT * FROM institution_profile WHERE account_executive_id = :id", nativeQuery = true)
    List<InstitutionProfile> findByAccountExecutiveId(int id);
}


