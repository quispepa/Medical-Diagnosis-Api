package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.MedicalTestStatus;
import org.example.medicaldiagnosisapi.enums.MedicalTestType;

@Table(name = "medical_tests")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MedicalTest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "medical_test_id")
  private Long medicalTestId;
  @Column(name = "medical_test_result")
  private String result;
  @Column(name = "medical_test_type")
  @Enumerated(value = EnumType.STRING)
  private MedicalTestType medicalTestType;
  @Column(name = "medical_test_status")
  @Enumerated(value = EnumType.STRING)
  private MedicalTestStatus medicalTestStatus;

  @OneToOne
  @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id")
  @JsonBackReference
  private Appointment appointment;
  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "diagnosis_id")
  private Diagnosis diagnosis;

  public MedicalTest(String result, MedicalTestType medicalTestType, MedicalTestStatus medicalTestStatus) {
    this.result = result;
    this.medicalTestType = medicalTestType;
    this.medicalTestStatus = medicalTestStatus;
  }
}
