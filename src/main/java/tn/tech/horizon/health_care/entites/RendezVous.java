package tn.tech.horizon.health_care.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "rendez_vous")
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRendezVous;
    private String dateRendezVous;
    private String heureRendezVous;
    private String objet;
    private Boolean isConfirmed;

    @ManyToOne
    @JoinColumn(name = "idPatient")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "idMedecin")
    private Medecin medecin;
}

