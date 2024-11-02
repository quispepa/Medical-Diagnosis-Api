package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;
import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.example.medicaldiagnosisapi.repositories.DiagnosisRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisService {
  private final ModelMapper modelMapper;
  private final DiagnosisRepository diagnosisRepository;

  @Autowired
  public DiagnosisService(ModelMapper modelMapper, DiagnosisRepository diagnosisRepository) {
    this.modelMapper = modelMapper;
    this.diagnosisRepository = diagnosisRepository;
  }

  //Only services
  public Diagnosis saveDiagnosisEntity(Diagnosis diagnosis){
    return diagnosisRepository.save(diagnosis);
  }
  //Only services
  public Diagnosis getNewDiagnosisOfNewDoctorAppointment(){
    return new Diagnosis(DiagnosisTreatmentStatus.PENDING_OF_APPOINTMENT);
  }
  //Only services
  public Diagnosis getNewDiagnosisOfNewMedicalTestAppointment(){
    return new Diagnosis(DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
  }
}
