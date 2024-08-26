# Enumeration

Normally used to determinate the status of some class.

```java
package entities.enums; // Commonlly is created a Package on ENUM's

public enum OrderStatus {
    
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;

}
```

- Scanner to a Enum:
    
    ```java
    OrderStatus.valueOf(sc.next().**toUpperCase()**.trim())
    ```
    

---

# Design

1. **Views:** interfaces and data presentation;
    
    *Ex.: GUI, HTML, Web Sites, Desktop applications.*
    
2. **Controllers:** act as intermediaries between the View and other Layers. Invoke the necessary business logic and return the appropriate response or view;
    
    *Ex.: “When that button in clicked…”*
    
3. **Entities:** represent the core data structures used in the app;
4. **Services:** contains the business logic of the application, with the core functionalities;
    
    *Ex.: Processing orders, Managing users, calculating statistics…*
    
5. **Repositories:** access the data, interact with the database.
    
    *Ex.:  CRUD methods.*
    