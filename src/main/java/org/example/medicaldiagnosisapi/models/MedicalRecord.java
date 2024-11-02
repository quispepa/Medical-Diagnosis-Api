package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "medical_records")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MedicalRecord {
  @Id
  @Column(name = "medical_record_id")
  private Long medicalRecordId;

  @OneToOne
  @MapsId
  @JoinColumn(name = "medical_record_id")
  @JsonBackReference
  private Patient patient;

  @OneToMany(mappedBy = "medicalRecord",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonManagedReference
  private List<Diagnosis> diagnoses;

  public MedicalRecord(Patient patient) {
    this.patient = patient;
  }
}
