package enetAfrica.eduScan.dto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class AccountDtoTest {

    @Autowired private BeanValidationUtil<AccountDto> validator;

    @Test
    public void firstNameNotBlank() {
        AccountDto accountDto = new AccountDto();
        accountDto.setFirstName("");
        validator.assertIsValid(accountDto);
    }


    

}
