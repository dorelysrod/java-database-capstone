package com.yourpackage.smartclinic.repository;

import com.yourpackage.smartclinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Finds a patient by their email address.
     * @param email patient's email
     * @return optional Patient
     */
    Optional<Patient> findByEmail(String email);

    /**
     * Finds a patient by their phone number.
     * @param phoneNumber patient's phone number
     * @return optional Patient
     */
    Optional<Patient> findByPhoneNumber(String phoneNumber);
}
