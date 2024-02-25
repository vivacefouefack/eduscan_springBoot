package enetAfrica.eduScan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.RoleDB;
import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;

@Service
public class AccountExecutiveService {

    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private RoleDB roleDB;

    /**
     * permet d'obtenir un AccountExecutive à partir de son identifiant.
     * @param id identifiant du AccountExecutive que nous souhaitons récupérer. 
     * @return AccountExecutive
     */
    public AccountExecutive getAccountExecutiveById(int id){
        if (id != 0) {
            Optional<AccountExecutive> optionalAccountExecutive = accountExecutiveDB.findById(id);
            if (optionalAccountExecutive.isPresent()) {
                return optionalAccountExecutive.get();
            } else {
                throw new IllegalArgumentException("Aucun AccountExecutive trouvé avec cet identifiant.");
            }
            
        } else {
            throw new IllegalArgumentException("L'identifiant ne doit pas être null pour récupérer un AccountExecutive.");
        }
    }

    /**
     * permet d'ajouter un nouveau AccountExecutive
     * @param accountDto
     * @return AccountExecutive 
     */
    public AccountExecutive addAccountExecutive(AccountDto accountDto) {
        if (accountDto!= null) {
            AccountExecutive newAccount=new AccountExecutive();
            newAccount.setFirstName(accountDto.getFirstName());
            newAccount.setLastName(accountDto.getLastName());
            newAccount.setPhoneNumber(accountDto.getPhoneNumber());
            newAccount.setProspectingZone(accountDto.getProspectingZone());
            newAccount.setProspectingMunicipality(accountDto.getProspectingMunicipality());
            newAccount.setPhoto(accountDto.getPhoto());
            newAccount.setSuperiorN1(accountDto.getSuperiorN1());
            newAccount.setSuperiorN2(accountDto.getSuperiorN2());
            newAccount.setSuperiorN3(accountDto.getSuperiorN3());
            System.out.println("***************************"+accountDto.toString());
            newAccount.setFunction(roleDB.findById(accountDto.getFunction()).get());
            return accountExecutiveDB.save(newAccount);
        } else {
            throw new IllegalArgumentException("L'objet ne doit pas être null pour l'ajout d'un AccountExecutive.");
        }
    }

    /**
     * permet la mise à jour d'un AccountExecutive
     * @param newData objet contenant les nouvelle valeur de l'accountExecutive à mettre à jour.
     * @return  l'AccountExecutive mis à jour.
     */
    public AccountExecutive updateAccountExecutive(AccountDto accountDto) {
        if (accountExecutiveDB.existsById(accountDto.getId())) {
            AccountExecutive accountExecutive=accountExecutiveDB.findById(accountDto.getId()).get();
            accountExecutive.setFirstName(accountDto.getFirstName());
            accountExecutive.setLastName(accountDto.getLastName());
            accountExecutive.setPhoneNumber(accountDto.getPhoneNumber());
            accountExecutive.setProspectingZone(accountDto.getProspectingZone());
            accountExecutive.setProspectingMunicipality(accountDto.getProspectingMunicipality());
            accountExecutive.setPhoto(accountDto.getPhoto());
            accountExecutive.setSuperiorN1(accountDto.getSuperiorN1());
            accountExecutive.setSuperiorN2(accountDto.getSuperiorN2());
            accountExecutive.setSuperiorN3(accountDto.getSuperiorN3());
            accountExecutive.setFunction(roleDB.findById(accountDto.getFunction()).get());
            return accountExecutiveDB.save(accountExecutive);
        } else {
            throw new IllegalArgumentException("Ce compte n'existe pas.");
        }
    }

    /**
     * supprimer un AccountExecutive à travers son identifiant.
     * @param id représente l'identifiant de l'AccountExecutive à supprimer.
     */
    public void deleteAccountExecutive(int id) {
        if (accountExecutiveDB.existsById(id)) {
            accountExecutiveDB.deleteById(id);
        } else {
            throw new IllegalArgumentException("Ce compte n'existe pas.");
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
