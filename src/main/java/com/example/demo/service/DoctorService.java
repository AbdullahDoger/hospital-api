package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;


    @Autowired
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;

    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);

    }

    public List<Doctor> gettAllDoctors(){
        return doctorRepository.findAll();

    }


    public Doctor updateDoctor(long id, Doctor doctorDetails) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Güncellenecek doktor bulunamadı! ID: " + id));


        existingDoctor.setFirstName(doctorDetails.getFirstName());
        existingDoctor.setLastName(doctorDetails.getLastName());
        existingDoctor.setSpecialty(doctorDetails.getSpecialty());


        return doctorRepository.save(existingDoctor);
    }


    public void deleteDoctor(long id) {
        doctorRepository.deleteById(id);
    }

}
