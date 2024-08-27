package enetAfrica.eduScan.model;

import java.util.Set;

import jakarta.persistence.Column;
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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Represents an account executive in the system and implements {@link UserDetails} for security details.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountExecutive implements UserDetails{
    @Id @GeneratedValue private Integer id;
    @Column(unique = true) private String userName;
    private String passWord;
    private boolean actif=false;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String prospectingZone;
    private String prospectingMunicipality;
    private String photo;

    @ManyToOne @JoinColumn(name = "role_id", referencedColumnName = "id") 
    @Fetch(FetchMode.JOIN)
    private Role function;

    @OneToMany(mappedBy="accountExecutive")
    private Set<InstitutionProfile> institutionProfiles;

    @OneToMany(mappedBy="accountExecutive")
    private Set<Visit> visits;


    @OneToMany(mappedBy="accountExecutive")
    private Set<Agenda> agendas;
    private String superiorN1;
    private String superiorN2;
    private String superiorN3;


    /**
     * Returns the password of the account executive.
     *
     * @return the password of the account executive
     */
    @Override 
    public String getPassword() { 
        return passWord; 
    }

    /**
     * Returns the username of the account executive.
     *
     * @return the username of the account executive
     */
    @Override 
    public String getUsername() { 
        return userName; 
    }

    /**
     * Indicates whether the account is non-expired.
     * 
     * @return true if the account is active, false otherwise
     */
    @Override 
    public boolean isAccountNonExpired() { 
        return actif; 
    }

    /**
     * Indicates whether the account is non-locked.
     * 
     * @return true if the account is active, false otherwise
     */
    @Override 
    public boolean isAccountNonLocked() { 
        return actif; 
    }

    /**
     * Indicates whether the account is enabled.
     * 
     * @return true if the account is active, false otherwise
     */
    @Override 
    public boolean isEnabled() { 
        return actif; 
    }

    /**
     * Returns the authorities (roles) granted to the account executive.
     *
     * @return a collection of objects representing the executive's roles
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + function.getName()));
    }

    /**
     * Indicates whether the credentials are non-expired.
     * 
     * @return true if the credentials are non-expired, false otherwise
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return actif;
    }

    /**
     * Constructs an AccountExecutive with the specified details.
     *
     * @param id the identifier of the account executive
     * @param firstName the first name of the account executive
     * @param lastName the last name of the account executive
     * @param phoneNumber the phone number of the account executive
     * @param prospectingZone the prospecting zone of the account executive
     * @param prospectingMunicipality the prospecting municipality of the account executive
     * @param photo the photo of the account executive
     * @param superiorN1 the superior N1 of the account executive
     * @param superiorN2 the superior N2 of the account executive
     * @param superiorN3 the superior N3 of the account executive
     */
    public AccountExecutive(int id, String firstName, String lastName, String phoneNumber, String prospectingZone, String prospectingMunicipality, String photo, String superiorN1, String superiorN2, String superiorN3) {
        this.id = id;
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
  