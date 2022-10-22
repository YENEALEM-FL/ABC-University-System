package com.Abcuniversity.PaymentSRV.service;

import com.Abcuniversity.PaymentSRV.entity.Card;
import com.Abcuniversity.PaymentSRV.entity.Payment;
import com.Abcuniversity.PaymentSRV.enums.CardType;

public interface IPaymentService {
    Card save(Card card);
    boolean isValid(CardType type);

    Payment savePayment(Payment payment);
}
