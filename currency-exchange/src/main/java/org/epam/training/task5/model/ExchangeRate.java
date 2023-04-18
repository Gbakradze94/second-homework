package org.epam.training.task5.model;

import java.time.LocalDate;
import java.util.Objects;

public class ExchangeRate {
    private double rate;
    private Currency to;
    private Currency from;
    private LocalDate exchangeDate;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Currency getTo() {
        return to;
    }

    public void setTo(Currency to) {
        this.to = to;
    }

    public Currency getFrom() {
        return from;
    }

    public void setFrom(Currency from) {
        this.from = from;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Double.compare(that.rate, rate) == 0 && Objects.equals(to, that.to) && Objects.equals(from, that.from) && Objects.equals(exchangeDate, that.exchangeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, to, from, exchangeDate);
    }
}
