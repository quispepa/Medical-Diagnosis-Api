package org.example.medicaldiagnosisapi.dtos;

import lombok.*;
import org.example.medicaldiagnosisapi.enums.AppointmentStatus;
import org.example.medicaldiagnosisapi.enums.AppointmentType;
import org.example.medicaldiagnosisapi.models.Doctor;
import org.example.medicaldiagnosisapi.models.Patient;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AppointmentResponse {
  private LocalDateTime appointmentDateAndTime;
  private AppointmentType appointmentType;
  private AppointmentStatus appointmentStatus;
  private Long patientId;
  private Long doctorId;
}
