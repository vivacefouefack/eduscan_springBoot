package enetAfrica.eduScan.security;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    @Autowired
    private AccountExecutiveService accountService;

    private final String ENCRIPT_KEY ="921v36e92dc66d97d9733f0e6371493cb7fc05b1aa8f8de64014732472303a7c";

    public Map<String,String>  generateJwt(String userName){
        AccountExecutive account= accountService.getAccountExecutiveByUserName(userName);
        return generateToken(account);
    }

    private Map<String,String> generateToken(AccountExecutive account) {

        final Long currentTime=System.currentTimeMillis();
        final Long endTime= currentTime + 60*60*1000;

        final Map<String, Object> claims = Map.of(
            "name", account.getFirstName() +" "+account.getLastName(),
            Claims.EXPIRATION, new Date(endTime),
            Claims.SUBJECT, account.getUsername()
        );

        final String bearer = 
            Jwts.builder()
                .setIssuedAt(new Date(currentTime))
                .setExpiration(new Date(endTime))
                .setSubject(account.getUsername())
                .setClaims(claims)
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("bearer", bearer);
    }

    private Key getKey() {
        final byte[] decoder = Decoders.BASE64.decode(ENCRIPT_KEY);
        return Keys.hmacShaKeyFor(decoder);
    }
}
