package com.spring.microservices.currencyexchangeservice.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class ExchangeValue {

    @Id
    private Long  id;
    private String currency;
    private String to;
    private BigDecimal conversionMultiple;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return currency;
    }

    public void setFrom(String from) {
        this.currency = from;
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

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public ExchangeValue() {
    }

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.currency = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
