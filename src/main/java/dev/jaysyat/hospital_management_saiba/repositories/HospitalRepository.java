package dev.jaysyat.hospital_management_saiba.repositories;

import dev.jaysyat.hospital_management_saiba.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
