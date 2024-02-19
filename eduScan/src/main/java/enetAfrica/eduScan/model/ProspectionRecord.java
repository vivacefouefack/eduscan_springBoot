package enetAfrica.eduScan.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProspectionRecord extends InstitutInformation {
    @Id
    @GeneratedValue
    private int id;
    private int seniority;
    @NonNull private LocalDate firstVisitDate;
    @NonNull private String interlocutorFirstName;
    @NonNull private String interlocutorLastName;
    @NonNull private String interlocutorFunction;
}
