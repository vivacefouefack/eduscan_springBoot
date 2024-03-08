package enetAfrica.eduScan.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JwToken {

    @Id
    @GeneratedValue
    private Integer id;
    private String value;
    private boolean expire;

    @ManyToOne(cascade = CascadeType.DETACH)
    private AccountExecutive user;
}
