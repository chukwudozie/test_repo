package org.design.bonpellz.repository;

import org.design.bonpellz.domain.Referral;
import org.design.bonpellz.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {

    Optional<Referral> findByUserReferring(Users users);
    boolean existsByUserReferring(Users users);
}
