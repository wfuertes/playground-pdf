package com.wfuertes.dto;

import java.math.BigDecimal;
import java.util.List;

public class BonusReport {

    private String employee;
    private String email;
    private List<Bonus> bonuses;

    public BonusReport(String employee, String email, List<Bonus> bonuses) {
        this.employee = employee;
        this.email = email;
        this.bonuses = bonuses;
    }

    public String getEmployee() {
        return employee;
    }

    public String getEmail() {
        return email;
    }

    public List<Bonus> getBonuses() {
        return bonuses;
    }

    public BigDecimal getTotalBonuses() {
        return BigDecimal.valueOf(bonuses.stream().mapToDouble(value -> value.getValue().doubleValue()).sum());
    }
}
