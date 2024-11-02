package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
