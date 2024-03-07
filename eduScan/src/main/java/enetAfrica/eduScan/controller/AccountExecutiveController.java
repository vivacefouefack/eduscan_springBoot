package enetAfrica.eduScan.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import enetAfrica.eduScan.controller.api.AccountExecutiveApi;
import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.dto.AuthenticationDto;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.security.JwtService;
import enetAfrica.eduScan.service.AccountExecutiveService;
import enetAfrica.eduScan.utils.Constant;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountExecutiveController implements AccountExecutiveApi{

    private AccountExecutiveService service;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @Override
    public Map<String, String> connexionAccountExecutive(@RequestBody AuthenticationDto authenticationDto){
       
        final Authentication authenticate =authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authenticationDto.getUsername(), authenticationDto.getPassword())
        );
        
        if(authenticate.isAuthenticated()){
            System.out.println("+++++++++++++++++++++++++++++++++++++"+authenticate.isAuthenticated());
            return jwtService.generateJwt(authenticationDto.getUsername());
        }

        Map<String, String> msg= Map.of(
            Constant.CONNEXION_ERROR,Constant.CONNEXION_ERROR_VALUE
        );
         
        return msg;
    }


    @Override
    public ResponseEntity<AccountExecutive> addAccountExecutive(@RequestBody AccountDto accountDto) {
        try {
            AccountExecutive newAccountExecutive = service.addAccountExecutive(accountDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(newAccountExecutive);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<AccountExecutive> updateAccountExecutive(@RequestBody AccountDto accountDto) {
        try {
            AccountExecutive updatedAccountExecutive = service.updateAccountExecutive(accountDto);
            return ResponseEntity.ok(updatedAccountExecutive);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Integer> deleteAccountExecutive(@PathVariable int id) {
        try {
            service.deleteAccountExecutive(id);
            return ResponseEntity.ok(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Iterable<AccountExecutive>> getAllAccountExecutives() {
        try {
            return ResponseEntity.ok(service.getAllAccountExecutives());
        } catch (Exception e) {       
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<AccountExecutive> getAccountExecutiveById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.getAccountExecutiveById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
