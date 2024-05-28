package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileDB extends CrudRepository<InstitutionProfile,Integer> {
    
    @Query(value = "SELECT * FROM institution_profile WHERE account_executive_id = :id", nativeQuery = true)
    List<InstitutionProfile> findByAccountExecutiveId(int id);
}


