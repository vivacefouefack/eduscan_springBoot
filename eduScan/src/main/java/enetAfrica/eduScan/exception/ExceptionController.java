package enetAfrica.eduScan.exception;


import java.security.SignatureException;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.MalformedJwtException;

@RestControllerAdvice
public class ExceptionController {
    
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value={MalformedJwtException.class,SignatureException.class})
    public ProblemDetail badCredentialsException(BadCredentialsException exception){
        return ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, "Token invalide");
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value=AccessDeniedException.class)
    public ProblemDetail accessDeniedException(AccessDeniedException exception){
        return ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, "Accès non autorisé");
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value=Exception.class)
    public Map<String,String> exceptionHandle(Exception exception){
        return Map.of("erreur", "nous n'avons pas pu vous identifier");
    }

}
