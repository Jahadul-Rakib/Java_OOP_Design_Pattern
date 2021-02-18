
/*
 *  Cloning of an existing object instead of creating new one and can also be customized as per the requirement.
 *
 *  Prototype allows us to hide the complexity of making new instances from the client.
 *  The concept is to copy an existing object rather than creating a new instance from scratch,
 *  something that may include costly operations. The existing object acts as a prototype and
 *  contains the state of the object. The newly copied object may change same properties only if required.
 *  This approach saves costly resources and time, especially when the object creation is a heavy process.
 * */
package com.rakib.java_design_pattern.creational;

import java.util.HashMap;
import java.util.Map;

interface PrototypeCapable extends Cloneable {
    PrototypeCapable clone() throws CloneNotSupportedException;
}

class Movie implements PrototypeCapable {
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Movie clone() throws CloneNotSupportedException {
        System.out.println("Cloning Movie object..");
        return (Movie) super.clone();
    }

    @Override
    public String toString() {
        return "Movie";
    }
}

class Album implements PrototypeCapable {
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Album clone() throws CloneNotSupportedException {
        System.out.println("Cloning Album object..");
        return (Album) super.clone();
    }

    @Override
    public String toString() {
        return "Album";
    }
}

class Show implements PrototypeCapable {
    private String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Show clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object..");
        return (Show) super.clone();
    }

    @Override
    public String toString() {
        return "Show";
    }
}

class PrototypeFactory {
    private static final Map<String, PrototypeCapable> prototypes = new HashMap<String, PrototypeCapable>();

    public static class ModelType {
        public static final String MOVIE = "movie";
        public static final String ALBUM = "album";
        public static final String SHOW = "show";
        static {
            prototypes.put(ModelType.MOVIE, new Movie());
            prototypes.put(ModelType.ALBUM, new Album());
            prototypes.put(ModelType.SHOW, new Show());
        }
    }
    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s)).clone();
    }
}

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        try {
            String moviePrototype = PrototypeFactory.getInstance(PrototypeFactory.ModelType.MOVIE).toString();
            System.out.println(moviePrototype);

            String albumPrototype = PrototypeFactory.getInstance(PrototypeFactory.ModelType.ALBUM).toString();
            System.out.println(albumPrototype);

            String showPrototype = PrototypeFactory.getInstance(PrototypeFactory.ModelType.SHOW).toString();
            System.out.println(showPrototype);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
