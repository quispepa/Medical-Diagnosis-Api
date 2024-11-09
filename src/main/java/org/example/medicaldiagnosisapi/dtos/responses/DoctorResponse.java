package org.example.medicaldiagnosisapi.dtos.responses;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.DoctorSpecialty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoctorResponse {
  @NotBlank
  private String doctorName;
  @NotNull
  private DoctorSpecialty doctorSpecialty;
}
