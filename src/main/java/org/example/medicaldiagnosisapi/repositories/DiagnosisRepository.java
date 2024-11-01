package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
}
