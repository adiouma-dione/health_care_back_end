package tn.tech.horizon.health_care.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "traitements")
public class Traitement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTraitement;
    private String nomMedicament;
    private String dosage;
    private String unite;
    private String frequence;
    private String dateDebut;
    private String dateFin;

    @ManyToOne @JoinColumn(name = "idDossierMedical")
    private DossierMedical dossierMedical;
}
