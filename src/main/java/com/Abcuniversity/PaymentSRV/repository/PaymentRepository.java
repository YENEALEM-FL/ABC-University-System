package com.Abcuniversity.PaymentSRV.repository;

import com.Abcuniversity.PaymentSRV.entity.Payment;
import com.Abcuniversity.PaymentSRV.enums.Status;
import com.Abcuniversity.PaymentSRV.enums.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Modifying
    @Query(value = "insert into payment (card_type,payment_date, payment_status, status) values (:card_type, :payment_date,:payment_status ,:status) ", nativeQuery = true)
    void save(String card_type, Timestamp payment_date, Status payment_status, String status);
    /*{
        "card_type": "VISA",
            "payment_date": "2022-10-22",
            "payment_status": "PAID",
            "status": "DONE"
    }*/

}
