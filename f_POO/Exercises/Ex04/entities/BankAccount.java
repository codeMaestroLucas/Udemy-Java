package Exercises.Ex04.entities;

public class BankAccount {

    private int acc_number;
    private String acc_holder;
    private double balance;
    private double withdraw_tax = 5;

    public BankAccount(int acc_number, String acc_holder) {
        this.acc_number = acc_number;
        this.acc_holder = acc_holder;
    }

    public BankAccount(int acc_number, String acc_holder, double initial_deposit) {
        this.acc_number = acc_number;
        this.acc_holder = acc_holder;
        this.balance = initial_deposit;
    }

    public void deposit(double value_to_deposit) {
        if (value_to_deposit <= 0) {
            System.out.println("Can't deposit an negative amount.");
            return;
        }

        System.out.printf("Successfuly deposited \033[32m$%.2f\033[m\n",
                value_to_deposit);
        this.balance += value_to_deposit;

    }

    public void withdraw(double value_to_withdraw) {
        if (value_to_withdraw <= 0) {
            System.out.println("Can't withdraw an negative amount.");
            return;
        }

        System.out.printf("Successfuly withdraw \033[31m$%.2f\033[m " +
                "plus an extra amount of \033[31m$%.2f\033[m for the bank tax.\n",
                value_to_withdraw, this.withdraw_tax);
        this.balance -= (value_to_withdraw + withdraw_tax);

    }

    // Getters & Setters
    public int getAccNumber() {
        return this.acc_number;
    }

    public String getAccHolder() {
        return this.acc_holder;
    }

    public void setAccHolder(String new_accHolder) {
        this.acc_holder = new_accHolder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String heading = "ACCOUNT DATA";
    
        sb.append("\n");
        sb.append("=".repeat(50)).append("\n");
        sb.append(" ".repeat((50 - heading.length()) / 2))
          .append(heading).append("\n");
        sb.append("-".repeat(50)).append("\n");
        
        sb.append("ACC-Number: ").append(this.acc_number).append("\n");
        sb.append("Holder: ").append(this.acc_holder).append("\n");
    
        if (this.balance >= 0) {
            sb.append(String.format("Balance: \033[32m$%.2f\033[m\n", this.balance));
        } else {
            sb.append(String.format("Balance: \033[31m$%.2f\033[m\n", this.balance));
        }
    
        sb.append("=".repeat(50)).append("\n");
    
        return sb.toString();
    }
    

}
