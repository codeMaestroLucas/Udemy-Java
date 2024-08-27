package j_InheritanceAndPolymorphism.Exercises.Ex03.entities;

import j_InheritanceAndPolymorphism.Exercises.Ex03.entities.enums.Color;


public class Circle extends Shape {

    private Double radius;

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return radius * radius * 3.14;
    }


}