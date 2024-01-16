package tn.tech.horizon.health_care.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.tech.horizon.health_care.entites.FileData;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByIdOwner(Long idOwner);
}
