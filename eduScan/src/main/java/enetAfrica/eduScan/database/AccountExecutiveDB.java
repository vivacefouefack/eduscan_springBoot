package enetAfrica.eduScan.database;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.AccountExecutive;




public interface AccountExecutiveDB extends CrudRepository<AccountExecutive,Integer> {

    Optional<AccountExecutive> findByUserName(String username);
    //Optional<AccountExecutive> findByUsername(String username);
}