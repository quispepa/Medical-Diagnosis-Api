package org.example.medicaldiagnosisapi.dtos;

import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.PatientBiologicalSex;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdatePatientRequest {
  @Past
  private LocalDate patientDayOfBirth;
  private PatientBiologicalSex patientBiologicalSex;
}
