package repository;

import entity.Payment;
import enums.CardType;
import enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    @Modifying
    @Query(value = "insert into payment (payment_date, card_type, payment_status , payment_status , status) values (:number, :expiration,:name , :type , :status) ", nativeQuery = true)
    void save(Timestamp payment_date, CardType card_type, enums.Status payment_status, String status);


}
