package tn.tech.horizon.health_care.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "factures")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;
    private String dateFacture;
    private String designation;
    private Double montant;

    @ManyToOne @JoinColumn(name = "idDossierMedical")
    private DossierMedical dossierMedical;
}
