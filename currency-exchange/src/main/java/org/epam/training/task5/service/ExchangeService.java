package org.epam.training.task5.service;

import org.epam.training.task5.model.ExchangeRate;


public class ExchangeService {

   public double convert(ExchangeRate exchangeRate, double initialValue) {
       return initialValue * exchangeRate.getRate();
   }
}
