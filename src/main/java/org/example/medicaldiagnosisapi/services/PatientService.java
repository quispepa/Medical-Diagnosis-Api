package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.requests.CreatePatientRequest;
import org.example.medicaldiagnosisapi.dtos.responses.PatientResponse;
import org.example.medicaldiagnosisapi.dtos.requests.UpdatePatientNameRequest;
import org.example.medicaldiagnosisapi.dtos.requests.UpdatePatientRequest;
import org.example.medicaldiagnosisapi.mappers.PatientMapper;
import org.example.medicaldiagnosisapi.models.MedicalRecord;
import org.example.medicaldiagnosisapi.models.Patient;
import org.example.medicaldiagnosisapi.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
  private final PatientMapper patientMapper;
  private final PatientRepository patientRepository;
  private final MedicalRecordService medicalRecordService;

  public PatientService(PatientMapper patientMapper, PatientRepository patientRepository, MedicalRecordService medicalRecordService) {
    this.patientMapper = patientMapper;
    this.patientRepository = patientRepository;
    this.medicalRecordService = medicalRecordService;
  }

  /**
   * Method that returns original entity, only use between services.
   *
   * @param id patientId to search in repository
   * @return Optional<Patient> An optional that can content entity object
   */
  public Optional<Patient> getPatientEntity(Long id) {
    return patientRepository.findById(id);
  }

  public List<PatientResponse> getAllPaitents() {
    return patientMapper.getPatientResponseListFromPatientList(patientRepository.findAll());
  }

  public Optional<PatientResponse> getPatient(Long id){
    Optional<Patient> patientOptional=patientRepository.findById(id);
    return patientOptional.map(patientMapper::getPatientResponseFromPatient);
  }

  public Optional<PatientResponse> createPatient(CreatePatientRequest createPatientRequest){
    Patient newPatient = patientMapper.getPatientFromCreatePatientRequest(createPatientRequest);
    MedicalRecord medicalRecord = medicalRecordService.getNewMedicalRecordEntityOfNewPatient(newPatient);
    newPatient.setMedicalRecord(medicalRecord);
    newPatient = patientRepository.save(newPatient);
    return Optional.of(patientMapper.getPatientResponseFromPatient(newPatient));
  }

  /**
   * Method to update one Patient
   * If patientId is incorrect, returns an empty Optional
   * If values are null, returns an empty Optional.
   * If some value is different to null, returns an Optional that contains the PatientResponse with the changes. Null variables will not change.
   * @param id patientId to get Patient entity from repository
   * @param updatePatientRequest request that contains the params wants to update on the patient
   * @return an empty Optional or Optional that contains the PatientResponse updated
   */
  public Optional<PatientResponse> updatePatient(Long id, UpdatePatientRequest updatePatientRequest) {
    return patientRepository.findById(id).map(patientFound -> {
      if (updatePatientRequest.getPatientBiologicalSex() == null && updatePatientRequest.getPatientDayOfBirth() == null) return null;
      if (updatePatientRequest.getPatientDayOfBirth() != null) patientFound.setPatientDayOfBirth(updatePatientRequest.getPatientDayOfBirth());
      if (updatePatientRequest.getPatientBiologicalSex() != null) patientFound.setPatientBiologicalSex(updatePatientRequest.getPatientBiologicalSex());
      return patientMapper.getPatientResponseFromPatient(patientRepository.save(patientFound));
    });
  }

  /**
   * Only use admin.
   * Returns an Optional that contains Patient entity with name updated
   * @param id patientId to get object from repository
   * @param updatePatientName request that contains the name to update.
   * @return an Optional empty if patientId is incorrect or Optional that contains PatientResponse
   */
  public Optional<PatientResponse> updatePatientName(Long id, UpdatePatientNameRequest updatePatientName){
    return patientRepository.findById(id).map(patient -> {
      patient.setPatientName(updatePatientName.getPatientName());
      return patientMapper.getPatientResponseFromPatient(patientRepository.save(patient));
    });
  }
}
