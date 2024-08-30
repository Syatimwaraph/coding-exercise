package dev.jaysyat.hospital_management_saiba.repositories;

import dev.jaysyat.hospital_management_saiba.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUserEmail(String userEmail);
}
