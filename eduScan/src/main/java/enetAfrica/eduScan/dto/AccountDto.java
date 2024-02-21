package enetAfrica.eduScan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String prospectingZone;
    private String prospectingMunicipality;
    private String photo;
    private int role;
    private int superiorN1;
    private int superiorN2;
    private int superiorN3;
}
