package com.example.demo.service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Yeni randevu kaydetme metodu
    public Appointment saveAppointment(Appointment appointment) {
        // İleride buraya "Doktor o saatte müsait mi?" kontrolünü ekleyeceğiz!
        return appointmentRepository.save(appointment);
    }

    // Tüm randevuları listeleme metodu
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public void deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
    }
}