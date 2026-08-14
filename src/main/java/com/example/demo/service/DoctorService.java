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
}
