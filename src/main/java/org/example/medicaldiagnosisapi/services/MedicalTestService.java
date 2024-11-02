package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.models.Appointment;
import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.example.medicaldiagnosisapi.models.MedicalTest;
import org.example.medicaldiagnosisapi.repositories.MedicalTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalTestService {
  private final MedicalTestRepository medicalTestRepository;

  @Autowired
  public MedicalTestService(MedicalTestRepository medicalTestRepository) {
    this.medicalTestRepository = medicalTestRepository;
  }

  //Only services
  public MedicalTest saveMedicalTestEntity(MedicalTest medicalTest){
    return medicalTestRepository.save(medicalTest);
  }

}
