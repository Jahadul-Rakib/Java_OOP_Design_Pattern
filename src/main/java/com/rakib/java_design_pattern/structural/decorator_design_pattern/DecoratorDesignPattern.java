//Decorator pattern allows a user to add new functionality to an existing object without altering its structure.

/*The decorator design pattern allows us to dynamically add functionality and behavior to an object without affecting
the behavior of other existing objects in the same class.*/

package com.rakib.java_design_pattern.structural.decorator_design_pattern;

interface Message {
    String getContent();
}

class TextMessage implements Message {
    String message;

    public TextMessage(String message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message;
    }
}

//Applying Decorator
class HTMLEncodedMessage implements Message {
    //this is decorator
    Message message;

    public HTMLEncodedMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent() + " : From HTML Encoder";
    }
}

//Applying Decorator
class Base64EncodedMessage implements Message {
    //this is decorator
    Message message;

    public Base64EncodedMessage(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent() + " : From Base64 Encoder";
    }
}

public class DecoratorDesignPattern {
    public static void main(String[] args) {
        Message message = new TextMessage("Hello");
        System.out.println(message.getContent());

        Message message1 = new HTMLEncodedMessage(message);
        System.out.println(message1.getContent());

        Message message2 = new Base64EncodedMessage(message);
        System.out.println(message2.getContent());
    }
}
