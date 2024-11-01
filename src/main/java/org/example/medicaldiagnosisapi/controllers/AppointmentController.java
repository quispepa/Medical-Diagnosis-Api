package org.example.medicaldiagnosisapi.controllers;

import org.example.medicaldiagnosisapi.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
  @Autowired
  AppointmentService appointmentService;
}
