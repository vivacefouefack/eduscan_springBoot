package enetAfrica.eduScan.database;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.ProspectionRecord;

public interface ProspectionRecordDB extends CrudRepository<ProspectionRecord,Integer>{
    
}
