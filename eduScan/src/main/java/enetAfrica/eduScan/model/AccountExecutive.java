package enetAfrica.eduScan.model;

import java.io.File;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountExecutive {
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String function;
    private String prospectingZone;
    private String prospectingMunicipality;
    private int superiorN1;
    private int superiorN2;
    private int superiorN3;
    private File photo;
    private int role;

}
