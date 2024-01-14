package tn.tech.horizon.demo_keycloak;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.tech.horizon.demo_keycloak.entites.DossierMedical;
import tn.tech.horizon.demo_keycloak.entites.Patient;
import tn.tech.horizon.demo_keycloak.entites.Secretaire;
import tn.tech.horizon.demo_keycloak.repositories.PatientRepository;
import tn.tech.horizon.demo_keycloak.repositories.SecretaireRepository;
import tn.tech.horizon.demo_keycloak.services.DossierMedicalService;
import tn.tech.horizon.demo_keycloak.services.SecretaireService;
import tn.tech.horizon.demo_keycloak.services.impl.DossierMedicalServiceImpl;
import tn.tech.horizon.demo_keycloak.services.impl.PatientServiceImpl;
import tn.tech.horizon.demo_keycloak.services.impl.SecretaireServiceImpl;

@SpringBootApplication
@AllArgsConstructor
public class DemoKeycloakApplication {
    private SecretaireServiceImpl secretaireService;
    private DossierMedicalServiceImpl dossierMedicalService;
    private PatientServiceImpl patientService;
//('Residence Ibn Khaldoun', '21-10-2001', 'patient@email.com', 'nomPatient1', 'prenomPatient1', 'M', '00 000 000');

    public static void main(String[] args) {
        SpringApplication.run(DemoKeycloakApplication.class, args);
    }

    @Bean
//    @Override
    public CommandLineRunner run() {
        return (args) -> {
//            dossierMedicalService.ajouter(new DossierMedical(null, "23-10-2010", patientService.voir(1L), null, secretaireService.voir(1L), null, null, null));
//            secretaireService.ajouter(new Secretaire(null, "prenomSecretaire1", "nomSeretaire1", "secretaire1@email.com", "00 000 000", null));
//            secretaireService.ajouter(new Secretaire(null, "prenomSecretaire2", "nomSeretaire2", "secretaire2@email.com", "00 000 000", null));
//            secretaireService.ajouter(new Secretaire(null, "prenomSecretaire3", "nomSeretaire3", "secretaire3@email.com", "00 000 000", null));
//            employeeRepository.save(new Employee(null, "Employee 3", 1200.0));
        };

    }
}
