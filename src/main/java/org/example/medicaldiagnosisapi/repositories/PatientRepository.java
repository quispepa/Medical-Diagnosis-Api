package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
