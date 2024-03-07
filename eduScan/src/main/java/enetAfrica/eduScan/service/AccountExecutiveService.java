package enetAfrica.eduScan.service;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;


public interface AccountExecutiveService{

    /**
     * permet d'obtenir un AccountExecutive à partir de son identifiant.
     * @param id identifiant du AccountExecutive que nous souhaitons récupérer. 
     * @return AccountExecutive
     */
    public AccountExecutive getAccountExecutiveById(Integer id);

    /**
     * 
     * @param username
     * @return
     */
    public AccountExecutive getAccountExecutiveByUserName(String username);

    /**
     * permet d'ajouter un nouveau AccountExecutive
     * @param accountDto
     * @return AccountExecutive 
     */
    public AccountExecutive addAccountExecutive(AccountDto accountDto);

    /**
     * permet la mise à jour d'un AccountExecutive
     * @param newData objet contenant les nouvelle valeur de l'accountExecutive à mettre à jour.
     * @return  l'AccountExecutive mis à jour.
     */
    public AccountExecutive updateAccountExecutive(AccountDto accountDto);

    /**
     * supprimer un AccountExecutive à travers son identifiant.
     * @param id représente l'identifiant de l'AccountExecutive à supprimer.
     */
    public void deleteAccountExecutive(Integer id);


    /**
     * permet de récupérer tous les AccountExecutive
     * @return la liste de tous les AccountExecutive
     */
    public Iterable<AccountExecutive> getAllAccountExecutives();
    

}
