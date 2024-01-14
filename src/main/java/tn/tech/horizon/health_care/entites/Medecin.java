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
@Table(name = "medecins")
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedecin;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;
    private String specialite;


    @OneToOne()
    @JoinColumn(name = "idDossierMedical")
//    @OneToOne(mappedBy = "medecin")
    private DossierMedical dossierMedical;

    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<RendezVous> rendezVous;
}
