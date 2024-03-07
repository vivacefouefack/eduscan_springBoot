package enetAfrica.eduScan.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import enetAfrica.eduScan.model.AccountExecutive;
import enetAfrica.eduScan.service.AccountExecutiveService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class JwtFilterService extends OncePerRequestFilter {

    @Autowired private AccountExecutiveService accountService;
    @Autowired private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{

        String username=null;
        String token=null;
        boolean isTokenExpired = true;
        
        final String autorization=request.getHeader("Authorization");
        if(autorization!=null && autorization.startsWith("bearer ")){
            token=autorization.substring(7);
            isTokenExpired = jwtService.isTokenExpired(token);
            username=jwtService.extractUserName(token);
        }
        
        if(!isTokenExpired && username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            AccountExecutive account = accountService.getAccountExecutiveByUserName(username);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account, null, account.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
    
}
