package service.serviceImp;

import entity.Card;
import entity.Payment;
import enums.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CardRepositroy;
import repository.PaymentRepository;
import service.IPaymentService;
@Service
public class PaymentServiceImplementation implements IPaymentService {
    @Autowired
    private CardRepositroy cardRepositroy;
    private PaymentRepository paymentRepository;

    @Override
    public  Card save(Card card){

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
