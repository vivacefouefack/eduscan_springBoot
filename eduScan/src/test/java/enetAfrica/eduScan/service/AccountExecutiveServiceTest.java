package enetAfrica.eduScan.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.exception.ErrorCode;
import enetAfrica.eduScan.exception.NotFoundException;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.utils.Constant;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountExecutiveServiceTest {
    
    @Autowired
    private AccountExecutiveService service;  

    @Test
    public void shouldSaveAccountExecutiveWithSuccess() {
        AccountDto accountDto=new AccountDto(10, "elise", "Abie", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);
        AccountExecutive account=service.addAccountExecutive(accountDto);

        assertNotNull(account);
        assertNotNull(account.getId());
        assertEquals(account.getFirstName(), accountDto.getFirstName());
        assertEquals(account.getFunction().getId(), accountDto.getFunction());
    }

    @Test
    public void shouldThrowNotFoundException() {
        NotFoundException expectedException = assertThrows(NotFoundException.class, () -> service.getAccountExecutiveById(0));

        assertEquals(ErrorCode.ACCOUNTEXECUTIVE_NOT_FOUND, expectedException.getErrorCode());
        assertEquals(Constant.ACCOUNT_NOT_FOUND_MESSAGE, expectedException.getMessage());
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundException2() {
        service.getAccountExecutiveById(0);
    }

    @Test
    public void shouldGetAllAccountExecutiveWithSuccess() {
        AccountDto accountDto1=new AccountDto(22, "elise", "Abie", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);
        AccountDto accountDto2=new AccountDto(21, "elise", "Abie", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);      
        service.addAccountExecutive(accountDto1);
        service.addAccountExecutive(accountDto2);
        int counter = countElement(service.getAllAccountExecutives());
        int current = 7;
      
        assertNotNull(service.getAllAccountExecutives());
        assertEquals(counter, current);
    }

    @Test
    public void shouldGetAllAccountExecutiveNotFound() {
        AccountDto accountDto1=new AccountDto(23, "elise", "Abie", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);
        AccountDto accountDto2=new AccountDto(24, "elise", "Abie", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);      
        service.addAccountExecutive(accountDto1);
        service.addAccountExecutive(accountDto2);
        int counter = countElement(service.getAllAccountExecutives());
        int size=25;
         
        assertNotNull(service.getAllAccountExecutives());
        assertNotEquals(accountDto1, accountDto2);
        assertNotEquals(counter, size);
    }

    @Test
    public void shouldGetAccountExecutiveByIdWithSuccess() {
        AccountExecutive account=service.getAccountExecutiveById(10);
        assertNotNull(account);
    }

    @Test
    public void shouldUpdateAccountWithSuccess() {
        AccountDto accountDto = new AccountDto(10,"elise","Tiete","0595010101","riviera","cocody","src/img.jpg",1,2,3,4);
        AccountExecutive account=service.updateAccountExecutive(accountDto);

        assertNotNull(account);
        assertEquals(accountDto.getFirstName(), account.getFirstName());
        assertEquals(accountDto.getProspectingMunicipality(), account.getProspectingMunicipality());
    }

    @Test
    public void shouldDeleteAccountWithSuccess() {
        int currentSize=countElement(service.getAllAccountExecutives());
        service.deleteAccountExecutive(12);
        int afterDeleteSize=countElement(service.getAllAccountExecutives());
        assertEquals(afterDeleteSize, currentSize-1);
    }

    public int countElement(Iterable<AccountExecutive> list){
        int counter = 0;
        for (Object i :list) {
            System.out.println(i);
            counter++;
        }
        return counter;
    }





}
