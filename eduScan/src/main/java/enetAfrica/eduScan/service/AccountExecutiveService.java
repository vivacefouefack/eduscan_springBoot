package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;


public interface AccountExecutiveService{

   /**
     * Retrieves an AccountExecutive by its ID.
     *
     * @param id the ID of the AccountExecutive to retrieve.
     * @return the AccountExecutive with the given ID.
    */
    public AccountExecutive getAccountExecutiveById(Integer id);

    /**
     * Retrieves an AccountExecutive by its username.
     *
     * @param username the username of the AccountExecutive to retrieve.
     * @return the AccountExecutive with the given username.
    */
    public AccountExecutive getAccountExecutiveByUserName(String username);

    /**
     * Adds a new AccountExecutive.
     *
     * @param accountDto the data transfer object containing the details of the new AccountExecutive.
     * @return the newly created AccountExecutive.
    */
    public AccountExecutive addAccountExecutive(AccountDto accountDto);

    /**
     * Updates an existing AccountExecutive.
     *
     * @param accountDto the data transfer object containing the updated values for the AccountExecutive.
     * @return the updated AccountExecutive.
    */
    public AccountExecutive updateAccountExecutive(AccountDto accountDto);

    /**
     * Deletes an AccountExecutive by its ID.
     *
     * @param id the ID of the AccountExecutive to delete.
    */
    public void deleteAccountExecutive(Integer id);

    /**
     * Retrieves all AccountExecutive entities.
     *
     * @return an Iterable of all AccountExecutive entities.
    */
    public Iterable<AccountExecutive> getAllAccountExecutives(); 

}
