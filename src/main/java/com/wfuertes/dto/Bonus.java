package com.wfuertes.dto;

import java.math.BigDecimal;

public class Bonus {

    private String date;
    private String description;
    private BigDecimal value;

    public Bonus(String date, String description, BigDecimal value) {
        this.date = date;
        this.description = description;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getValue() {
        return value;
    }
}
