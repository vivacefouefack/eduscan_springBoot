package enetAfrica.eduScan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionProfile extends InstitutInformation {
    @Id
    @GeneratedValue
    private int id;
}
