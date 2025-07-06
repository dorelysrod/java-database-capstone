package com.yourpackage.smartclinic.service;

import com.yourpackage.smartclinic.model.Appointment;
import com.yourpackage.smartclinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    /**
     * Retrieves all appointments for a specific doctor.
     * @param doctorId ID of the doctor
     * @return list of appointments
     */
    public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
        try {
            return appointmentRepository.findByDoctorId(doctorId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve appointments for doctor ID: " + doctorId, e);
        }
    }

    /**
     * Books a new appointment.
     * @param appointment Appointment object to save
     * @return saved Appointment
     */
    public Appointment bookAppointment(Appointment appointment) {
        try {
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to book appointment", e);
        }
    }
}
