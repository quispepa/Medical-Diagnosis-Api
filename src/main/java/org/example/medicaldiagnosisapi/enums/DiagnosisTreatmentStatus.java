package org.example.medicaldiagnosisapi.enums;

import lombok.ToString;

@ToString
public enum DiagnosisTreatmentStatus {
  COMPLETED,
  PENDING_TEST_RESULTS,
  WAITING_FOR_DOCTORS_APPROVAL,
  PENDING_OF_APPOINTMENT
}
