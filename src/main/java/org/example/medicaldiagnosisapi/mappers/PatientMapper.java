package org.example.medicaldiagnosisapi.mappers;

import org.example.medicaldiagnosisapi.dtos.CreatePatientRequest;
import org.example.medicaldiagnosisapi.dtos.PatientResponse;
import org.example.medicaldiagnosisapi.models.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientMapper {
  private final ModelMapper modelMapper;

  @Autowired
  public PatientMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
  public Patient getPatientFromCreatePatientRequest(CreatePatientRequest createPatientRequest){
    return modelMapper.map(createPatientRequest, Patient.class);
  }

  public PatientResponse getPatientResponseFromPatient(Patient patient){
    return modelMapper.map(patient, PatientResponse.class);
  }

  public List<PatientResponse> getPatientResponseListFromPatientList(List<Patient> patientList){
    return patientList.stream().map(this::getPatientResponseFromPatient).collect(Collectors.toList());
  }

}
