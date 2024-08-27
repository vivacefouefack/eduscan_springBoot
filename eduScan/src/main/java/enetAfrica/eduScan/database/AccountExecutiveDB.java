package enetAfrica.eduScan.database;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.AccountExecutive;

/**
 * Repository interface for performing CRUD operations on entities.
*/


public interface AccountExecutiveDB extends CrudRepository<AccountExecutive,Integer> {

    /**
     * Finds an entity by its username.
     *
     * @param username the username of the account executive.
     * @return an containing the found AccountExecutive, or an empty {@link Optional} if no account executive is found with the given username.
    */
    Optional<AccountExecutive> findByUserName(String username);
    //Optional<AccountExecutive> findByUsername(String username);
}