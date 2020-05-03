package com.spring.microservices.currencyexchangeservice.repository;

import com.spring.microservices.currencyexchangeservice.controller.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long>{

    ExchangeValue findByCurrencyAndTo(String from, String to);
}
