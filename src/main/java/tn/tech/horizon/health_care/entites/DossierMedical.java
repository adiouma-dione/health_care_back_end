package tn.tech.horizon.health_care.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "dossiers_medicaux")
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDossierMedical;
    private String dateCreation;

    @OneToOne(mappedBy = "dossierMedical")
//    @OneToOne    @JoinColumn(name = "idPatient")
    @JsonIgnore
    private Patient patient;
    @OneToOne(mappedBy = "dossierMedical")
//    @OneToOne
//    @JoinColumn(name = "idMedecin")
    @JsonIgnore
    private Medecin medecin;
    @OneToOne(mappedBy = "dossierMedical")
//    @OneToOne
//    @JoinColumn(name = "idSecretaire")
    @JsonIgnore
    private Secretaire secretaire;

    @OneToMany(mappedBy = "dossierMedical")
    @JsonIgnore
    private List<Consultation> consultations;
    @OneToMany(mappedBy = "dossierMedical")
    @JsonIgnore
    private List<Facture> factures;
    @OneToMany(mappedBy = "dossierMedical")
    @JsonIgnore
    private List<Traitement> traitements;
}
