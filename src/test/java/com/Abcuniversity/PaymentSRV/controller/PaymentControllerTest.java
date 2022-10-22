package com.Abcuniversity.PaymentSRV.controller;


import com.Abcuniversity.PaymentSRV.entity.Card;
import com.Abcuniversity.PaymentSRV.enums.CardType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.Abcuniversity.PaymentSRV.service.serviceImp.PaymentServiceImplementation;

import java.io.IOException;

@ContextConfiguration(classes = {PaymentController.class})
@ExtendWith(SpringExtension.class)
public class PaymentControllerTest {
    @Autowired
    private PaymentController paymentController;

    @MockBean
    private PaymentServiceImplementation paymentServiceImplementation;

    @Test
    @Disabled("TODO: Complete this test")
    void testSaveCard() throws IOException {
        PaymentController paymentController = new PaymentController();

        Card card = new Card();
        card.setNumber(1L);
        card.setId(123L);
        card.setName("john");
        card.setType(CardType.VISA);
        card.setStatus("ON");
        paymentController.saveCard(123L,card);

    }

}
