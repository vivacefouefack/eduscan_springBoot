package enetAfrica.eduScan.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Collection;
import java.util.Collections;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountExecutive implements UserDetails{
    @Id
    @GeneratedValue
    private Integer id;
    
    private String userName;
    private String passWord;
    private boolean actif=false;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String prospectingZone;
    private String prospectingMunicipality;
    private String photo;

    @ManyToOne
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+function.getName()));
    }

    @Override
    public String getPassword() {
        return passWord; 
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return actif;
    }

    @Override
    public boolean isAccountNonLocked() {
        return actif;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return actif;
    }

    @Override
    public boolean isEnabled() {
        return actif;
    }

}
  