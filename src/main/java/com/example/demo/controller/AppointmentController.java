package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments") // Bu veznenin adresi: localhost:8080/api/appointments
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // POST isteği: Yeni randevu oluşturur
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    // GET isteği: Tüm randevuları listeler
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return "Randevu başarıyla iptal edildi. (Silinen Randevu ID: " + id + ")";
    }
}