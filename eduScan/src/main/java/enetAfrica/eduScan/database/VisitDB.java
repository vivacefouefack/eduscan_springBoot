package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Visit;

public interface VisitDB extends CrudRepository<Visit,Integer> {
    
    @Query(value = "SELECT * FROM visit WHERE account_executive_id = :id", nativeQuery = true)
    List<Visit> findByAccountExecutiveId(int id);
}
