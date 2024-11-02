package org.example.medicaldiagnosisapi.mappers;

import jakarta.annotation.PostConstruct;
import org.example.medicaldiagnosisapi.dtos.AppointmentResponse;
import org.example.medicaldiagnosisapi.dtos.CreateAppointmentRequest;
import org.example.medicaldiagnosisapi.models.Appointment;
import org.example.medicaldiagnosisapi.models.Patient;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppoinmentMapper {

  @Autowired
  private ModelMapper modelMapper;

  public AppointmentResponse getAppointmentResponseFromAppointment(Appointment appointment){
    return modelMapper.map(appointment,AppointmentResponse.class);
  }

  public List<AppointmentResponse> getAppointmentResponseListFromAppointmentList(List<Appointment> appointmentList){
    return appointmentList.stream().map(this::getAppointmentResponseFromAppointment).collect(Collectors.toList());
  }

  public Appointment getAppointmentFromCreateAppointmentRequest(CreateAppointmentRequest createAppointmentRequest){
    return modelMapper.map(createAppointmentRequest, Appointment.class);
  }
//  public AppointmentResponse getAppointmentResponseFromCreateAppointmentRequest(CreateAppointmentRequest createAppointmentRequest){
//  }

  @PostConstruct
  public void setupMappings() {
    modelMapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT);

    modelMapper.typeMap(Appointment.class, AppointmentResponse.class)
            .addMappings(mapper -> {
              mapper.map(src -> src.getPatient().getPatientId(), AppointmentResponse::setPatientId);
              mapper.map(src -> src.getDoctor().getDoctorId(), AppointmentResponse::setDoctorId);
            });
    modelMapper.typeMap(CreateAppointmentRequest.class, Appointment.class)
            .addMappings(mapper -> {
              mapper.map(CreateAppointmentRequest::getAppointmentDateAndTime, Appointment::setAppointmentDateAndTime);
              mapper.map(CreateAppointmentRequest::getAppointmentType, Appointment::setAppointmentType);
              mapper.map(CreateAppointmentRequest::getAppointmentStatus, Appointment::setAppointmentStatus);
            });
  }
}
