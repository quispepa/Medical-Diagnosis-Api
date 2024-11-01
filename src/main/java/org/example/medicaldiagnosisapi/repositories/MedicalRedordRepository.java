package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRedordRepository extends JpaRepository<MedicalRecord, Long> {
}
