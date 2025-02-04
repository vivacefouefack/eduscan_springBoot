package enetAfrica.eduScan.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an agenda entry in the system.
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Agenda {
    @Id
    @GeneratedValue
    private Integer id;
    
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name="accountExecutive_id", nullable=false)
    private AccountExecutive accountExecutive;

    @OneToOne
    @JoinColumn(name = "institution_id", referencedColumnName = "id")
    private InstitutionProfile institution;
}
