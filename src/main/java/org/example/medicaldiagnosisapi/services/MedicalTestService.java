package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.requests.UpdateResultMedicalTestRequest;
import org.example.medicaldiagnosisapi.dtos.responses.MedicalTestResponse;
import org.example.medicaldiagnosisapi.enums.MedicalTestStatus;
import org.example.medicaldiagnosisapi.mappers.MedicalTestMapper;
import org.example.medicaldiagnosisapi.models.MedicalTest;
import org.example.medicaldiagnosisapi.repositories.MedicalTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalTestService {
  private final MedicalTestRepository medicalTestRepository;
  private final MedicalTestMapper medicalTestMapper;

  @Autowired
  public MedicalTestService(MedicalTestRepository medicalTestRepository, MedicalTestMapper medicalTestMapper) {
    this.medicalTestRepository = medicalTestRepository;
    this.medicalTestMapper = medicalTestMapper;
  }

  //Only services
  public MedicalTest saveMedicalTestEntity(MedicalTest medicalTest) {
    return medicalTestRepository.save(medicalTest);
  }

  public Optional<MedicalTestResponse> getResultMedicalTest(Long id) {
    Optional<MedicalTest> optionalMedicalTest = medicalTestRepository.findById(id);
    return optionalMedicalTest.map(medicalTest -> {
      if (medicalTest.getMedicalTestStatus().equals(MedicalTestStatus.RESULT_AVAILABLE))
        return medicalTestMapper.getMedicalTestResponseFromMedicalTest(medicalTest);
      return null;
    });
  }

  public Optional<MedicalTestResponse> updateResultMedicalTest(Long id, UpdateResultMedicalTestRequest updateResultMedicalTest) {
    Optional<MedicalTest> optionalMedicalTest = medicalTestRepository.findById(id);
    return optionalMedicalTest.map(medicalTest -> {
      medicalTest.setResult(updateResultMedicalTest.getResult());
      medicalTest.setMedicalTestStatus(MedicalTestStatus.RESULT_AVAILABLE);
      return medicalTestRepository.save(medicalTest);
    }).map(medicalTestMapper::getMedicalTestResponseFromMedicalTest);
  }
}
