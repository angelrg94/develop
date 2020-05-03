package com.spring.microservices.currency.conversionservice.proxy;

import com.spring.microservices.currency.conversionservice.controller.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente Feing para llamar ms
 * **/
//@FeignClient(name="currency-exchange-service",url="localhost:8000") // En cas de tener una sola instancia del MS
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to );
}
