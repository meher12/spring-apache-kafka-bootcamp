package com.guru.kafka.service;

import com.guru.kafka.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InvoiceService {

    private AtomicInteger counter = new AtomicInteger();

    public Invoice generateInvoice() {
        var invoiceNumber = "INV-" + counter.incrementAndGet();
        var amount = ThreadLocalRandom.current().nextInt(1, 1000);

        return new Invoice(invoiceNumber, amount, "USD");
    }

}
