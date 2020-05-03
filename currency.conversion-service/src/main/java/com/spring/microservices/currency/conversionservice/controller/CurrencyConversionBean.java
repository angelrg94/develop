package com.spring.microservices.currency.conversionservice.controller;

import java.math.BigDecimal;

public class CurrencyConversionBean {

    private Long id;
    private String currencyF;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;

    public CurrencyConversionBean(Long id, String currencyF, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount) {
        this.id = id;
        this.currencyF = currencyF;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public CurrencyConversionBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyF() {
        return currencyF;
    }

    public void setCurrencyF(String currencyF) {
        this.currencyF = currencyF;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
