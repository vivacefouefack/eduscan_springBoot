package enetAfrica.eduScan.service.implement;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.AccountExecutiveDB;
import enetAfrica.eduScan.database.RoleDB;
import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;
import enetAfrica.eduScan.service.EmailService;
import enetAfrica.eduScan.utils.Constant;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@AllArgsConstructor
public class AccountExecutiveServiceImp implements AccountExecutiveService, UserDetailsService {

    private BCryptPasswordEncoder bCryptPassword;
    private AccountExecutiveDB accountExecutiveDB;
    private RoleDB roleDB;
    private EmailService emailService;

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
            String passWord=bCryptPassword.encode(accountDto.getPassword());
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
            //newAccount.setSuperiorN1(accountDto.getSuperiorN1());
            //newAccount.setSuperiorN2(accountDto.getSuperiorN2());
            //newAccount.setSuperiorN3(accountDto.getSuperiorN3());
            
            newAccount.setFunction(roleDB.findById(5).get());

            AccountExecutive saveAccount = accountExecutiveDB.save(newAccount);
            if (saveAccount!=null) {
                try {
                    String body="Bonjour "+saveAccount.getFirstName()+",\n\n Bienvenu sur la plateforme eduScan. En tant que nouveau collaborateur chez E-net Africa, vous disposez d'un accès à l'application. Voici donc vos identifiants \n\n"+
                    "Nom d'utilisateur: "+saveAccount.getUsername() +"\n Mot de passe: "+accountDto.getPassword() +" \n\n\n l'équipe eduScan";
                    emailService.sendEmail(saveAccount.getUsername(), body);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            return saveAccount;
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
            //accountExecutive.setSuperiorN1(accountDto.getSuperiorN1());
            //accountExecutive.setSuperiorN2(accountDto.getSuperiorN2());
            //accountExecutive.setSuperiorN3(accountDto.getSuperiorN3());
            //accountExecutive.setFunction(roleDB.findById(accountDto.getFunction()).get());
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
    public AccountExecutive loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountExecutiveDB.findByUserName(username).orElseThrow(() -> new  UsernameNotFoundException("Aucun utilisateur ne corespond à ce nom utilisateur"));
    }

    @Override
    public AccountExecutive getAccountExecutiveByUserName(String username) {
        return loadUserByUsername(username);
    }

}
