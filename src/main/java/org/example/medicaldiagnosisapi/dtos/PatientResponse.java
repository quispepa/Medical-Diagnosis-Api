package org.example.medicaldiagnosisapi.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.PatientBiologicalSex;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientResponse {
  private String patientName;
  private LocalDate patientDayOfBirth;
  private PatientBiologicalSex patientBiologicalSex;
}
