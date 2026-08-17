package com.example.demo.controller;

import com.example.demo.entity.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService = patientService;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }
    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable long id, @RequestBody Patient patientDetails) {
        return patientService.updatePatient(id, patientDetails);
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
        return "Hasta başarıyla silindi. (Silinen ID: " + id + ")";
    }


}
