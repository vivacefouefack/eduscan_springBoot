package enetAfrica.eduScan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents a profile of an institution, extending the class to include additional details.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class InstitutionProfile extends InstitutInformation {
    @Id
    @GeneratedValue
    private Integer id;

    private double latitude;

    private double longitude;

    @ManyToOne
    @JoinColumn(name="accountExecutive_id", nullable=true)
    private AccountExecutive accountExecutive;

}
