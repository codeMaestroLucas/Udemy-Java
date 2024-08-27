package j_InheritanceAndPolymorphism.Exercises.Ex04.entities;

public class Individual extends Person {

    private Double healthExpends;
    private Double taxToPay;

    public Individual(String name, Double anualIncome, Double healthExpends) {
        super(name, anualIncome);
        this.healthExpends = healthExpends;
    }

    public Double getHealthExpends() {
        return healthExpends;
    }

    public void setHealthExpends(Double healthExpends) {
        this.healthExpends = healthExpends;
    }

    public Double getTax() {
        Double incomeYear = this.getAnualIncome();
        Double healtExp = this.getHealthExpends();
        if (incomeYear < 20000) {
            taxToPay = incomeYear * 0.15;
        } else {
            taxToPay = incomeYear * 0.25;
        }

        if (healtExp > 0) {
            taxToPay -= healtExp / 2;
        }

        return taxToPay;

    }


    
}
