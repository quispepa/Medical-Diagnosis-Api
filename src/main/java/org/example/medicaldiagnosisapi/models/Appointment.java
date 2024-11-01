package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.AppointmentStatus;
import org.example.medicaldiagnosisapi.enums.AppointmentType;

import java.time.LocalDateTime;

@Table(name = "appointments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Appointment {
  @Id
  @Column(name = "appointment_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long appointmentId;
  @Column(name = "appointment_date_and_time")
  private LocalDateTime appointmentDateAndTime;
  @Column(name = "appointment_type")
  @Enumerated(value = EnumType.STRING)
  private AppointmentType appointmentType;
  @Column(name = "appointment_status")
  @Enumerated(value = EnumType.STRING)
  private AppointmentStatus appointmentStatus;

  @ManyToOne
  @JoinColumn(name = "patient_id", nullable = false)
  @JsonBackReference
  private Patient patient;
  @ManyToOne
  @JoinColumn(name = "doctor_id", nullable = false)
  @JsonBackReference
  private Doctor doctor;

  @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
  private Diagnosis diagnosis;
  @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
  private MedicalTest medicalTest;


  public Appointment(LocalDateTime appointmentDateAndTime, AppointmentType appointmentType, AppointmentStatus appointmentStatus, Patient patient, Doctor doctor) {
    this.appointmentDateAndTime = appointmentDateAndTime;
    this.appointmentType = appointmentType;
    this.appointmentStatus = appointmentStatus;
    this.patient = patient;
    this.doctor = doctor;
  }
}
