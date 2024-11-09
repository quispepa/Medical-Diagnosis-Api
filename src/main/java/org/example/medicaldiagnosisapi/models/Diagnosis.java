package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.DiagnosisTreatmentStatus;

import java.time.LocalDate;
import java.util.List;

@Table(name = "diagnoses")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Diagnosis {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "diagnosis_id")
  private Long diagnosisId;
  @Column(name = "diagnosis_identified_disease_by_ia")
  private String diagnosisIdentifiedDiseaseByIA;
  @Column(name = "diagnosis_identified_disease_by_doctor")
  private String diagnosisIdentifiedDiseaseByDoctor;
  @Column(name = "treatment_suggested_by_ia")
  private String treatmentSuggestedByAI;
  @Column(name = "treatment_suggested_by_doctor")
  private String treatmentSuggestedByDoctor;
  @Column(name = "diagnosis_approval_date_by_Doctor")
  private LocalDate diagnosisApprovalDateByDoctor;
  @Column(name = "diagnosis_observations")
  private String diagnosisObservations;
  @Column(name = "diagnosis_treatment_status")
  @Enumerated(EnumType.STRING)
  private DiagnosisTreatmentStatus diagnosisTreatmentStatus;

  @OneToOne
  @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id")
  @JsonBackReference
  private Appointment appointment;

  @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<MedicalTest> medicalTests;

  @ManyToOne()
  @JoinColumn(name = "medical_record_id")
  @JsonBackReference
  private MedicalRecord medicalRecord;

  public Diagnosis(String diagnosisIdentifiedDiseaseByIA, String diagnosisIdentifiedDiseaseByDoctor, String treatmentSuggestedByAI, String treatmentSuggestedByDoctor, LocalDate diagnosisApprovalDateByDoctor, String diagnosisObservations, DiagnosisTreatmentStatus diagnosisTreatmentStatus) {
    this.diagnosisIdentifiedDiseaseByIA = diagnosisIdentifiedDiseaseByIA;
    this.diagnosisIdentifiedDiseaseByDoctor = diagnosisIdentifiedDiseaseByDoctor;
    this.treatmentSuggestedByAI = treatmentSuggestedByAI;
    this.treatmentSuggestedByDoctor = treatmentSuggestedByDoctor;
    this.diagnosisApprovalDateByDoctor = diagnosisApprovalDateByDoctor;
    this.diagnosisObservations = diagnosisObservations;
    this.diagnosisTreatmentStatus = diagnosisTreatmentStatus;
  }

  public Diagnosis(DiagnosisTreatmentStatus diagnosisTreatmentStatus) {
    this.diagnosisTreatmentStatus = diagnosisTreatmentStatus;
  }

}
