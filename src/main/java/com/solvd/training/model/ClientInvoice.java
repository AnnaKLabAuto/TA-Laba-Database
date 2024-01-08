package com.solvd.training.model;

import java.util.Date;

public class ClientInvoice {
    private int idInvoice;
    private Date invoiceDate;
    private Date dueDate;
    private double amount;
    private String paymentStatus;
    private int projectId;
    private int clientId;

    public ClientInvoice(Date invoiceDate, Date dueDate, double amount, String paymentStatus,
                         int projectId, int clientId) {
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.projectId = projectId;
        this.clientId = clientId;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "ClientInvoice{" +
                "idInvoice=" + idInvoice +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", projectId=" + projectId +
                ", clientId=" + clientId +
                '}';
    }
}

