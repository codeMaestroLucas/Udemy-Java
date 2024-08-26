package j_InheritanceAndPolymorphism.A01.entities;

public class BusinessAccount extends Account {

    private Double loanLimit;
    private Double loanTax = 10.0;   // Just an small tax

    public BusinessAccount(Integer number, String holder, Double loanLimit) {
        super(number, holder);
        this.loanLimit = loanLimit;
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return this.loanLimit;
    }

    public void loan(Double amount) {
        if (amount > this.loanLimit) {
            System.out.printf("Your loan limit it $%,.2f\n", this.loanLimit);
            return;
        }

        this.deposit(amount - this.loanTax);
    }
    
}
