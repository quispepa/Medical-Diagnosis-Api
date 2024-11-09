package org.example.medicaldiagnosisapi.dtos.responses;

import lombok.*;
import org.example.medicaldiagnosisapi.enums.MedicalTestStatus;
import org.example.medicaldiagnosisapi.enums.MedicalTestType;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MedicalTestResponse {
  String result;
  MedicalTestType medicalTestType;
}
