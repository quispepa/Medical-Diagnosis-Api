package org.example.medicaldiagnosisapi.services;

import org.example.medicaldiagnosisapi.dtos.AppointmentResponse;
import org.example.medicaldiagnosisapi.dtos.CreateAppointmentRequest;
import org.example.medicaldiagnosisapi.dtos.UpdateAppointmentDateAndTimeRequest;
import org.example.medicaldiagnosisapi.enums.AppointmentStatus;
import org.example.medicaldiagnosisapi.enums.AppointmentType;
import org.example.medicaldiagnosisapi.enums.MedicalTestStatus;
import org.example.medicaldiagnosisapi.mappers.AppoinmentMapper;
import org.example.medicaldiagnosisapi.mappers.MedicalTestMapper;
import org.example.medicaldiagnosisapi.models.*;
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
  private final DiagnosisService diagnosisService;
  private final MedicalRecordService medicalRecordService;
  private final MedicalTestMapper medicalTestMapper;
  private final MedicalTestService medicalTestService;

  @Autowired
  public AppointmentService(AppointmentRepository appointmentRepository, AppoinmentMapper appoinmentMapper, DoctorService doctorService, PatientService patientService, DiagnosisService diagnosisService, MedicalRecordService medicalRecordService, MedicalTestMapper medicalTestMapper, MedicalTestService medicalTestService) {
    this.appointmentRepository = appointmentRepository;
    this.appoinmentMapper = appoinmentMapper;
    this.doctorService = doctorService;
    this.patientService = patientService;
    this.diagnosisService = diagnosisService;
    this.medicalRecordService = medicalRecordService;
    this.medicalTestMapper = medicalTestMapper;
    this.medicalTestService = medicalTestService;
  }

  public Optional<AppointmentResponse> getAppointment(Long id) {
    Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
    return appointmentOptional.map(appoinmentMapper::getAppointmentResponseFromAppointment);
  }

  public List<AppointmentResponse> getAllAppointments() {
    return appoinmentMapper.getAppointmentResponseListFromAppointmentList(appointmentRepository.findAll());
  }

  public Optional<AppointmentResponse> createAppointment(CreateAppointmentRequest createAppointmentRequest) {
    Appointment newAppointment = appoinmentMapper.getAppointmentFromCreateAppointmentRequest(createAppointmentRequest);
    Patient patientFound = patientService.getPatientEntity(createAppointmentRequest.getPatientId()).orElse(null);
    Doctor doctorFound = doctorService.getDoctorEntity(createAppointmentRequest.getDoctorId()).orElse(null);
    if (patientFound == null || doctorFound == null) {
      return Optional.empty();
    } else {
      newAppointment.setPatient(patientFound);
      newAppointment.setDoctor(doctorFound);
      newAppointment = appointmentRepository.save(newAppointment);
      if (newAppointment.getAppointmentType().equals(AppointmentType.WITH_DOCTOR)){
        Optional<Diagnosis> newDiagnosis = getNewDiagnosis(newAppointment);
        if (newDiagnosis.isEmpty()) return Optional.empty();//Not found
      } else if (newAppointment.getAppointmentType().equals(AppointmentType.TO_MEDICAL_TEST)) {
        if (createAppointmentRequest.getMedicalTestType() == null) return Optional.empty(); //Not found
        Diagnosis newDiagnosis = getNewDiagnosis(newAppointment).orElse(null);
        if (newDiagnosis == null) return Optional.empty();//Not found
        newMedicalTest(newDiagnosis, newAppointment, createAppointmentRequest);
      }else {
        return Optional.empty();//Not found
      }
      return Optional.of(appoinmentMapper.getAppointmentResponseFromAppointment(newAppointment));
    }
  }


  public Optional<Diagnosis> getNewDiagnosis(Appointment newAppointment){
    Diagnosis newDiagnosis = newAppointment.getAppointmentType().equals(AppointmentType.WITH_DOCTOR) ?
            diagnosisService.getNewDiagnosisOfNewDoctorAppointment() :
            diagnosisService.getNewDiagnosisOfNewMedicalTestAppointment();
    newDiagnosis.setAppointment(newAppointment);
    MedicalRecord medicalRecordFounded = medicalRecordService.getMedicalRecordEntityById(newAppointment.getPatient().getPatientId()).orElse(null);
    if (medicalRecordFounded == null) return Optional.empty(); //Not found
    newDiagnosis.setMedicalRecord(medicalRecordFounded);
    return Optional.of(diagnosisService.saveDiagnosisEntity(newDiagnosis));
  }

  public void newMedicalTest(Diagnosis newDiagnosis, Appointment newAppointment, CreateAppointmentRequest createAppointmentRequest) {
    MedicalTest newMedicalTest = medicalTestMapper.getMedicalTestFromCreateAppointmentRequest(createAppointmentRequest);
    newMedicalTest.setMedicalTestStatus(MedicalTestStatus.SCHEDULED);
    newMedicalTest.setAppointment(newAppointment);
    newMedicalTest.setDiagnosis(newDiagnosis);
    medicalTestService.saveMedicalTestEntity(newMedicalTest);
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
