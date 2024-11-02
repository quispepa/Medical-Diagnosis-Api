package org.example.medicaldiagnosisapi.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePatientNameRequest {
  @NotBlank
  private String patientName;
}
