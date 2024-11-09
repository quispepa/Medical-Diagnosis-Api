package org.example.medicaldiagnosisapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.medicaldiagnosisapi.enums.DoctorSpecialty;

import java.util.List;

@Table(name = "doctors")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Doctor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "doctor_id")
  private Long doctorId;
  @Column(name = "doctor_name")
  private String doctorName;
  @Column(name = "doctor_specialty")
  @Enumerated(value = EnumType.STRING)
  private DoctorSpecialty doctorSpecialty;

  @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Appointment> appointments;

  /**
   * Object constructor without related variables or id
   * @param doctorName doctorName
   * @param doctorSpecialty doctorSpecialty
   */
  public Doctor(String doctorName, DoctorSpecialty doctorSpecialty) {
    this.doctorName = doctorName;
    this.doctorSpecialty = doctorSpecialty;
  }
}
