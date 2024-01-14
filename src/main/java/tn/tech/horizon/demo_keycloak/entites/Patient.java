package tn.tech.horizon.demo_keycloak.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private String dateNaissance;
    private String adresse;
    private String sexe;

    @OneToOne()
    @JoinColumn(name = "idDossierMedical")
//    @OneToOne(mappedBy = "patient")
//    @JsonIgnore
    private DossierMedical dossierMedical;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<RendezVous> rendezVous;
}
