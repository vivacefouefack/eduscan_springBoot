package enetAfrica.eduScan.database;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.InstitutionProfile;

public interface InstitutionProfileDB extends CrudRepository<InstitutionProfile,Integer> {
    
}
