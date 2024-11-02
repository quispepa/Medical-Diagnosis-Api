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
  //Only services
  public Optional<MedicalRecord> getMedicalRecordEntityById(Long id){
    return medicalRedordRepository.findById(id);
  }

  /**
   * Method only use between services.
   * Returns a MedicalRecord entity that's necessary to create new Patient, then this MedicalRecord will save by Patient repository of recursive way.
   * @param newPatient Patient entity that is necessary to create MedicalRecord cause ids are equals
   * @return A MedicalRecord entity to add on creation of new Patient.
   */
  public MedicalRecord getNewMedicalRecordEntityOfNewPatient(Patient newPatient) {
    return new MedicalRecord(newPatient);
  }
}
