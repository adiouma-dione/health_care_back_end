package tn.tech.horizon.demo_keycloak.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.tech.horizon.demo_keycloak.entites.RendezVous;

@Service
public interface RendezVousService {
    Page<RendezVous> getAllRendezVouss(String date, Pageable page);
    RendezVous addRendezVous(RendezVous rendezVous);
    RendezVous updateRendezVous(RendezVous rendezVous);
    RendezVous getRendezVous(Long id);
    void deleteRendezVous(Long id);
}
