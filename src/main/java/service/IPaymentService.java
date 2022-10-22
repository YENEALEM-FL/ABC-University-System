package service;

import entity.Card;
import entity.Payment;
import enums.CardType;

public interface IPaymentService {
    Card save(Card card);
    boolean isValid(CardType type);

    Payment savePayment(Payment payment);
}
