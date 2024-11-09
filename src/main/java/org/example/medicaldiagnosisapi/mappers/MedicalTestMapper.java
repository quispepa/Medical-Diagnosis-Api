package org.example.medicaldiagnosisapi.mappers;

import jakarta.annotation.PostConstruct;
import org.example.medicaldiagnosisapi.dtos.requests.CreateAppointmentRequest;
import org.example.medicaldiagnosisapi.dtos.responses.MedicalTestResponse;
import org.example.medicaldiagnosisapi.models.MedicalTest;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicalTestMapper {
  private final ModelMapper modelMapper;

  @Autowired
  public MedicalTestMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public MedicalTest getMedicalTestFromCreateAppointmentRequest(CreateAppointmentRequest createAppointmentRequest){
    return modelMapper.map(createAppointmentRequest, MedicalTest.class);
  }
  public MedicalTestResponse getMedicalTestResponseFromMedicalTest(MedicalTest medicalTest){
    return modelMapper.map(medicalTest, MedicalTestResponse.class);
  }

  @PostConstruct
  public void setupMappings(){
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    modelMapper.typeMap(CreateAppointmentRequest.class, MedicalTest.class)
            .addMappings(mapper ->{
              mapper.map(CreateAppointmentRequest::getMedicalTestType, MedicalTest::setMedicalTestType);
            });
  }
}
