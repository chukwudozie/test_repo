package org.design.bonpellz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String name;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;


    @Column(name = "activated")
    private boolean activated;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;


    @Column(name = "hear_about_us")
    private String hearAboutUs;

    @OneToOne
    @JoinColumn(name = "referral_id", referencedColumnName = "id", updatable = false)
    private Users referredBy;


    @Column(name = "referral_code")
    private String uniqueReferralCode;

    @CreationTimestamp
    private LocalDateTime createdAt;


}
