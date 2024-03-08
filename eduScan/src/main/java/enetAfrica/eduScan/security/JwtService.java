package enetAfrica.eduScan.security;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enetAfrica.eduScan.dto.TokenDto;
import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.model.JwToken;
import enetAfrica.eduScan.service.AccountExecutiveService;
import enetAfrica.eduScan.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class JwtService {

    @Autowired private AccountExecutiveService accountService;
    @Autowired private TokenService tokenService;

    final String BEARER="bearer";

    @Value("${app.metadata.key}")
    private String encriptKey;

    public Map<String,String>  generateJwt(String userName){
        AccountExecutive account= accountService.getAccountExecutiveByUserName(userName);
        Map<String, String> jwt = generateToken(account);

        TokenDto tokenDto=new TokenDto(0,jwt.get(BEARER),false,account);
        tokenService.addToken(tokenDto);

        return generateToken(account);
    }

    private Map<String,String> generateToken(AccountExecutive account) {

        final Long currentTime=System.currentTimeMillis();
        final Long endTime= currentTime + 60*60*1000;

        final Map<String, Object> claims = Map.of(
            "name", account.getUsername(),
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
        return Map.of(BEARER, bearer);
    }

    private Key getKey() {
        final byte[] decoder = Decoders.BASE64.decode(encriptKey);
        return Keys.hmacShaKeyFor(decoder);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    boolean isTokenExpired(String token) {
        Date expirationDate = extractExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }
   

    private Date extractExpirationDateFromToken(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> function) {
        Claims claims = extractAllClaims(token);
        return function.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public void logout() {
        AccountExecutive account=(AccountExecutive) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JwToken jwtoken = tokenService.findByUserUsernameAndExpire(account.getUsername(), false).get();
        jwtoken.setExpire(true);
        tokenService.updateToken(jwtoken);                       
    }
}
