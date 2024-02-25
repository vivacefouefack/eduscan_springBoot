package enetAfrica.eduScan.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendaDto {
    private Integer id;
    @NotNull private LocalDate visitDate;
    @Positive @NotEmpty private int accountExecutive;
    @Positive @NotEmpty private int institution;
}
