package com.yourpackage.smartclinic.controller;

import com.yourpackage.smartclinic.model.Prescription;
import com.yourpackage.smartclinic.repository.PrescriptionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @PostMapping
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    @GetMapping("/{id}")
    public Prescription getPrescriptionById(@PathVariable String id) {
        return prescriptionRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable String id) {
        prescriptionRepository.deleteById(id);
    }
}
