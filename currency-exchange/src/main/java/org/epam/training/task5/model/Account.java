package org.epam.training.task5.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {

    private int id;
    private BigDecimal balance;
    private Currency currency;
    private User user;

    public Account(int id, BigDecimal balance, Currency currency, User user) {
        this.id = id;
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Objects.equals(balance, account.balance) && Objects.equals(currency, account.currency) && Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, currency, user);
    }
}
