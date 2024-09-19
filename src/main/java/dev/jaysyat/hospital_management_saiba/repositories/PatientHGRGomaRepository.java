package dev.jaysyat.hospital_management_saiba.repositories;

import dev.jaysyat.hospital_management_saiba.entities.PatientHGRGoma;
import dev.jaysyat.hospital_management_saiba.entities.PatientHealAfrica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientHGRGomaRepository extends JpaRepository<PatientHGRGoma, Long> {
    List<PatientHGRGoma> findAllByIstransferredIsFalse();
    List<PatientHGRGoma> findAllByIstransferredIsTrue();
}
