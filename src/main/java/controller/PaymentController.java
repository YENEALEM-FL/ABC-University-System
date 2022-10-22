package controller;


import entity.Card;
import entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.PaymentRepository;
import service.IPaymentService;

import java.io.IOException;

@RestController
@RequestMapping("/ABCUniversity/")
public class PaymentController {
    @Autowired
    IPaymentService paymentService;
   @GetMapping("/home")
    public String mainPage() {
        return "Greetings from ABC university!";
    }

    @PostMapping("/addCard")
    public ResponseEntity<Card> saveCard(long l, @RequestBody Card card) throws IOException{
        return new ResponseEntity<>(paymentService.save(card), HttpStatus.OK);
    }
    @PostMapping("/payment")
    public ResponseEntity<Payment>  processPayment(long l, @RequestBody Payment payment) throws IOException{
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.OK);
    }



}
