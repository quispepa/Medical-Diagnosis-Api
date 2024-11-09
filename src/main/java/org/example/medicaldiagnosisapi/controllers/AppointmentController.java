package org.example.medicaldiagnosisapi.controllers;

import jakarta.validation.Valid;
import org.example.medicaldiagnosisapi.dtos.responses.AppointmentResponse;
import org.example.medicaldiagnosisapi.dtos.requests.CreateAppointmentRequest;
import org.example.medicaldiagnosisapi.dtos.requests.UpdateAppointmentDateAndTimeRequest;
import org.example.medicaldiagnosisapi.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
  @Autowired
  private AppointmentService appointmentService;

  @GetMapping
  public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
    List<AppointmentResponse> appointmentResponseList = appointmentService.getAllAppointments();
    return appointmentResponseList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(appointmentResponseList);
  }

  @PostMapping("/create")
  public ResponseEntity<AppointmentResponse> createAppointment(@RequestBody @Valid CreateAppointmentRequest createAppointmentRequest){
    Optional<AppointmentResponse> appointmentResponse = appointmentService.createAppointment(createAppointmentRequest);
    return appointmentResponse.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
  }

  @PatchMapping("/updateDateAndTime/{id}")
  public ResponseEntity<AppointmentResponse> updateAppointmentDateAndTime(@PathVariable Long id, @RequestBody @Valid UpdateAppointmentDateAndTimeRequest updateAppointmentDateAndTimeRequest){
    Optional<AppointmentResponse> appointmentResponse = appointmentService.updateAppointmentDateAndTime(id, updateAppointmentDateAndTimeRequest);
    return appointmentResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<AppointmentResponse> deleteAppointment(@PathVariable Long id){
    Optional<AppointmentResponse> appointmentResponse = appointmentService.deleteAppointment(id);
    return appointmentResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
  }

}
