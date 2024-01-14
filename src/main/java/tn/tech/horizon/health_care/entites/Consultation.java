package tn.tech.horizon.health_care.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;
    private String date;
    private String compteRendu;

    @ManyToOne @JoinColumn(name = "idDossierMedical")
    private DossierMedical dossierMedical;
}
