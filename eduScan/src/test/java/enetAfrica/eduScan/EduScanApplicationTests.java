package enetAfrica.eduScan;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.service.AccountExecutiveService;

@SpringBootTest
@AutoConfigureMockMvc
class EduScanApplicationTests {

	@MockBean private AccountExecutiveService service;

    @Autowired private MockMvc mockMvc;

    @Test
    void testGetAccount() throws Exception {
        AccountDto newAccountDto=new AccountDto();
        newAccountDto.setFirstName("Abié");
        service.addAccountExecutive(newAccountDto);
        mockMvc.perform(get("/api/eduscan/AllAccountExecutive"))
            .andExpect(status().isOk());
    }
	

}
