package org.example.medicaldiagnosisapi.dtos.requests;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDeseaseAndTreatmentDiagnosis {
  @NotBlank
  String diagnosisIdentifiedDiseaseByDoctor;
  @NotBlank
  String treatmentSuggestedByDoctor;
  String diagnosisObservations;
}
