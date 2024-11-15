package org.example.medicaldiagnosisapi.dtos.requests;


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
public class CreateAppointmentRequest {
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
  private MedicalTestType medicalTestType;


}
