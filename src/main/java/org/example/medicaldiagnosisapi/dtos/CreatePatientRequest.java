package org.example.medicaldiagnosisapi.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.PatientBiologicalSex;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePatientRequest {
  @NotBlank
  private String patientName;
  @NotNull
  private LocalDate patientDayOfBirth;
  @NotNull
  private PatientBiologicalSex patientBiologicalSex;
}
