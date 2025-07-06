package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String specialization;

}
