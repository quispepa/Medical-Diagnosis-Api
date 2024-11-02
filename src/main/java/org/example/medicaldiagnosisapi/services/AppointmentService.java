package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.AppointmentResponse;
import org.example.medicaldiagnosisapi.dtos.CreateAppointmentRequest;
import org.example.medicaldiagnosisapi.dtos.UpdateAppointmentDateAndTimeRequest;
import org.example.medicaldiagnosisapi.enums.AppointmentStatus;
import org.example.medicaldiagnosisapi.mappers.AppoinmentMapper;
import org.example.medicaldiagnosisapi.models.Appointment;
import org.example.medicaldiagnosisapi.models.Doctor;
import org.example.medicaldiagnosisapi.models.Patient;
import org.example.medicaldiagnosisapi.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final DoctorService doctorService;
  private final PatientService patientService;
  private final AppoinmentMapper appoinmentMapper;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, AppoinmentMapper appoinmentMapper, DoctorService doctorService, PatientService patientService) {
    this.appointmentRepository = appointmentRepository;
    this.appoinmentMapper = appoinmentMapper;
    this.doctorService = doctorService;
    this.patientService = patientService;
  }

  public Optional<AppointmentResponse> getAppointment(Long id) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
    return appointmentOptional.map(appoinmentMapper::getAppointmentResponseFromAppointment);
  }

  public List<AppointmentResponse> getAllAppointments() {
    return appoinmentMapper.getAppointmentResponseListFromAppointmentList(appointmentRepository.findAll());
  }

  public Optional<AppointmentResponse> createAppointment(CreateAppointmentRequest createAppointmentResquest) {
    Appointment newAppointment = appoinmentMapper.getAppointmentFromCreateAppointmentRequest(createAppointmentResquest);
    Patient patientFound = patientService.getPatientEntity(createAppointmentResquest.getPatientId()).orElse(null);
    Doctor doctorFound = doctorService.getDoctorEntity(createAppointmentResquest.getDoctorId()).orElse(null);
    if (patientFound == null || doctorFound == null) {
      return Optional.empty();
    } else {
      newAppointment.setPatient(patientFound);
      newAppointment.setDoctor(doctorFound);
      return Optional.of(appoinmentMapper.getAppointmentResponseFromAppointment(appointmentRepository.save(newAppointment)));
    }
  }

  public Optional<AppointmentResponse> updateAppointmentDateAndTime(Long id, UpdateAppointmentDateAndTimeRequest updateAppointmentDateAndTimeRequest) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
    return appointmentOptional.map(appointment -> {
      appointment.setAppointmentDateAndTime(updateAppointmentDateAndTimeRequest.getAppointmentDateAndTime());
      appointment.setAppointmentStatus(AppointmentStatus.RESCHEDULED);
      return appoinmentMapper.getAppointmentResponseFromAppointment(appointmentRepository.save(appointment));
    });
  }

}
