package com.spring.microservices.currency.conversionservice.controller;

import com.spring.microservices.currency.conversionservice.proxy.CurrencyExchangeServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;
    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String to, @PathVariable String from, @PathVariable BigDecimal quantity)
    {
//invocacion de ms con RestTemplate
       Map<String,String> uriVariables =  new HashMap<String,String>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        ResponseEntity<CurrencyConversionBean> responseEntity
                = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean response= responseEntity.getBody();



        return  new CurrencyConversionBean(1l,from,to,response.getConversionMultiple(),quantity,quantity.multiply(response.getConversionMultiple()));
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String to, @PathVariable String from, @PathVariable BigDecimal quantity)
    {
//invocacion de ms con RestTemplate
        Map<String,String> uriVariables =  new HashMap<String,String>();
        uriVariables.put("from",from);
        uriVariables.put("to",to);
        CurrencyConversionBean responseEntity = proxy.retrieveExchangeValue(from,to);



        return  new CurrencyConversionBean(1l,from,to,responseEntity.getConversionMultiple(),quantity,quantity.multiply(responseEntity.getConversionMultiple()));
    }
}

