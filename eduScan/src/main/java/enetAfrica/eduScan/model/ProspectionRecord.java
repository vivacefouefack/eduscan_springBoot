package enetAfrica.eduScan.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProspectionRecord extends InstitutInformation {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotEmpty private int seniority;
    @NotEmpty private LocalDate firstVisitDate;
    @NotBlank private String interlocutorFirstName;
    @NotBlank private String interlocutorLastName;
    @NotBlank private String interlocutorFunction;
}
