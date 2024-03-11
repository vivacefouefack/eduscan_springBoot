package enetAfrica.eduScan.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import enetAfrica.eduScan.model.JwToken;


public interface TokenDb extends CrudRepository<JwToken,Integer>{

    Optional<JwToken> findByValue(String value);
    
    @Query("SELECT t FROM JwToken t WHERE t.user.userName = :username AND t.expire = :expire")
    Optional<JwToken> findByUserUsernameAndExpire(String username,boolean expire);

    @Modifying
    @Transactional
    @Query("UPDATE JwToken t SET t.expire = :newValue WHERE t.user.userName = :username AND t.expire = :oldValue")
    void updateExpireField(String username,boolean newValue, boolean oldValue);
    
    void deleteByExpire(boolean expire);
} 
