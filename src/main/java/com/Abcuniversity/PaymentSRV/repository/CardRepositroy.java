package com.Abcuniversity.PaymentSRV.repository;

import com.Abcuniversity.PaymentSRV.entity.Card;
import com.Abcuniversity.PaymentSRV.enums.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepositroy extends JpaRepository<Card, Long> {
    @Query(value = "insert into Card (number, expiration, name , type , status) values (:number, :expiration,:name , :type , :status) ", nativeQuery = true)
    void save(Long number, Long expiration, String name, CardType type, String status);
}
