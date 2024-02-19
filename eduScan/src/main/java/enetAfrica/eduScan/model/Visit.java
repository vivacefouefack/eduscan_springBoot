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
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Visit {
    @Id
    @GeneratedValue
    private int id;
    private boolean supValidation;
    @NonNull private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name="accountExecutive_id", nullable=false)
    private AccountExecutive accountExecutive;

    @OneToOne
    @JoinColumn(name = "prospectingRecord_id", referencedColumnName = "id")
    private ProspectionRecord prospectingRecord;

}
