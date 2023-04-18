package org.epam.training.task5.service;

import org.epam.training.task5.model.ExchangeRate;

import java.io.FileReader;
import java.io.IOException;


public class ExchangeService {
    private FileReader fileReader;
    public ExchangeService() throws IOException {
        this.fileReader.read();
    }
   public double convert(ExchangeRate exchangeRate, double initialValue) {
       return initialValue * exchangeRate.getRate();
   }
}
