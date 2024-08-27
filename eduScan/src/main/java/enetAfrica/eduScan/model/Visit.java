package enetAfrica.eduScan.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a visit record associated with an account executive and an institution profile.
*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visit {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean supValidation;
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name="accountExecutive_id", nullable=false)
    private AccountExecutive accountExecutive;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable=true)
    private InstitutionProfile institutionProfile;

}
