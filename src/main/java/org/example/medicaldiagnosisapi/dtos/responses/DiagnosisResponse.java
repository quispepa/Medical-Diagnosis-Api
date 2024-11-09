package org.example.medicaldiagnosisapi.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;
import org.example.medicaldiagnosisapi.models.MedicalTest;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DiagnosisResponse {
  private String diagnosisIdentifiedDiseaseByIA;
  private String diagnosisIdentifiedDiseaseByDoctor;
  private String treatmentSuggestedByAI;
  private String treatmentSuggestedByDoctor;
  private LocalDate diagnosisApprovalDateByDoctor;
  private String diagnosisObservations;
  private DiagnosisTreatmentStatus diagnosisTreatmentStatus;
  private List<MedicalTest> medicalTests;
}
