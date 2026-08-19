package com.example.demo.entity;

import jakarta.persistence.*;
//my_Branch123
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doctor_seq")
    @SequenceGenerator(name = "doctor_seq", sequenceName = "doctor_sequence", allocationSize = 1)

    private long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "specialty")
    private String specialty;


    public long getId(){
        return id;
    }


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

