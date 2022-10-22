package com.Abcuniversity.PaymentSRV.controller;


import com.Abcuniversity.PaymentSRV.entity.Card;
import com.Abcuniversity.PaymentSRV.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import com.Abcuniversity.PaymentSRV.service.IPaymentService;

import java.io.IOException;

@RestController
@RequestMapping("/ABCUniversity/")
public class PaymentController {
    @Autowired
    IPaymentService paymentService;
   /* @RequestMapping("/welcomepage")
    public String welcomepage() {
        return "Welcome to Yawin Tutor";
    }*/
   @GetMapping("/home")
    public String mainPage() {
        return "Greetings from ABC university!";
    }

    @PostMapping(value="/addCard/{l}", consumes = "application/json")
    public ResponseEntity<Card> saveCard(@PathVariable long l, @RequestBody Card card) throws IOException{
        return new ResponseEntity<>(paymentService.save(card), HttpStatus.OK);
    }
    @PostMapping(value = "/payment", consumes = "application/json")
    public ResponseEntity<Payment>  processPayment(@RequestBody Payment payment) throws IOException{
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.OK);
    }



}
