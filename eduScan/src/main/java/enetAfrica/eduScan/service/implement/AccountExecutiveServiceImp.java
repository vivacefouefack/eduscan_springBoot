package enetAfrica.eduScan.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.RoleDB;
import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;
import enetAfrica.eduScan.utils.Constant;

@Service
public class AccountExecutiveServiceImp implements AccountExecutiveService {
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private RoleDB roleDB;

    @Override
    public AccountExecutive getAccountExecutiveById(Integer id){
        return accountExecutiveDB.findById(id).orElseThrow(() ->
            new NotFoundException(Constant.ACCOUNT_NOT_FOUND_MESSAGE, ErrorCode.ACCOUNTEXECUTIVE_NOT_FOUND)
        );
    }

    @Override
    public AccountExecutive addAccountExecutive(AccountDto accountDto) {
        if(accountDto==null){
            return null;
        }else{
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
            newAccount.setFunction(roleDB.findById(accountDto.getFunction()).get());
            return accountExecutiveDB.save(newAccount);
        }
    }

    @Override
    public AccountExecutive updateAccountExecutive(AccountDto accountDto) {
        if(accountDto==null){
            return null;
        }else{
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
        }
        
    }

    @Override
    public void deleteAccountExecutive(Integer id) {
        if (id !=null) {
            accountExecutiveDB.deleteById(id);
        } 
    }


    @Override
    public Iterable<AccountExecutive> getAllAccountExecutives() {
        return accountExecutiveDB.findAll();
    }
}
