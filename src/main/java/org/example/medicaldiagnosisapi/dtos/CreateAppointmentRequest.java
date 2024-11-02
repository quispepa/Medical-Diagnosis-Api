package org.example.medicaldiagnosisapi.dtos;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateMedicalTestAppointmentRequest {
  @NotNull
  @FutureOrPresent
  private LocalDateTime appointmentDateAndTime;
  @NotNull
  private AppointmentType appointmentType;
  @NotNull
  private AppointmentStatus appointmentStatus;
  @NotNull
  private Long patientId;
  @NotNull
  private Long doctorId;

  /**
   * Result of medicalTest
   */
  private String result;
  @NotNull
  private MedicalTestType medicalTestType;
  @NotNull
  private MedicalTestStatus medicalTestStatus;

}
