package enetAfrica.eduScan.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.Agenda;

public interface AgendaDB extends CrudRepository<Agenda,Integer> {
    
    @Query("SELECT a FROM Agenda a WHERE a.accountExecutive.id = :executiveId")
    List<Agenda> findAllAgendaOfAccountExecutiveById(int executiveId);
}
