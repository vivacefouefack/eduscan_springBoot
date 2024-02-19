package enetAfrica.eduScan.model;

import java.time.LocalTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NonNull;

@Data
@MappedSuperclass
public class InstitutInformation {
    private String schoolName;
    private String municipality;
    private String district;
    private String geographicAddress;
    private String schoolType;
    private String teachingType;
    private String teachingLevel;
    private int enrollment;
    private String contactPhone;
    private String email;
    private boolean hasComputer;
    private int totalComputers;
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
    private String schoolPhoto;
}
