package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.requests.UpdateDeseaseAndTreatmentDiagnosis;
import org.example.medicaldiagnosisapi.dtos.responses.DiagnosisResponse;
import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;
import org.example.medicaldiagnosisapi.mappers.DiagnosisMapper;
import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.example.medicaldiagnosisapi.models.MedicalRecord;
import org.example.medicaldiagnosisapi.repositories.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DiagnosisService {
  private final DiagnosisMapper diagnosisMapper;
  private final DiagnosisRepository diagnosisRepository;

  @Autowired
  public DiagnosisService(DiagnosisMapper diagnosisMapper, DiagnosisRepository diagnosisRepository) {
    this.diagnosisMapper = diagnosisMapper;
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

  public Optional<DiagnosisResponse> getDiagnosisById(Long id){
    Optional<Diagnosis> optionalDiagnosis = diagnosisRepository.findById(id);
    return optionalDiagnosis.map(diagnosisMapper::getDiagnosisResponseFromDiagnosis);
  }

  public List<DiagnosisResponse> getAllDiagnoses(){
    List<Diagnosis> diagnosisList = diagnosisRepository.findAll();
    return diagnosisMapper.getDiagnosisResponseListFromDiagnosisList(diagnosisList);
  }

  //Only services
  /**
   * Returns an Optional with a Diagnosis if exists someone that status is pending of results to not create new diagnosis.
   * @param medicalRecord Get diagnosis lists of this medicalRecord
   * @return an Optional with exists Diagnosis o empty if not.
   */
  public Optional<Diagnosis> pendingResultsDiagnosisExists(MedicalRecord medicalRecord){
    List<Diagnosis> diagnosisList = diagnosisRepository.findAllByMedicalRecord(medicalRecord);
    if (diagnosisList.isEmpty()) return Optional.empty();
    for (Diagnosis diagnosis: diagnosisList){
      if (diagnosis.getDiagnosisTreatmentStatus().equals(DiagnosisTreatmentStatus.PENDING_TEST_RESULTS)) return Optional.of(diagnosis);
    }
    return Optional.empty();
  }

  public Optional<DiagnosisResponse> updateDeseaseAndTreatmentDiagnosis(Long id,UpdateDeseaseAndTreatmentDiagnosis updateDeseaseAndTreatmentDiagnosis){
    if (updateDeseaseAndTreatmentDiagnosis.getDiagnosisIdentifiedDiseaseByDoctor() == null || updateDeseaseAndTreatmentDiagnosis.getTreatmentSuggestedByDoctor()==null) return Optional.empty();
    Optional<Diagnosis> optionalDiagnosis = diagnosisRepository.findById(id);
    return optionalDiagnosis.map(diagnosis -> {
      diagnosis.setDiagnosisIdentifiedDiseaseByDoctor(updateDeseaseAndTreatmentDiagnosis.getDiagnosisIdentifiedDiseaseByDoctor());
      diagnosis.setTreatmentSuggestedByDoctor(updateDeseaseAndTreatmentDiagnosis.getTreatmentSuggestedByDoctor());
      return diagnosisRepository.save(diagnosis);
    }).map(diagnosisMapper::getDiagnosisResponseFromDiagnosis);

  }

}
