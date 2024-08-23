package A03;

public class CurrencyConverter {
    
    private double dollar_price;
    private double dollar_bought;
    private double tax = 6;


    public CurrencyConverter(double dollar_price, double dollar_bought) {
        this.dollar_price = dollar_price;
        this.dollar_bought = dollar_bought;
    }

    public String convertValueToReias() {
        double value = this.dollar_price * this.dollar_bought +
                        (this.tax * dollar_bought * dollar_price) / 100;
        return String.format("Amount to be paid in Reais: R$%.2f", value);
    }
}
