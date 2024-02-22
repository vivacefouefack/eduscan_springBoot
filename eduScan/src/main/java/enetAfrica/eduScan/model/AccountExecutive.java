package enetAfrica.eduScan.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private String prospectingZone;
    private String prospectingMunicipality;
    private String photo;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role function;

    @OneToMany(mappedBy="accountExecutive")
    private Set<Agenda> agendas;

    @OneToMany(mappedBy="accountExecutive")
    private Set<Visit> visits;

    private int superiorN1;
    private int superiorN2;
    private int superiorN3;


    public AccountExecutive (int id,String firstName, String lastName, String phoneNumber, String prospectingZone, String prospectingMunicipality, String photo, int superiorN1, int superiorN2, int superiorN3) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.prospectingZone = prospectingZone;
        this.prospectingMunicipality = prospectingMunicipality;
        this.photo = photo;
        this.superiorN1 = superiorN1;
        this.superiorN2 = superiorN2;
        this.superiorN3 = superiorN3;
    }

}
