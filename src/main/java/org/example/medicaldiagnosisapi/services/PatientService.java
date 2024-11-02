package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.PatientResponse;
import org.example.medicaldiagnosisapi.mappers.DoctorMapper;
import org.example.medicaldiagnosisapi.mappers.PatientMapper;
import org.example.medicaldiagnosisapi.models.Patient;
import org.example.medicaldiagnosisapi.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PatientService {
  private final PatientMapper patientMapper;
  private final PatientRepository patientRepository;

  public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
    this.patientMapper = patientMapper;
    this.patientRepository = patientRepository;
  }

  /**
   * Method that returns original entity, only use to services.
   * @param id patientId to search in repository
   * @return Optional<Patient> An optional that can content entity object
   */
  public Optional<Patient> getPatient(Long id){
    return patientRepository.findById(id);
  }

}
