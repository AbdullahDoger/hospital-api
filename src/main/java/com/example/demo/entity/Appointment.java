package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq")
    @SequenceGenerator(name = "appointment_seq", sequenceName = "appointment_sequence", allocationSize = 1)

    private long id;

    @Column(name ="appointment_date",nullable = false)
    private LocalDateTime appointmentDate;
    //Tarih ve saat bilgisini hatasız ve profesyonelce tutabilen
    //hazır bir sınıfı (objeyi) çağırıp, kendi randevu tablomuzun içine yerleştiriyoruz.
    // Postman'den veri gönderirken evrensel standart olan şu formatı kullanacağız: "2026-08-15T14:30:00"

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;

    public Appointment() {
    }

    public Appointment(LocalDateTime appointmentDate, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
