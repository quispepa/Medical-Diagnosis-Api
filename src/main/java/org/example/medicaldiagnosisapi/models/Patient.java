package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.medicaldiagnosisapi.enums.PatientBiologicalSex;

import java.time.LocalDate;
import java.util.List;

@Table(name = "patients")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_id")
  private Long patientId;
  @Column(name = "patient_name")
  private String patientName;
  @Column(name = "patient_day_of_birth")
  private LocalDate patientDayOfBirth;
  @Column(name = "patient_biological_sex")
  @Enumerated(EnumType.STRING)
  private PatientBiologicalSex patientBiologicalSex;

  @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
  private MedicalRecord medicalRecord;
  @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Appointment> appointments;

  /**
   * Object constructor without related variables or id
   * @param patientName patientName
   * @param patientDayOfBirth patientDayOfBirth
   * @param patientBiologicalSex patientBiologicalSex
   */
  public Patient(String patientName, LocalDate patientDayOfBirth, PatientBiologicalSex patientBiologicalSex) {
    this.patientName = patientName;
    this.patientDayOfBirth = patientDayOfBirth;
    this.patientBiologicalSex = patientBiologicalSex;
  }
}
