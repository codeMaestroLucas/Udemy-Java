# Reference Types

**Pointer** to the actual value stored in the memory.

Reference Types: Classes, arrays.

- Run time objects are stored in the Heap memory
    
    *Store the memory address for the real object in the Stack memory.*
    

![img](./src/imgs/reference.png)

# Value Types

Store the actual value in the Stack Memory.

Value Types: primitive types.

---

![img](./src/imgs/comparison.png)

---

# Boxing

Process of converting a value type object to a compatible reference type.


![img](./src/imgs/boxing.png)

**OBS**: All classes, by default, are descendants of the `Object` class.

# Unboxing

![img](./src/imgs/unboxing.png)

Process of converting a reference type object to a compatible value type.

# Wrapper Classes

![img](./src/imgs/wrapper_classes.png)

Used to perform Boxing and Unboxing properly.

<aside>
📌 A common use of Wrapper Classes:

**Entities in Information Systems.**

Reference types (classes) can accept null values and benefit from OO features (inheritance, polymorphism…).

In other words, it's time to start using **Wrapper Classes**.

![img](./src/imgs/example.png)

</aside>

---

# Lists