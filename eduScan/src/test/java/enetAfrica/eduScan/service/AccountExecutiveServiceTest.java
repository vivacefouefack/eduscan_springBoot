package enetAfrica.eduScan.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountExecutiveServiceTest {
    
    @Autowired
    private AccountExecutiveService service;  

    @Test
    public void shouldSaveAccountExecutiveWithSuccess() {
        AccountDto accountDto=new AccountDto(10, "elise", "vivace", "0596001001", "cocody", "riviera", "/src/img.jpg", 3, 1, 2, 3);
        AccountExecutive account=service.addAccountExecutive(accountDto);

        assertNotNull(account);
        assertNotNull(account.getId());
        assertEquals(account.getFirstName(), accountDto.getFirstName());
        assertEquals(account.getFunction().getId(), accountDto.getFunction());
    }
}
