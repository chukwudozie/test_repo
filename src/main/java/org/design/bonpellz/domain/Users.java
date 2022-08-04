package org.design.bonpellz.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "user")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull
    @Column(name = "email", unique = true)
    @Email
    private String email;

    @NotNull
    @Column(name = "phone_number")
    @NotBlank(message = "Phone Number is required")
    @Pattern(regexp = "(^$|[0-9]{11})", message = "Phone Number should contain 11 digits")
    private String phonenNumber;

    @NotNull
    private boolean activated;

    @NotNull
    @Past(message = "Enter valid date")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "hear_about_us")
    private String hearAboutUs;




}
