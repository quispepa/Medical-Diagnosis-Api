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
  }

  /**
   * Way of add data persist related entities correctly
   */
  public void initData() {
    Patient patient = new Patient("Antonio Quispe", LocalDate.of(2000, 7, 30), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord = new MedicalRecord(patient);
    patient.setMedicalRecord(medicalRecord);
    Patient patient1 = new Patient("Lisa Sanchez", LocalDate.of(1999, 3, 12), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord1 = new MedicalRecord(patient1);
    patient1.setMedicalRecord(medicalRecord1);
    Patient patient2 = new Patient("Haroldo Gutierrez", LocalDate.of(1990, 4, 1), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord2 = new MedicalRecord(patient2);
    patient2.setMedicalRecord(medicalRecord2);
    Patient patient3 = new Patient("Williams Navas", LocalDate.of(1998, 2, 9), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord3 = new MedicalRecord(patient3);
    patient3.setMedicalRecord(medicalRecord3);
    Patient patient4 = new Patient("Ana Garcia", LocalDate.of(1985, 9, 21), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord4 = new MedicalRecord(patient4);
    patient4.setMedicalRecord(medicalRecord4);
    Patient patient5 = new Patient("Claudia Ruiz", LocalDate.of(1980, 8, 27), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord5 = new MedicalRecord(patient5);
    patient5.setMedicalRecord(medicalRecord5);
    Patient patient6 = new Patient("Maria Lopez", LocalDate.of(1985, 1, 16), PatientBiologicalSex.MALE);
    MedicalRecord medicalRecord6 = new MedicalRecord(patient6);
    patient6.setMedicalRecord(medicalRecord6);
    patientRepository.saveAll(Arrays.asList(patient,patient1, patient2, patient3, patient4, patient5, patient6));

    Doctor doctor = new Doctor("Julia Sanchez", DoctorSpecialty.FAMILY_MEDICINE);
    Doctor doctor1 = new Doctor("Marcos Sueco", DoctorSpecialty.CARDIOLOGY);
    Doctor doctor2 = new Doctor("Jhon Doe", DoctorSpecialty.DERMATOLOGY);
    Doctor doctor3 = new Doctor("Mario Robles", DoctorSpecialty.NEUROSURGERY);
    Doctor doctor4 = new Doctor("Julian Parrilla", DoctorSpecialty.PEDIATRICS);
    Doctor doctor5 = new Doctor("Marta Sanchez", DoctorSpecialty.GERIATRICS);
    Doctor doctor6 = new Doctor("Alba Farelo", DoctorSpecialty.PSYCHIATRY);
    doctorRepository.saveAll(Arrays.asList(doctor, doctor1, doctor2, doctor3, doctor4, doctor5, doctor6));

    Appointment appointment = new Appointment(LocalDateTime.of(2024, 10, 1, 16, 40), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient, doctor5);
    Appointment appointment1 = new Appointment(LocalDateTime.of(2020, 11, 15, 12, 10), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient2, doctor4);
    Appointment appointment2 = new Appointment(LocalDateTime.of(2020, 1, 10, 13, 25), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient3, doctor1);
    Appointment appointment3 = new Appointment(LocalDateTime.of(2024, 4, 1, 17, 30), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient2, doctor3);
    Appointment appointment4 = new Appointment(LocalDateTime.of(2023, 8, 25, 12, 45), AppointmentType.WITH_DOCTOR, AppointmentStatus.SCHEDULED, patient1, doctor3);
    Appointment appointment5 = new Appointment(LocalDateTime.of(2024, 5, 18, 11, 15), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient6, doctor2);
    Appointment appointment6 = new Appointment(LocalDateTime.of(2023, 3, 19, 10, 20), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient5, doctor);
    Appointment appointment7 = new Appointment(LocalDateTime.of(2023, 12, 11, 15, 30), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient4, doctor6);
    Appointment appointment8 = new Appointment(LocalDateTime.of(2022, 7, 8, 18, 35), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient5, doctor);
    Appointment appointment9 = new Appointment(LocalDateTime.of(2023, 10, 23, 19, 55), AppointmentType.TO_MEDICAL_TEST, AppointmentStatus.SCHEDULED, patient3, doctor4);
    appointmentRepository.saveAll(Arrays.asList(appointment, appointment1, appointment2, appointment3, appointment4, appointment5, appointment6, appointment7, appointment8, appointment9));

    Diagnosis diagnosis = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis1 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.COMPLETED);
    Diagnosis diagnosis2 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.WAITING_FOR_DOCTORS_APPROVAL);
    Diagnosis diagnosis3 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.COMPLETED);
    Diagnosis diagnosis4 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis5 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.COMPLETED);
    Diagnosis diagnosis6 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.WAITING_FOR_DOCTORS_APPROVAL);
    Diagnosis diagnosis7 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.COMPLETED);
    Diagnosis diagnosis8 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.PENDING_TEST_RESULTS);
    Diagnosis diagnosis9 = new Diagnosis(null, null, null, null, null, null, DiagnosisTreatmentStatus.COMPLETED);
    diagnosis.setMedicalRecord(medicalRecord);
    diagnosis1.setMedicalRecord(medicalRecord1);
    diagnosis2.setMedicalRecord(medicalRecord2);
    diagnosis3.setMedicalRecord(medicalRecord3);
    diagnosis4.setMedicalRecord(medicalRecord4);
    diagnosis5.setMedicalRecord(medicalRecord5);
    diagnosis6.setMedicalRecord(medicalRecord6);
    diagnosis7.setMedicalRecord(medicalRecord2);
    diagnosis8.setMedicalRecord(medicalRecord1);
    diagnosis9.setMedicalRecord(medicalRecord6);
    diagnosis.setAppointment(appointment);
    diagnosis1.setAppointment(appointment1);
    diagnosis2.setAppointment(appointment2);
    diagnosis3.setAppointment(appointment3);
    diagnosis4.setAppointment(appointment4);
    diagnosis5.setAppointment(appointment5);
    diagnosis6.setAppointment(appointment6);
    diagnosis7.setAppointment(appointment7);
    diagnosis8.setAppointment(appointment8);
    diagnosis9.setAppointment(appointment9);
    diagnosisRepository.saveAll(Arrays.asList(diagnosis, diagnosis1, diagnosis2, diagnosis3, diagnosis4, diagnosis5, diagnosis6, diagnosis7, diagnosis8, diagnosis9));

    MedicalTest medicalTest = new MedicalTest(null, MedicalTestType.BLOOD_TEST, MedicalTestStatus.SCHEDULED);
    MedicalTest medicalTest1 = new MedicalTest(null, MedicalTestType.URINE_TEST, MedicalTestStatus.RESULT_AVAILABLE);
    MedicalTest medicalTest2 = new MedicalTest(null, MedicalTestType.XRAY, MedicalTestStatus.UNDER_ANALYSIS);
    MedicalTest medicalTest3 = new MedicalTest(null, MedicalTestType.COLONOSCOPY, MedicalTestStatus.SCHEDULED);
    MedicalTest medicalTest4 = new MedicalTest(null, MedicalTestType.ULTRASOUND, MedicalTestStatus.UNDER_ANALYSIS);
    medicalTest.setAppointment(appointment5);
    medicalTest1.setAppointment(appointment6);
    medicalTest2.setAppointment(appointment7);
    medicalTest3.setAppointment(appointment8);
    medicalTest4.setAppointment(appointment9);
    medicalTest.setDiagnosis(diagnosis5);
    medicalTest1.setDiagnosis(diagnosis6);
    medicalTest2.setDiagnosis(diagnosis7);
    medicalTest3.setDiagnosis(diagnosis8);
    medicalTest4.setDiagnosis(diagnosis9);
    medicalTestRepository.saveAll(Arrays.asList(medicalTest, medicalTest1, medicalTest2, medicalTest3, medicalTest4));

    appointment5.setMedicalTest(medicalTest);
    appointment6.setMedicalTest(medicalTest);
    appointment7.setMedicalTest(medicalTest);
    appointment8.setMedicalTest(medicalTest);
    appointment9.setMedicalTest(medicalTest);
    appointment.setDiagnosis(diagnosis);
    appointment1.setDiagnosis(diagnosis1);
    appointment2.setDiagnosis(diagnosis2);
    appointment3.setDiagnosis(diagnosis3);
    appointment4.setDiagnosis(diagnosis4);
    appointment5.setDiagnosis(diagnosis5);
    appointment6.setDiagnosis(diagnosis6);
    appointment7.setDiagnosis(diagnosis7);
    appointment8.setDiagnosis(diagnosis8);
    appointment9.setDiagnosis(diagnosis9);
    appointmentRepository.saveAll(Arrays.asList(appointment,appointment1,appointment2,appointment3,appointment4,appointment5,appointment6,appointment7,appointment8,appointment9));

  }
}
