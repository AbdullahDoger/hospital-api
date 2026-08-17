package com.example.demo.service;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    // GÜNCELLEME İŞLEMİ (PUT)
    public Patient updatePatient(long id, Patient patientDetails) {
        // 1. Önce "Bu ID'ye sahip bir hasta var mı?" diye veritabanına soruyoruz.
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Güncellenecek hasta bulunamadı! ID: " + id));

        // 2. Hasta bulunduysa, Postman'den gelen YENİ bilgileri ESKİ hastanın üzerine yazıyoruz.
        // DİKKAT: Buradaki get/set isimlerini Patient.java (Entity) sınıfında nasıl yazdıysan öyle kullanmalısın.
        existingPatient.setFirstName(patientDetails.getFirstName());
        existingPatient.setLastName(patientDetails.getLastName());
        existingPatient.setSsNo(patientDetails.getSsNo());


        // 3. Güncellenmiş haliyle veritabanına geri kaydediyoruz.
        return patientRepository.save(existingPatient);
    }

    // SİLME İŞLEMİ (DELETE)
    public void deletePatient(long id) {
        // Spring Data JPA'nın metoduyla o ID'ye sahip hastayı siliyoruz.
        patientRepository.deleteById(id);
    }
}
