package com.example.demo.entity;

import jakarta.persistence.*; // Spring Boot'un veritabanı komutlarını tanıması için gereken kütüphane

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id //primary key olduğunu belirtiyor
    //@GeneratedValue(strategy = GenerationType.IDENTITY)// ıd otomatik sırayla artar
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_sequence", allocationSize = 1)
    //Spring Boot'a "Oracle'a ID numarasını sorma, Oracle'ın içinde doctor_sequence adında bir numaratör (sıramatik) oluştur ve her yeni kayıtta sıradaki sayıyı o numaratörden kendin al" dedik.
    private long id;

    @Column(name = "first_name",nullable = false)// sütunun ismini first_name yapar ve boş bırakılamaz yapar(not null)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "specialty")
    private String specialty;

    // GET Metodu: Kasanın içindeki private 'id' verisini okuyup dışarıya servis eder
    public long getId(){
        return id;
    }
    // SET Metodu: Dışarıdan gelen yeni değeri, kasanın içindeki private 'id' değişkenine yazar.

    public Doctor(){

    }

    public Doctor(String firstName, String lastName, String specialty){
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
// Yukarıdaki değişkenlerimiz 'private' (gizli) olduğu için dışarıdan doğrudan
// müdahale edilemez. Dış dünyanın bu verilere kontrollü bir şekilde
// ulaşabilmesi için aşağıdaki aracı (Get/Set) metotları kullanıyoruz.
