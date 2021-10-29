package com.epam.brest.model;


import com.epam.brest.calc.CalcImpl;
import com.epam.brest.selector.PriceSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

import static com.epam.brest.model.StatusType.CALC;

public class CalcState extends AbstractStatus {
    ApplicationContext applicationContext
            = new ClassPathXmlApplicationContext("spring-config.xml");
    CalcImpl calculation = applicationContext.getBean(CalcImpl.class);
    PriceSelector priceSelector =  applicationContext.getBean(PriceSelector.class);


    public CalcState(Scanner scanner, Map<Integer, BigDecimal> pricePerKgMap, Map<Integer, BigDecimal> pricePerKmMap) {
        this.scanner = scanner;
        this.pricePerKgMap = pricePerKgMap;
        this.pricePerKmMap = pricePerKmMap;
    }

    @Override
    public Status handle() {
      try{  BigDecimal pricePerKg = priceSelector.selectPriceValue(pricePerKgMap, userData.get(0));
        BigDecimal pricePerKm = priceSelector.selectPriceValue(pricePerKmMap, userData.get(1));
        BigDecimal result = calculation.handle(userData.get(0), pricePerKg, userData.get(1), pricePerKm);
        System.out.println("Result: " + result);}
      finally {
          userData.clear();
      }


        return new ReadDataState(scanner, pricePerKgMap, pricePerKmMap);
    }

    @Override
    public StatusType getType() {
        return CALC;
    }
}
