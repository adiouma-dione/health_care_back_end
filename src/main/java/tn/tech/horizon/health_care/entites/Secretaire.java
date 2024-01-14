package tn.tech.horizon.health_care.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "secretaires")
public class Secretaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSecretaire;
    private String prenom;
    private String nom;
    private String email;
    private String telephone;

    @OneToOne()
    @JoinColumn(name = "idDossierMedical")
//    @OneToOne(mappedBy = "secretaire")
    private DossierMedical dossierMedical;
}
