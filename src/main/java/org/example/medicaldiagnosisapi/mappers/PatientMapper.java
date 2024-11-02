package org.example.medicaldiagnosisapi.mappers;

import org.example.medicaldiagnosisapi.dtos.PatientResponse;
import org.example.medicaldiagnosisapi.models.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {
  private final ModelMapper modelMapper;

  @Autowired
  public PatientMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
  public Patient getPatientFromPatientResponse(PatientResponse patientResponse){
    return modelMapper.map(patientResponse, Patient.class);
  }

  public PatientResponse getPatientResponseFromPatient(Patient patient){
    return modelMapper.map(patient, PatientResponse.class);
  }
}
