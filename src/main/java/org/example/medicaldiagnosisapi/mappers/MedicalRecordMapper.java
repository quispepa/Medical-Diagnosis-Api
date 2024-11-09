package org.example.medicaldiagnosisapi.mappers;



import org.example.medicaldiagnosisapi.dtos.responses.MedicalRecordResponse;
import org.example.medicaldiagnosisapi.models.MedicalRecord;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MedicalRecordMapper {
  private final ModelMapper modelMapper;

  @Autowired
  public MedicalRecordMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public MedicalRecordResponse getMedicalRecordResponseFromMedicalRecord(MedicalRecord medicalRecord){
    return modelMapper.map(medicalRecord, MedicalRecordResponse.class);
  }


}
