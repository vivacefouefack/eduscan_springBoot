package enetAfrica.eduScan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id; 
    private String password;
    private boolean actif;
    
    private String username;
    
    private String firstName; 

    private String lastName;

    private String phoneNumber;

    private String prospectingZone;
                                        
    private String prospectingMunicipality;

    private String photo;

    private int function;


    private String superiorN1;


    private String superiorN2;

    private String superiorN3;
}
