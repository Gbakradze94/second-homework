package org.epam.training.task5.model;

import java.util.Objects;

public class ExchangeTicket {
    private int id;
    private User client;
    private Currency fromCurrency;
    private Currency toCurrency;
    private double toCurrencyAmount;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(Currency fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(Currency toCurrency) {
        this.toCurrency = toCurrency;
    }

    public double getToCurrencyAmount() {
        return toCurrencyAmount;
    }

    public void setToCurrencyAmount(double toCurrencyAmount) {
        this.toCurrencyAmount = toCurrencyAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeTicket that = (ExchangeTicket) o;
        return id == that.id && Double.compare(that.toCurrencyAmount, toCurrencyAmount) == 0 && Objects.equals(client, that.client) && Objects.equals(fromCurrency, that.fromCurrency) && Objects.equals(toCurrency, that.toCurrency) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, fromCurrency, toCurrency, toCurrencyAmount, status);
    }
}
