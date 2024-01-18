package com.solvd.training.patterns.builder;

import java.util.Date;

public class Invoice {

    private Date invoiceDate;
    private Date dueDate;
    private double amount;
    private String paymentStatus;
    private String  projectName;
    private String  clientFirstName;
    private String  company;
    private String  email;

    public Invoice(Date invoiceDate, Date dueDate, double amount, String paymentStatus, String projectName, String clientFirstName, String company, String email) {
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.projectName = projectName;
        this.clientFirstName = clientFirstName;
        this.company = company;
        this.email = email;
    }

    public static class Builder {
        private Date invoiceDate;
        private Date dueDate;
        private double amount;
        private String paymentStatus;
        private String projectName;
        private String clientFirstName;
        private String company;
        private String email;

        public Builder withInvoiceDate(Date invoiceDate) {
            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder withDueDate(Date dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder withAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder withPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder withProjectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder withClientFirstName(String clientFirstName) {
            this.clientFirstName = clientFirstName;
            return this;
        }

        public Builder withCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Invoice build() {
            return new Invoice(invoiceDate, dueDate, amount, paymentStatus, projectName, clientFirstName, company, email);
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", projectName='" + projectName + '\'' +
                ", clientFirstName='" + clientFirstName + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}