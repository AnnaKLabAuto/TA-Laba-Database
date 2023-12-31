package com.solvd.training.model;

import java.util.Date;

public class ClientInvoice {
    private int idInvoice;
    private Date invoiceDate;
    private Date dueDate;
    private double amount;
    private String paymentStatus;
    private int projectsId;
    private int clientsId;

    public ClientInvoice(Date invoiceDate, Date dueDate, double amount, String paymentStatus,
                         int projectsId, int clientsId) {
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.projectsId = projectsId;
        this.clientsId = clientsId;
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

    public int getProjectsId() {
        return projectsId;
    }

    public void setProjectsId(int projectsId) {
        this.projectsId = projectsId;
    }

    public int getClientsId() {
        return clientsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    @Override
    public String toString() {
        return "ClientInvoice{" +
                "idInvoice=" + idInvoice +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                ", amount=" + amount +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", projectsId=" + projectsId +
                ", clientsId=" + clientsId +
                '}';
    }
}

