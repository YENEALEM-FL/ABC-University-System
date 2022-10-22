package com.Abcuniversity.PaymentSRV.service.serviceImp;

import com.Abcuniversity.PaymentSRV.entity.Card;
import com.Abcuniversity.PaymentSRV.entity.Payment;
import com.Abcuniversity.PaymentSRV.repository.CardRepositroy;
import com.Abcuniversity.PaymentSRV.repository.PaymentRepository;
import com.Abcuniversity.PaymentSRV.service.IPaymentService;
import com.Abcuniversity.PaymentSRV.enums.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements IPaymentService {
    @Autowired
    private CardRepositroy cardRepositroy;
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Card save(Card card){

        return cardRepositroy.save(card);
    }

    public Payment savePayment(Payment payment){

        return  paymentRepository.save(payment);
    }
    @Override
    public boolean isValid(CardType type){
        if(type == CardType.VISA || type == CardType.MASTER){
            return true;
        }
        else{
            return false;
        }
    }



}
