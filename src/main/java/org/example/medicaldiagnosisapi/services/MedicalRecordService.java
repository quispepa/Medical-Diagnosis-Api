package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.models.MedicalRecord;
import org.example.medicaldiagnosisapi.models.Patient;
import org.example.medicaldiagnosisapi.repositories.MedicalRedordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordService {
  private final MedicalRedordRepository medicalRedordRepository;

  @Autowired
  public MedicalRecordService(MedicalRedordRepository medicalRedordRepository) {
    this.medicalRedordRepository = medicalRedordRepository;
  }

  /**
   * Method only use between services
   * @param newPatient
   * @return
   */
  public MedicalRecord getNewMedicalRecordEntityOfNewPatient(Patient newPatient) {
    return new MedicalRecord(newPatient);
  }
}
