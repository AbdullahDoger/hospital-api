package com.example.demo.repository;

import com.example.demo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
//Miras aldım insert into vs yazmama gerek kalmadı save delete findall yazıyorum
    //Hedef Doctor tablosu primary key tipi Long

}
