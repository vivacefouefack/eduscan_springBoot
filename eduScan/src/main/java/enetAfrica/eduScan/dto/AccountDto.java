package enetAfrica.eduScan.dto;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String phoneNumber;
    @NonNull private String prospectingZone;
    @NonNull private String prospectingMunicipality;
    @NonNull private String photo;
    private int role;
    private int superiorN1;
    private int superiorN2;
    private int superiorN3;
}
