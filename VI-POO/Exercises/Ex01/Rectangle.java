package Exercises.Ex01;

public class Rectangle {
    
    private double widht;
    private double height;

    public Rectangle(double widht, double height) {
        this.widht = widht;
        this.height = height;
    }

    private double getArea() {
        return this.widht * this.height;
    }

    private double getPerimeter() {
        return 2 * (this.widht + this.height);
    }
    
    private double getDiagonal() {
        // a² = b² + c²
        return Math.sqrt(this.widht * this.widht + this.height * this.height);
    }

    @Override
    public String toString() {
        return String.format("Area: %.2f\nPerimeter: %.2f\nDiagonal: %.2f\n",
                            this.getArea(), this.getPerimeter(), this.getDiagonal());
    }

}
