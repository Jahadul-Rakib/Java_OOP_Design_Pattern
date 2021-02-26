//  Adapter design pattern is a structural design pattern that allows two unrelated/uncommon interfaces to work together.
//  An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly.
package com.rakib.java_design_pattern.b_structural.adapter_design_pattern;

interface Bird {
    public void fly();
    public void makeSound();
}
interface ToyDuck {
    public void squeak();
}

class Sparrow implements Bird {
    public void fly() {
        System.out.println("Flying");
    }
    public void makeSound() {
        System.out.println("Chirp Chirp");
    }
}
class PlasticToyDuck implements ToyDuck {
    public void squeak() {
        System.out.println("Squeak");
    }
}

class BirdAdapter implements ToyDuck {
    // You need to implement the interface your
    // client expects to use.
    Bird bird;
    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    public void squeak() {
        bird.makeSound();
    }
}

public class AdepterDesignPattern {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
