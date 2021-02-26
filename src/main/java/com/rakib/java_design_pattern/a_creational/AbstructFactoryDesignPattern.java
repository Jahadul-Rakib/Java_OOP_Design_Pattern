/*
 *   Abstract Factory is a creational design pattern, which solves the problem of
 *   creating entire product families without specifying their concrete classes.
 *   Abstract Factory defines an interface for creating all distinct products but
 *   leaves the actual product creation to concrete factory classes.
 * */
package com.rakib.java_design_pattern.a_creational;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractFood {
    public abstract String getItemName();

    public abstract boolean isDelivered();

    public abstract int getQuantity();
}

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
class ChineseFood extends AbstractFood {
    String itemName;
    int quantity;
    boolean delivered;

    public ChineseFood(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
class ItalianFood extends AbstractFood {
    String itemName;
    int quantity;
    boolean delivered;

    public ItalianFood(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
class MexicanFood extends AbstractFood {
    String itemName;
    int quantity;
    boolean delivered;

    public MexicanFood(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }
}

abstract class AbstractFoodFactory {
    public abstract AbstractFood placeOrder(String itemName, int quantity);
}

class ItalianFoodFactory extends AbstractFoodFactory {
    @Override
    public AbstractFood placeOrder(String itemName, int quantity) {
        return new ItalianFood(itemName, quantity);
    }
}

class ChineseFoodFactory extends AbstractFoodFactory {
    @Override
    public AbstractFood placeOrder(String itemName, int quantity) {
        return new ChineseFood(itemName, quantity);
    }
}

class MexicanFoodFactory extends AbstractFoodFactory {
    @Override
    public AbstractFood placeOrder(String itemName, int quantity) {
        return new MexicanFood(itemName, quantity);
    }
}

class ConsumerClass {
    public AbstractFood placeOrder(String itemName, int quantity, String itemType) {
        AbstractFoodFactory a = null;
        switch (itemType) {
            case "italian":
                a = new ItalianFoodFactory();
                break;
            case "mexican":
                a = new MexicanFoodFactory();
                break;
            case "chinese":
                a = new ChineseFoodFactory();
                break;
        }
        if (a != null) {
            return a.placeOrder(itemName, quantity);
        } else {
            return null;
        }
    }
}

public class AbstructFactoryDesignPattern {

    public static void main(String[] args) {
        createOrder();
    }

    public static void createOrder() {
        ConsumerClass c = new ConsumerClass();
        List<AbstractFood> order = new ArrayList<AbstractFood>();
        order.add(c.placeOrder("Lazagne", 2, "italian"));
        order.add(c.placeOrder("Taco", 3, "mexican"));
        order.add(c.placeOrder("Noodles", 1, "chinese"));
        System.out.println(order);
    }
}
