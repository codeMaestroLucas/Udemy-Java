# Builders

Used to build the class with the given parameters.

```java
public class Product {

    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
}
```

# Overload

Methods with more than one signature - variables in the `()` when the function is called.

Ex.:

```java
public class Product {

    private String name;
    private double price;
    private int quantity;
    
    // Builder 01
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        // The std value to the quantity will be zero.
    }
    
    // Builder 02
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
}
```

OBS: Std Values

1. Strings ⇒ null;
2. Int & Double ⇒ 0;

# Access Modifiers

- **`public`:**
    - Visibility: everywhere on the package;
- **`protected`:**
    - Visibility: same package + subclasses;
- **default - no modifier:**
    - Visibility: only within the same package;
- **`private`:**
    - Visibility: within the same class;
    

| Modifier | Class | Package | Subclass (same package) | Subclass (different package) | Global (other packages) |
| --- | --- | --- | --- | --- | --- |
| public | Yes | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | Yes | No |
| default | Yes | Yes | Yes | No | No |
| private | Yes | No | No | No | No |
