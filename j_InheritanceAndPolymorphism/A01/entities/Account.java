package j_InheritanceAndPolymorphism.A01.entities;


public class Account {
    
    protected Integer number = 0;   // Now it's interesting to put the
    protected String holder = null; //  aproprieted att as protected so the sub
    protected Double balance = 0.0; // classes can access it

    public Account(Integer number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    public Account(Integer number, String holder, Double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber() {
        return this.number;
    }

    public String getHolder() {
        return this.holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void deposit(Double amount) {
        if (amount <= 0) {return;}
        
        this.balance += amount;
    }

    public void withdraw(Double amount) {
        if (amount <= 0) {return;}

        if (amount > this.balance) {
            System.out.println("Not engouth balance in the account");
            return;
        }
        
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return STR."\{this.number} - \{this.holder} - "
        + String.format("$%,.2f", this.balance);
    }
    

}
