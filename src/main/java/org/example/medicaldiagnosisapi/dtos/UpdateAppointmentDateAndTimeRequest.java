package org.example.medicaldiagnosisapi.dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateAppointmentDateAndTimeRequest {
  @NotNull
  @FutureOrPresent
  private LocalDateTime appointmentDateAndTime;
}
