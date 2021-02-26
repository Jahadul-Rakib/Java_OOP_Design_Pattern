package com.rakib.java_design_pattern.c_behavioral.template_method_design_pattern;


/*
 Template Method is a behavioral design pattern that allows you to defines a skeleton of an algorithm
 in a base class and let subclasses override the steps without changing the overall algorithm's structure.

Template means Preset format like HTML templates which has a fixed preset format.
Similarly in the template method pattern, we have a preset structure method called
template method which consists of steps. This steps can be an abstract method which
will be implemented by its subclasses.
*/
abstract class OrderProcessTemplate {
    public boolean isGift;

    public abstract void doSelect();

    public abstract void doPayment();

    public final void giftWrap() {
        try {
            System.out.println("Gift wrap successful");
        } catch (Exception e) {
            System.out.println("Gift wrap unsuccessful");
        }
    }

    public abstract void doDelivery();

    public final void processOrder(boolean isGift) {
        doSelect();
        doPayment();
        if (isGift) {
            giftWrap();
        }
        doDelivery();
    }
}


class NetOrder extends OrderProcessTemplate {
    @Override
    public void doSelect() {
        System.out.println("Item added to online shopping cart");
        System.out.println("Get gift wrap preference");
        System.out.println("Get delivery address.");
    }

    @Override
    public void doPayment() {
        System.out.println
                ("Online Payment through Netbanking, card or Paytm");
    }

    @Override
    public void doDelivery() {
        System.out.println
                ("Ship the item through post to delivery address");
    }

}

class StoreOrder extends OrderProcessTemplate {

    @Override
    public void doSelect() {
        System.out.println("Customer chooses the item from shelf.");
    }

    @Override
    public void doPayment() {
        System.out.println("Pays at counter through cash/POS");
    }

    @Override
    public void doDelivery() {
        System.out.println("Item delivered to in delivery counter.");
    }

}

public class TemplateMethod {
    public static void main(String[] args) {
        OrderProcessTemplate netOrder = new NetOrder();
        netOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
}
