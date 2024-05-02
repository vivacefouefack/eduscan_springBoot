package enetAfrica.eduScan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Autowired private BCryptPasswordEncoder bCryptPassword;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private JwtFilterService jwtFilterService;
     
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
            http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorize ->
                                authorize
                                    .requestMatchers(POST,"/api/institution/ajouter").permitAll()
                                    .requestMatchers(POST,"/api/account/login").permitAll()
                                    .requestMatchers(POST,"/api/account/logout").authenticated()
                                    .requestMatchers(POST,"/api/account/add").hasAnyRole("ADMIN","MANAGER") 
                                    .requestMatchers(PUT,"/api/account/update").hasAnyRole("ADMIN","PROSPECTOR")                                        
                                    .requestMatchers(GET,"/api/account/getall").hasAnyRole("PROSPECTOR","MANAGER") 
                                    .requestMatchers(GET,"/api/account/get/**").hasAnyRole("ADMIN","MANAGER") 
                                    .requestMatchers(DELETE,"/api/account/delete").hasAnyRole("ADMIN","MANAGER") 
                                    .requestMatchers(DELETE,"/api/prospection/delete/**").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .requestMatchers(GET,"/api/prospection/**").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .requestMatchers(POST,"/api/institution/add").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .requestMatchers(PUT,"/api/institution/update").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .requestMatchers(GET,"/api/institution/getall").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .requestMatchers(GET,"/images/**").hasAnyRole("ADMIN","PROSPECTOR") 
                                    .anyRequest().authenticated())
                .sessionManagement(httpSecurityManagementConfigurer ->
                    httpSecurityManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilterService, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(bCryptPassword);
        return daoAuthenticationProvider;
    }

}
