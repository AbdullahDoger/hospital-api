package com.example.demo.controller;

import com.example.demo.entity.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController: Spring Boot'a "Bu sınıf dışarıdan (internetten) gelen istekleri karşılayan veznedir" der.
@RestController
// @RequestMapping: Bu veznenin adresini belirler. Tarayıcıda veya Postman'de "localhost:8080/api/doctors" yazıldığında burası çalışır.
@RequestMapping("/api/doctors")

public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // @PostMapping: Dışarıdan veri GÖNDERİLİRSE (Yeni kayıt) bu metot çalışır.
    // @RequestBody: Gelen JSON (metin) formatındaki hasta dosyasını, Java'daki Doctor nesnesine dönüştürür.
    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        // doctorService islemlerin yapılacığı DoctorService katmanından türedi onun yetkisine sahip.
        // DoctorService katmanındaki saveDoctor metotunu cagirdi doctor parametresini verdi.
        return doctorService.saveDoctor(doctor);
    }

    // @GetMapping: Dışarıdan veri İSTENİRSE (Listeleme) bu metot çalışır.
    @GetMapping
    public List<Doctor> getAllDoctors() {
        // DoctorService katmanındaki getallDoctors metotunu cagirdi.
        // bu metot Geriye Doctor sınıfından nesnelerin olduğu bir Liste (List) döndürüyor.
        return doctorService.gettAllDoctors();
    }

    // @PutMapping: Dışarıdan var olan bir veriyi GÜNCELLEMEK için istek gelirse bu metot çalışır.
    // "/{id}": Adresin sonuna yazılan sayıyı (örneğin /api/doctors/2) yakalar.
    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctorDetails) {
        // DoctorService katmanındaki updateDoctor metodunu çağırdık.
        // Hem URL'den yakaladığımız ID'yi, hem de Postman'den gelen yeni bilgileri gönderiyoruz.
        return doctorService.updateDoctor(id, doctorDetails);
    }

    // @DeleteMapping: Dışarıdan var olan bir veriyi SİLMEK için istek gelirse bu metot çalışır.
    // "/{id}": Silinecek doktorun ID'sini adresin sonundan (örneğin /api/doctors/2) yakalar.
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable long id) {
        // DoctorService katmanındaki deleteDoctor metodunu çağırıp o ID'ye sahip doktoru siliyoruz.
        doctorService.deleteDoctor(id);

        // Postman ekranında boş bir sayfa yerine güzel bir bilgi mesajı görelim.
        return "Doktor başarıyla silindi. (Silinen ID: " + id + ")";
    }
}
