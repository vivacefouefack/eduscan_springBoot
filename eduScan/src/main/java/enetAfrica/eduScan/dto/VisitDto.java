package enetAfrica.eduScan.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {
    private boolean supValidation;
    @NotNull private LocalDate visitDate;
    @NotNull private int accountExecutive;
    @NotNull private int prospectingRecord;
}
