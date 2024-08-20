package A01.entities;

public class Triangle {
    
    public double a;
    public double b;
    public double c;
    public double p;
    public double area;
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea() {
        p = (a + b + c) / 2;
        area = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        return area;
    }
}
