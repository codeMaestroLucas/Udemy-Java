# Conditions

```java
    public static void determinateQuadrant(double x, double y) {
        if (x == 0 && y == 0) {
            System.out.println("Origin");
        } else if (x == 0) {
            System.out.println("Y-axis");
        } else if (y == 0) {
            System.out.println("X-axis");
        } else if (x > 0) {
        
        // Ternary condition
            **System.out.println(y > 0 ? "Q1" : "Q4");**
        } else if (x < 0) {
            **System.out.println(y > 0 ? "Q2" : "Q3");**
        }
    }
```

# Switch-Case

OBS: All the Cases in the Switch need to have a `break` operator.

```java
        int value = sc.nextInt();
        String weekDay;

        switch (value) {
            case 1:
                weekDay = "Sunday";
                break;

            case 2:
                weekDay = "Monday";
                break;

            case 3:
                weekDay = "Tuesday";
                break;

            case 4:
                weekDay = "Wednesday";
                break;

            case 5:
                weekDay = "Thursday";
                break;

            case 6:
                weekDay = "Friday";
                break;

            case 7:
                weekDay = "Saturday";
                break;
        
            default:   // An else value
                weekDay = "Invalid day";
                break;
        }
```

# Ternary Conditional Expression

Syntax: `( condition ) ? valueTrue : valueFalse;`

```java
        int number = (2 > 4) ? 20 : 40;
        //                If True : False
        String name = (10 != 3) ? "Mary" : "Jhon";

        System.out.println(number);
        System.out.println(name);
```