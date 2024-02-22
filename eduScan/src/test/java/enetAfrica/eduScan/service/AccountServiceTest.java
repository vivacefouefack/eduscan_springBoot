package enetAfrica.eduScan.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;

@WebMvcTest
public class AccountServiceTest {
    @Autowired private MockMvc mvc;
    @MockBean private AccountExecutiveService service;  

    @Test
    public void testGetAccountExecutiveById() throws Exception {
        AccountExecutive account=new AccountExecutive();
        account.setId(1);
        account.setFirstName("abié");
        Mockito.when(service.getAccountExecutiveById(1)).thenReturn(account);
        mvc.perform(get("/api/eduscan/AccountExecutive/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.firstName").value(account.getFirstName()));
    }

    @Test
    public void testAccountExecutiveNotFound() throws Exception {
        int id = 200;
        Mockito.when(service.getAccountExecutiveById(id)).thenReturn(null);
        mvc.perform(get("/api/eduscan/AccountExecutive/{id}", id))
           .andExpect(content().string(""));
    }

    @Test
    public void testNoAccountExecutiveExist() throws Exception {
        List<AccountExecutive> emptyList = new ArrayList<>();
        Mockito.when(service.getAllAccountExecutives()).thenReturn(emptyList);

        mvc.perform(get("/api/eduscan/AllAccountExecutive"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$").isArray())
           .andExpect(jsonPath("$").isEmpty());
    }

    /*@Test
    public void testAddAccountExecutive() throws Exception {
        AccountDto accountDto = new AccountDto("elise","Tiete","0595010101","riviera","cocody","src/img.jpg",1,2,3,4);

        AccountExecutive account = new AccountExecutive(1,"elise","Tiete","0595010101","riviera","cocody","src/img.jpg",1,2,3);

        Mockito.when(service.addAccountExecutive(accountDto)).thenReturn(account);
        mvc.perform((RequestBuilder) ((ResultActions) post("/api/eduscan/AddAccountExecutive")
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.firstName").value("elise")));
    }*/

    @Test
    public void testUpdateAccountExecutive() throws Exception {
        AccountDto newData = new AccountDto();
        newData.setId(1);
        newData.setFirstName("abié 2");

        AccountExecutive account=service.getAccountExecutiveById(1);
        account.setFirstName("abié 2");

        Mockito.when(service.updateAccountExecutive(newData)).thenReturn(account);
        mvc.perform(put("/api/eduscan/UpdateAccountExecutive")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"id\": 1, \"firstName\": \"abié 2\"}"))
            .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAccountExecutive() throws Exception {
        int id = 1;
        Mockito.doNothing().when(service).deleteAccountExecutive(id);
        mvc.perform(delete("/api/eduscan/DeleteAccountExecutive/{id}", id))
           .andExpect(status().isNoContent());
    }
}
