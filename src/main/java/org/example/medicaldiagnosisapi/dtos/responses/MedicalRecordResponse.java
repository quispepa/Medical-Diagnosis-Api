package org.example.medicaldiagnosisapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.models.Patient;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MedicalRecordResponse {
  private Patient patient;
}
