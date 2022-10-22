package com.Abcuniversity.PaymentSRV.repository;

import com.Abcuniversity.PaymentSRV.entity.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {
}
