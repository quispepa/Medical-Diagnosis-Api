package org.example.medicaldiagnosisapi.dtos;

import jakarta.persistence.*;
import org.example.medicaldiagnosisapi.enums.PatientBiologicalSex;

import java.time.LocalDate;

public class PatientResponse {
  private String patientName;
  private LocalDate patientDayOfBirth;
  private PatientBiologicalSex patientBiologicalSex;
}
