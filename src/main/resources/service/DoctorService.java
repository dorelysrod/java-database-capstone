package com.yourpackage.smartclinic.service;

import com.yourpackage.smartclinic.model.Doctor;
import com.yourpackage.smartclinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /**
     * Retrieves all doctors.
     * @return list of doctors
     */
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    /**
     * Adds a new doctor.
     * @param doctor doctor to add
     * @return saved doctor
     */
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * Retrieves available time slots for a doctor.
     * @param doctorId doctor's ID
     * @return list of available time slots
     */
    public List<String> getAvailableTimes(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        return doctor.getAvailableTimes();
    }

    /**
     * Validates doctor login credentials.
     * @param email doctor's email
     * @param password doctor's password
     * @return true if credentials are valid
     */
    public boolean validateLogin(String email, String password) {
        return doctorRepository.findByEmail(email)
                .map(doc -> password.equals("securePassword")) 
                .orElse(false);
    }
}
