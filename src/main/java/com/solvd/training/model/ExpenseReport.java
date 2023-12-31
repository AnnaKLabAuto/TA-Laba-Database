package com.solvd.training.model;

import java.util.Date;

public class ExpenseReport {
    private int idExpenseReport;
    private Date reportDate;
    private double totalAmount;
    private int submittedBy;

    public ExpenseReport(Date reportDate, double totalAmount, int submittedBy) {
        this.reportDate = reportDate;
        this.totalAmount = totalAmount;
        this.submittedBy = submittedBy;
    }

    public int getIdExpenseReport() {
        return idExpenseReport;
    }

    public void setIdExpenseReport(int idExpenseReport) {
        this.idExpenseReport = idExpenseReport;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(int submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Override
    public String toString() {
        return "ExpenseReport{" +
                "idExpenseReport=" + idExpenseReport +
                ", reportDate=" + reportDate +
                ", totalAmount=" + totalAmount +
                ", submittedBy=" + submittedBy +
                '}';
    }
}

