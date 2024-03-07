package enetAfrica.eduScan.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.RoleDB;
import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;
import enetAfrica.eduScan.utils.Constant;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class AccountExecutiveServiceImp implements AccountExecutiveService, UserDetailsService {
    @Autowired private AccountExecutiveDB accountExecutiveDB;
    @Autowired private RoleDB roleDB;

    @Bean
    public BCryptPasswordEncoder bCryptPassword() {
        return new BCryptPasswordEncoder();
    }

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
            String passWord=bCryptPassword().encode(accountDto.getPassword());
            AccountExecutive newAccount=new AccountExecutive();
            newAccount.setPassWord(passWord);
            newAccount.setActif(accountDto.isActif());
            newAccount.setUserName(accountDto.getUsername());
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountExecutiveDB.findByUserName(username).orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à ce nom utilisateur"));
    }

    //@Override
    //public UserDetails loadUserByUsernames(String username) {
    //    return loadUserByUsername(username);
    //}
}
