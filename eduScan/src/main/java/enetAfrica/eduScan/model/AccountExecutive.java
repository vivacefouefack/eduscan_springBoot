package enetAfrica.eduScan.model;

import java.util.Set;

import io.micrometer.common.lang.NonNull;
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
    
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String phoneNumber;
    @NonNull private String function;
    @NonNull private String prospectingZone;
    @NonNull private String prospectingMunicipality;
    @NonNull private String photo;

    @OneToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @OneToMany(mappedBy="accountExecutive")
    private Set<Agenda> agendas;

    @OneToMany(mappedBy="accountExecutive")
    private Set<Visit> visits;

    private int superiorN1;
    private int superiorN2;
    private int superiorN3;

}
