package com.yourpackage.smartclinic.controller;

import com.yourpackage.smartclinic.model.Prescription;
import com.yourpackage.smartclinic.repository.PrescriptionRepository;
import com.yourpackage.smartclinic.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionRepository prescriptionRepository;
    private final TokenService tokenService;

    public PrescriptionController(PrescriptionRepository prescriptionRepository, TokenService tokenService) {
        this.prescriptionRepository = prescriptionRepository;
        this.tokenService = tokenService;
    }

    @GetMapping("/{token}")
    public ResponseEntity<?> getAllPrescriptions(@PathVariable String token) {
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        List<Prescription> prescriptions = prescriptionRepository.findAll();
        return ResponseEntity.ok(prescriptions);
    }

    @PostMapping("/{token}")
    public ResponseEntity<?> addPrescription(@PathVariable String token,
                                             @RequestBody Prescription prescription) {
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }
        Prescription saved = prescriptionRepository.save(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
