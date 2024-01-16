package com.solvd.training.patterns.builder;

import java.sql.Date;

import static com.solvd.training.utils.LoggerUtil.log;

public class BuilderMain {
    public static void main(String[] args) {

        Invoice invoice = new Invoice.Builder()
                .withInvoiceDate(new Date(System.currentTimeMillis()))
                .withDueDate(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
                .withAmount(100.0)
                .withPaymentStatus("Unpaid")
                .withProjectName("Project1")
                .withClientFirstName("John")
                .withCompany("Doe Inc.")
                .withEmail("john.doe@example.com")
                .build();

        Invoice invoice2 = new Invoice.Builder()
                .withInvoiceDate(new Date(System.currentTimeMillis()))
                .withDueDate(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
                .withAmount(100.0)
                .withPaymentStatus("Unpaid")
                .withProjectName("Project2")
                .withClientFirstName("John")
                .withCompany("Doe Inc.")
                .withEmail("john.doe@example.com")
                .build();

        log.info(invoice);
        log.info(invoice2);
    }
}
