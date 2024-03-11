package enetAfrica.eduScan.dto;

import enetAfrica.eduScan.model.AccountExecutive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    private AccountExecutive user;
    private String token;
}
