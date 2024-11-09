package org.example.medicaldiagnosisapi.mappers;

import org.example.medicaldiagnosisapi.dtos.responses.DiagnosisResponse;
import org.example.medicaldiagnosisapi.models.Diagnosis;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiagnosisMapper {

  private final ModelMapper modelMapper;

  @Autowired
  public DiagnosisMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public DiagnosisResponse getDiagnosisResponseFromDiagnosis(Diagnosis diagnosis) {
    return modelMapper.map(diagnosis, DiagnosisResponse.class);
  }

  public List<DiagnosisResponse> getDiagnosisResponseListFromDiagnosisList(List<Diagnosis> diagnosisList){
    return diagnosisList.stream().map(this::getDiagnosisResponseFromDiagnosis).collect(Collectors.toList());
  }

}
