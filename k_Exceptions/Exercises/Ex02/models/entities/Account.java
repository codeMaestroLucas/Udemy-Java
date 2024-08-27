package k_Exceptions.Exercises.Ex02.models.entities;

import k_Exceptions.Exercises.Ex02.models.exceptions.SpecialExpt;

public class Account {
    
    protected Integer number;
    protected String holder;
    protected Double balance;
    protected Double withdrawLimit;

    
    public Account(Integer number, String holder, Double withdrawLimit) {
        this.number = number;
        this.holder = holder.trim();
        this.balance = 0.0;
        this.withdrawLimit = withdrawLimit;
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder.trim();
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
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

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double value) throws SpecialExpt {
        if (value <= 0) {
            throw new SpecialExpt("The value to deposit has to be positive.");
        }
        
        this.balance += value;
    }

    public void withdraw(Double value) throws SpecialExpt {
        if (value <= 0) {
            throw new SpecialExpt("The value to withdraw has to be positive.");
        }

        if (value > this.getWithdrawLimit()) {
            throw new SpecialExpt("Withdrwal limit exceeded.");
        }

        if (value > this.balance) {
            throw new SpecialExpt("Insufficient balance.");
        }

        this.balance -= value;
    }

    @Override
    public String toString() {
        return String.format("Number %d ; Holder: %s ; Balance: \033[32m$%,.2f\033[m ; "
                             + "Withdraw Limit: $%,.2f",
                             this.getNumber(), this.getHolder(),
                             this.getBalance(), this.getWithdrawLimit());
    }
    
}
