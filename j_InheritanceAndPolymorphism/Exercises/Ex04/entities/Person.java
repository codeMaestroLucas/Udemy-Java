package j_InheritanceAndPolymorphism.Exercises.Ex04.entities;

public abstract class Person {

    protected String name;
    protected Double anualIncome;


    public Person(String name, Double anualIncome) {
        this.name = name.trim();
        this.anualIncome = anualIncome;
    }

    public String getName() {
        return name;
    }

    public Double getAnualIncome() {
        return anualIncome;
    }

    public abstract Double getTax();

    @Override
    public String toString() {
        
        
        return String.format("%s: $%,.2f", this.getName(), this.getTax());
    }
    

}
