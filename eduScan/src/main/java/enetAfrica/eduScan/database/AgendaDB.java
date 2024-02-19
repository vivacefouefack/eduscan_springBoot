package enetAfrica.eduScan.database;

import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Agenda;

public interface AgendaDB extends CrudRepository<Agenda,Integer> {
    
}
