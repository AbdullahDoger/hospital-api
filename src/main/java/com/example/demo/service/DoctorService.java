package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //Spring Boot'a "Bu sınıf uygulamanın 'Müdürü'dür (İş Mantığı katmanı) diyen etiket.

public class DoctorService {
    private final DoctorRepository doctorRepository;
    // private: doctorRepository'e sadece bu sınıftan emir verilebilir. Dışarıdan müdahale yasaktır.
    // final: doctorRepository çalışırken başka biriyle değiştirilemez (güvenlik için kilitli).
    // DoctorRepository : doctorRepository'nin tipi (Kendi yarattığımız Veri Tipi).
    // doctorRepository : bizim tanımladığımız değişken.

    @Autowired
    // =new... tanımlamama gerek kalmıyor DoctorRepository Ahmet = new DoctorRepository
    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
        // DoctorRepository türünde doctor repository parametresini alacağım dışarıdan
        //this ile dışarıdan aldığım parametreyi üstte tanımladığım doctorRepository'e attım
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
        //saveDoctor metot, tipi Doctor doctorRepository api ile extends(miras) aldığı için save diyorum benim yerime doctor table a kaydediyor
    }

    public List<Doctor> gettAllDoctors(){
        return doctorRepository.findAll();
        // gettAllDoctors bir metot. Geriye Doctor sınıfından nesnelerin olduğu bir Liste (List) döndürüyor.
        // doctorRepository, miras aldığı findAll() yeteneği sayesinde veritabanındaki tüm doktorları (SELECT * FROM) bizim yerimize bulup listeliyor.
    }

    // GÜNCELLEME İŞLEMİ (PUT)
    public Doctor updateDoctor(long id, Doctor doctorDetails) {
        // 1. Önce "Bu ID'ye sahip bir doktor gerçekten var mı?" diye veritabanına soruyoruz.
        // Yoksa (orElseThrow) programı çökertmek yerine kibarca hata fırlatıyoruz.
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Güncellenecek doktor bulunamadı! ID: " + id));

        // 2. Doktor bulunduysa, Postman'den gelen YENİ bilgileri (doctorDetails), ESKİ doktorun (existingDoctor) üzerine yazıyoruz.
        existingDoctor.setFirstName(doctorDetails.getFirstName());
        existingDoctor.setLastName(doctorDetails.getLastName());
        existingDoctor.setSpecialty(doctorDetails.getSpecialty());

        // 3. Güncellenmiş haliyle veritabanına geri kaydediyoruz. (JPA ID'nin var olduğunu bildiği için yeni kayıt açmaz, var olanı günceller).
        return doctorRepository.save(existingDoctor);
    }

    // SİLME İŞLEMİ (DELETE)
    public void deleteDoctor(long id) {
        // Spring Data JPA'nın kendi metodu olan deleteById'yi kullanarak o ID'yi veritabanından siliyoruz.
        doctorRepository.deleteById(id);
    }

}
