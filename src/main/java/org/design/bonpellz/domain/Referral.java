package org.design.bonpellz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "referral")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Users> usersReferred = new HashSet<>();

    @OneToOne
    private Users userReferring;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
