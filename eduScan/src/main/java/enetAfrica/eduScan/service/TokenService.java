package enetAfrica.eduScan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.database.TokenDb;
import enetAfrica.eduScan.dto.TokenDto;
import enetAfrica.eduScan.model.JwToken;

@Service
public class TokenService {
    
    @Autowired private TokenDb tokenDb;

    public void addToken(TokenDto dto){
        JwToken newToken=new JwToken();
        newToken.setValue(dto.getValue());
        newToken.setExpire(dto.isExpire());
        newToken.setUser(dto.getUser());
        tokenDb.save(newToken);
    }

    public JwToken findByValue(String token) {
        return tokenDb.findByValue(token).get();
    }

    public  void updateToken(JwToken token) {
        tokenDb.save(token);
    }

    public Optional<JwToken> findByUserUsernameAndExpire(String username,boolean expire){
        return tokenDb.findByUserUsernameAndExpire(username, expire);
    }

    public void deleteAllExpire(boolean expire) {
        tokenDb.deleteByExpire(expire);
    }

    public void setExpire(String userName, boolean newValue) {
        tokenDb.updateExpireField(userName, newValue, false);
    }
}
