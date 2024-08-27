package j_InheritanceAndPolymorphism.Exercises.Ex03.entities;

import j_InheritanceAndPolymorphism.Exercises.Ex03.entities.enums.Color;

public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract Double area();
    
}
