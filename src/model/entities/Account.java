package model.entities;

import model.exeception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balancer;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balancer, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balancer = balancer;
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balancer += amount;
    }

    public void withdraw(double amount){
        validateWithdraw(amount);
        balancer -= amount;
    }

    public void validateWithdraw(double amount){
        if (amount > getWithdrawLimit()) {
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (amount > getBalancer()) {
            throw new DomainException("Not enough balance");
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalancer() {
        return balancer;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
