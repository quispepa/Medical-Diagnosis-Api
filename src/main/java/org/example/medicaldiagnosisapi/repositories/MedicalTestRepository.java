package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.MedicalTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalTestRepository extends JpaRepository<MedicalTest, Long> {
}
