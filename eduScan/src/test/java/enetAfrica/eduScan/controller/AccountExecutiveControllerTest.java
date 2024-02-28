package enetAfrica.eduScan.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountExecutiveController.class)
public class AccountExecutiveControllerTest {
    
    @Autowired private MockMvc mvc;
    @MockBean private AccountExecutiveService service; 

    @Test
    public void testGetAccountExecutiveById() throws Exception{
        AccountExecutive account=new AccountExecutive();
        account.setId(11);
        account.setFirstName("nelson");
        Mockito.when(service.getAccountExecutiveById(11)).thenReturn(account);
            mvc.perform(get("/api/account/get/11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.firstName").value(account.getFirstName()));

    }

    @Test
    public void testGetAccountExecutiveByIdFailure() throws Exception{
        Mockito.when(service.getAccountExecutiveById(100)).thenReturn(null);
            mvc.perform(get("/api/account/get/100"))
            .andExpect(status().isOk());
    }

    @Test
    public void testNoAccountExecutiveExist() throws Exception {
        List<AccountExecutive> emptyList = new ArrayList<>();
        Mockito.when(service.getAllAccountExecutives()).thenReturn(emptyList);

        mvc.perform(get("/api/account/getall"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$").isEmpty());
    }


    @Test
    public void testAddAccountExecutive() throws Exception {
        AccountDto accountDto = new AccountDto();
        accountDto.setFirstName("enet");
        accountDto.setLastName("imasoft");
        
        AccountExecutive account = new AccountExecutive();
        account.setId(1);
        account.setFirstName(accountDto.getFirstName());
        account.setLastName(accountDto.getLastName());

        
        Mockito.when(service.addAccountExecutive(accountDto)).thenReturn(account);

        ObjectMapper objectMapper = new ObjectMapper();
        String accountDtoJson = objectMapper.writeValueAsString(account);

        mvc.perform(post("/api/account/add")
           .contentType(MediaType.APPLICATION_JSON)
           .content(accountDtoJson))
           .andExpect(status().isOk());

    }
    
}
