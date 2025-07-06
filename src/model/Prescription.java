package com.yourpackage.smartclinic.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescriptions")
public class Prescription {

    @Id
    private String id;

    private String patientName;
    private String medication;
    private Long appointmentId;
}
