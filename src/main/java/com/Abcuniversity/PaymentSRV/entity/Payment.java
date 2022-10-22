package com.Abcuniversity.PaymentSRV.entity;

import com.Abcuniversity.PaymentSRV.enums.CardType;
import com.Abcuniversity.PaymentSRV.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long payment_id;
    private Timestamp payment_date ;
    private CardType card_type;
    private Status payment_status;
    private String status;

}

