package enetAfrica.eduScan.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import enetAfrica.eduScan.dto.AccountDto;
import enetAfrica.eduScan.model.AccountExecutive;
import jakarta.validation.Valid;

public interface AccountExecutiveApi {

    @PostMapping("/add")
    public ResponseEntity<AccountExecutive> addAccountExecutive(@Valid  @RequestBody AccountDto accountDto);

    @PutMapping("/update")
    public ResponseEntity<AccountExecutive> updateAccountExecutive(@Valid  @RequestBody AccountDto accountDto);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteAccountExecutive(@PathVariable int id);

    @GetMapping("/getall")
    public ResponseEntity<Iterable<AccountExecutive>> getAllAccountExecutives();

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountExecutive> getAccountExecutiveById(@PathVariable int id);
}
