package enetAfrica.eduScan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.model.AccountExecutive;

@Service
public class Business {

    @Autowired private AccountExecutiveDB accountExecutiveDB;

    /**
     * 
     * @param id
     * @return
     */
    public AccountExecutive getAccountExecutiveById(int id){
        if (id != 0) {
            return accountExecutiveDB.findById(id).get();
        } else {
            throw new IllegalArgumentException("L'identifiant ne doit pas être null pour récupérer un AccountExecutive.");
        }
    }

    /**
     * 
     * @param accountDto
     * @return
     */
    public AccountExecutive addAccountExecutive(AccountExecutive accountDto) {
        if (accountDto!= null) {
            return accountExecutiveDB.save(accountDto);
        } else {
            throw new IllegalArgumentException("L'objet ne doit pas être null pour l'ajout d'un AccountExecutive.");
        }
    }

    /**
     * permet la mise à jour d'un AccountExecutive
     * @param newData objet contenant les nouvelle valeur de l'accountExecutive à mettre à jour.
     * @return  l'AccountExecutive mis à jour.
     */
    public AccountExecutive updateAccountExecutive(AccountExecutive newData) {
        if (newData.getId() != 0) {
            return accountExecutiveDB.save(newData);
        } else {
            throw new IllegalArgumentException("L'identifiant ne doit pas être null pour mettre à jour un AccountExecutive.");
        }
    }

    /**
     * supprimer un AccountExecutive à travers son identifiant.
     * @param id représente l'identifiant de l'AccountExecutive à supprimer.
     */
    public void deleteAccountExecutive(int id) {
        if (id != 0) {
            accountExecutiveDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("L'identifiant ne doit pas être null pour supprimer un AccountExecutive.");
        }
    }


    /**
     * permet de récupérer tous les AccountExecutive
     * @return la liste de tous les AccountExecutive
     */
    public Iterable<AccountExecutive> getAllAccountExecutives() {
        return accountExecutiveDB.findAll();
    }

}
