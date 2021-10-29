package com.epam.brest;



import com.epam.brest.file.FileReader;
import com.epam.brest.model.ReadDataState;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext
                = new ClassPathXmlApplicationContext("spring-config.xml");
        FileReader fileReader = applicationContext.getBean(FileReader.class);

        Map<Integer, BigDecimal> pricePerKgMap = fileReader.readData("priceOfDistance.csv");
        Map<Integer, BigDecimal> pricePerKmMap = fileReader.readData("priceOfDistance.csv");


        BigDecimal weight, pricePerKg, length, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
            Status currentStatus = new ReadDataState(scanner, pricePerKgMap, pricePerKmMap);
            while (currentStatus.getType() != StatusType.EXIT) {
                System.out.println("Current status: " + currentStatus.getType());
                currentStatus = currentStatus.handle();
            }
        }
    }


}