package enetAfrica.eduScan.dto;

import enetAfrica.eduScan.model.AccountExecutive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TokenDto {
    private Integer id;
    private String value;
    private boolean expire;
    private AccountExecutive user;
}
