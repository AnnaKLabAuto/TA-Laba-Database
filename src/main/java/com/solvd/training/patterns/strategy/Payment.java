package com.solvd.training.patterns.strategy;

import com.solvd.training.patterns.MockEmployeeExample;

public interface Payment {
    double calculatePayment(MockEmployeeExample employee);
}
