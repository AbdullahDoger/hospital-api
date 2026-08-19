package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/doctors")

public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {

        this.doctorService = doctorService;
    }



    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.gettAllDoctors();
    }


    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctorDetails) {

        return doctorService.updateDoctor(id, doctorDetails);
    }


    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        return "Doktor başarıyla silindi. (Silinen ID: " + id + ")";
    }
}
