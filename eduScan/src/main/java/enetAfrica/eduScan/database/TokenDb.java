package enetAfrica.eduScan.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import enetAfrica.eduScan.model.JwToken;


public interface TokenDb extends CrudRepository<JwToken,Integer>{

    Optional<JwToken> findByValue(String value);
    
    Optional<JwToken> findByUserUsernameAndExpire(String username,boolean expire);
   // @Query("FROM jw_token j WHERE j.expire =:expire AND j.user.email =:email")
    //Optional<JwToken> findByUserValideToken(String email,boolean expire);
} 
