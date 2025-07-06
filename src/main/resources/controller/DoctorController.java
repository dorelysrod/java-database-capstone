package com.yourpackage.smartclinic.controller;

import com.yourpackage.smartclinic.model.Doctor;
import com.yourpackage.smartclinic.service.DoctorService;
import com.yourpackage.smartclinic.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;
    private final TokenService tokenService;

    public DoctorController(DoctorService doctorService, TokenService tokenService) {
        this.doctorService = doctorService;
        this.tokenService = tokenService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<?> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.addDoctor(doctor));
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<?> getDoctorAvailability(@RequestHeader("Authorization") String token,
                                                   @PathVariable Long id,
                                                   @RequestParam String date,
                                                   @RequestParam String role) {
        if (!tokenService.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
        }

        if (!role.equals("admin") && !role.equals("patient") && !role.equals("doctor")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid role");
        }

        return ResponseEntity.ok(doctorService.getAvailabilityByDate(id, date));
    }
}
