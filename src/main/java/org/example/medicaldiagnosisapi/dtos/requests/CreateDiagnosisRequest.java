package org.example.medicaldiagnosisapi.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateDiagnosisRequest {
  private String diagnosisIdentifiedDiseaseByIA;
  private String diagnosisIdentifiedDiseaseByDoctor;
  private String treatmentSuggestedByAI;
  private String treatmentSuggestedByDoctor;
  private LocalDate diagnosisApprovalDateByDoctor;
  private String diagnosisObservations;
  private DiagnosisTreatmentStatus diagnosisTreatmentStatus;
  private Long appointmentId;
}
