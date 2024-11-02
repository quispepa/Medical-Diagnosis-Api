package org.example.medicaldiagnosisapi.dtos;


import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.AppointmentStatus;
import org.example.medicaldiagnosisapi.enums.AppointmentType;

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
}
