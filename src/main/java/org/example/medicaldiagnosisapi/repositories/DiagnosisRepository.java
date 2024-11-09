package org.example.medicaldiagnosisapi.repositories;

import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.example.medicaldiagnosisapi.models.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

  List<Diagnosis> findAllByMedicalRecord(MedicalRecord medicalRecord);
}
