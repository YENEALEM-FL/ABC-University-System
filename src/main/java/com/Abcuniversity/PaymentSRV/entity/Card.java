package com.Abcuniversity.PaymentSRV.entity;

import com.Abcuniversity.PaymentSRV.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private long number;
    private Long expiration;
    private String name;
    private CardType type ;
    private String Status;

    @OneToOne
    private Payment payment;

}
