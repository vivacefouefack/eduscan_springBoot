package enetAfrica.eduScan.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Integer id; 
    private String password;
    private boolean actif;
    
    @Email(message = "L'adresse email doit être valide")
    private String username;
    
    @NotBlank(message = "Le prénom ne peut pas être vide")
    private String firstName; 

    @NotBlank(message = "Le nom ne peut pas être vide")
    private String lastName;

    @Size(min = 10, max = 14, message = "Le numéro de téléphone doit être entre 10 et 14 caractères")
    private String phoneNumber;

    @NotBlank(message = "La zone de prospection ne peut pas être vide")
    private String prospectingZone;

    @NotBlank(message = "La municipalité de prospection ne peut pas être vide")                                             
    private String prospectingMunicipality;

    //@NotBlank(message = "La photo ne peut pas être vide") 
    private String photo;

    //@NotNull(message = "Le rôle ne peut pas être négatif")
    private String function;

    //@Positive(message = "Le supérieur N1 ne peut pas être négatif")
    private String superiorN1;

    //@NotNull(message = "Le supérieur N2 ne peut pas être négatif")
    private String superiorN2;

    //@NotNull(message = "Le supérieur N3 ne peut pas être négatif")
    private String superiorN3;
}
