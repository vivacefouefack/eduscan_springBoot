package enetAfrica.eduScan.database;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Visit;

public interface VisitDB extends CrudRepository<Visit,Integer> {
    
}
