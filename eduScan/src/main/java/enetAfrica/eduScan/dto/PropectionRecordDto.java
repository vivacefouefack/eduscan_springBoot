package enetAfrica.eduScan.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.multipart.MultipartFile;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PropectionRecordDto {
    private Integer id;
    @NotBlank(message = "Le nom de l'école ne peut pas être vide")
    private String schoolName;

    @NotBlank(message = "La municipalité ne peut pas être vide")
    private String municipality;

    @NotBlank(message = "Le district ne peut pas être vide")
    private String district;

    @NotBlank(message = "L'adresse géographique ne peut pas être vide")
    private String geographicAddress;

    @NotBlank(message = "Le type d'école ne peut pas être vide")
    private String schoolType;

    @NotBlank(message = "Le type d'enseignement ne peut pas être vide")
    private String teachingType;

    @NotBlank(message = "Le niveau d'enseignement ne peut pas être vide")
    private String teachingLevel;

    @Positive(message = "Le nombre d'inscriptions doit être positif")
    private int enrollment;

    @NotBlank(message = "Le numéro de téléphone de contact ne peut pas être vide")
    private String contactPhone;

    @Email(message = "L'adresse email doit être valide")
    private String email;

    private boolean hasComputer;

    @Positive(message = "Le nombre total d'ordinateurs doit être positif")
    private int totalComputers;

    //@NotBlank(message = "La photo de l'école ne peut pas être vide")
    @Nullable
    private MultipartFile schoolPhoto;

    @PositiveOrZero(message = "L'ancienneté doit être un nombre positif ou zéro")
    private int seniority;

    @Past(message = "La date de première visite doit être dans le passé")
    private LocalDate firstVisitDate;

    @NotBlank(message = "Le prénom de l'interlocuteur ne doit pas être vide")
    private String interlocutorFirstName;

    @NotBlank(message = "Le nom de l'interlocuteur ne doit pas être vide")
    private String interlocutorLastName;

    @NotBlank(message = "La fonction de l'interlocuteur ne doit pas être vide")
    private String interlocutorFunction;

    private boolean hasInternet;

    private String connectionType;

    private String routerType;

    private String telecomOperator;

    private boolean hasComputerRoom;

    private boolean hasElectricity;

    private boolean hasManagementSoftware;

    private String softwareName;

    private LocalTime visitTime;

    private LocalTime endTime;

}
