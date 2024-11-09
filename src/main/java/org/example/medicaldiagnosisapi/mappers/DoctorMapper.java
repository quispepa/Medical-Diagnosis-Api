package org.example.medicaldiagnosisapi.mappers;

import org.example.medicaldiagnosisapi.dtos.requests.CreateDoctorRequest;
import org.example.medicaldiagnosisapi.dtos.responses.DoctorResponse;
import org.example.medicaldiagnosisapi.models.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
  private final ModelMapper modelMapper;

  @Autowired
  public DoctorMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public DoctorResponse getDoctorResponseFromDoctor(Doctor doctor) {
    return modelMapper.map(doctor, DoctorResponse.class);
  }

  public Doctor getDoctorFromCreateDoctorRequest(CreateDoctorRequest createDoctorRequest) {
    return modelMapper.map(createDoctorRequest, Doctor.class);
  }

  public Doctor getDoctorFromDoctorResponse(DoctorResponse doctorResponse){
    return modelMapper.map(doctorResponse,Doctor.class);
  }
}
