package org.example.medicaldiagnosisapi;

import org.example.medicaldiagnosisapi.enums.*;
import org.example.medicaldiagnosisapi.models.*;
import org.example.medicaldiagnosisapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
  @Autowired
  PatientRepository patientRepository;
  @Autowired
  MedicalRedordRepository medicalRecord;
  @Autowired
  private MedicalTestRepository medicalTestRepository;
  @Autowired
  private DoctorRepository doctorRepository;
  @Autowired
  private AppointmentRepository appointmentRepository;
  @Autowired
  private DiagnosisRepository diagnosisRepository;


  @Override
  public void run(String... args) throws Exception {
    initData();
  }

  public void initData() {

    Patient patient = new Patient("Antonio Quispe", LocalDate.of(2000, 7, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord = new MedicalRecord(patient);
    patient.setMedicalRecord(medicalRecord);
    Patient patient1 = new Patient("Lisa Sanchez", LocalDate.of(1999, 3, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord1 = new MedicalRecord(patient1);
    patient.setMedicalRecord(medicalRecord1);
    Patient patient2 = new Patient("Haroldo Gutierrez", LocalDate.of(1990, 4, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord2 = new MedicalRecord(patient2);
    patient.setMedicalRecord(medicalRecord2);
    Patient patient3 = new Patient("Williams Navas", LocalDate.of(1998, 2, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord3 = new MedicalRecord(patient3);
    patient.setMedicalRecord(medicalRecord3);
    Patient patient4 = new Patient("Ana Garcia", LocalDate.of(1985, 9, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord4 = new MedicalRecord(patient4);
    patient.setMedicalRecord(medicalRecord4);
    Patient patient5 = new Patient("Claudia Ruiz", LocalDate.of(1980, 8, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord5 = new MedicalRecord(patient5);
    patient.setMedicalRecord(medicalRecord5);
    Patient patient6 = new Patient("Maria Lopez", LocalDate.of(1985, 1, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord6 = new MedicalRecord(patient6);
    patient.setMedicalRecord(medicalRecord6);
    patientRepository.saveAll(Arrays.asList(patient1,patient2,patient3,patient4,patient5,patient6));

    Doctor doctor = new Doctor("Julia Sanchez", DoctorSpecialty.FAMILY_MEDICINE);
    Doctor doctor1 = new Doctor("Marcos Sueco", DoctorSpecialty.CARDIOLOGY);
    Doctor doctor2 = new Doctor("Jhon Doe", DoctorSpecialty.DERMATOLOGY);
    Doctor doctor3 = new Doctor("Mario Robles", DoctorSpecialty.NEUROSURGERY);
    Doctor doctor4 = new Doctor("Julian Parrilla", DoctorSpecialty.PEDIATRICS);
    Doctor doctor5 = new Doctor("Marta Sanchez", DoctorSpecialty.GERIATRICS);
    Doctor doctor6 = new Doctor("Alba Farelo", DoctorSpecialty.PSYCHIATRY);
    doctorRepository.saveAll(Arrays.asList(doctor, doctor1, doctor2, doctor3, doctor4, doctor5, doctor6));



    Appointment appointment = new Appointment(LocalDateTime.of(2024, 10, 1, 16, 40), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment1 = new Appointment(LocalDateTime.of(2020, 11, 15, 12, 10), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment2 = new Appointment(LocalDateTime.of(2020, 1, 10, 13, 25), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment3 = new Appointment(LocalDateTime.of(2024, 4, 1, 17, 30), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment4 = new Appointment(LocalDateTime.of(2023, 8, 25, 12, 45), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment5 = new Appointment(LocalDateTime.of(2024, 5, 18, 11, 15), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment6 = new Appointment(LocalDateTime.of(2023, 3, 19, 10, 20), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment7 = new Appointment(LocalDateTime.of(2023, 12, 11, 15, 30), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment8 = new Appointment(LocalDateTime.of(2022, 7, 8, 18, 35), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient, doctor);
    Appointment appointment9 = new Appointment(LocalDateTime.of(2023, 10, 23, 19, 55), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient, doctor);
    appointmentRepository.saveAll(Arrays.asList(appointment, appointment1,appointment2, appointment3, appointment4, appointment5, appointment6, appointment7, appointment8, appointment9));

    appointment = appointmentRepository.save(appointment);

    Diagnosis diagnosis = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis1 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis2 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis3 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis4 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis5 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis6 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis7 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);


    diagnosis.setMedicalRecord(medicalRecord);
    diagnosis.setAppointment(appointment);
    diagnosis = diagnosisRepository.save(diagnosis);


    MedicalTest medicalTest = new MedicalTest(null, MedicalTestType.BLOOD_TEST, MedicalTestStatus.SCHEDULED);
    medicalTest.setAppointment(appointment);
    medicalTest.setDiagnosis(diagnosis);
    medicalTest = medicalTestRepository.save(medicalTest);

    appointment.setMedicalTest(medicalTest);
    appointment.setDiagnosis(diagnosis);

    appointmentRepository.save(appointment);

  }
}
