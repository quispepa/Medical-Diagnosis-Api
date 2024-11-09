package org.example.medicaldiagnosisapi.enums;

import lombok.ToString;

@ToString
public enum AppointmentStatus {
  COMPLETED, SCHEDULED, RESCHEDULED, CANCELED
}
