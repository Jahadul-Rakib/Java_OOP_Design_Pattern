/*

Mediator pattern is used to reduce communication complexity between multiple objects or classes.
This pattern provides a mediator class which normally handles all the communications between different
classes and supports easy maintenance of the code by loose coupling.

*/

package com.rakib.java_design_pattern.behavioral.mediator_design_pattern;

import lombok.Data;

import java.util.Date;

class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "] : " + message);
    }
}

@Data
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }
    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}

public class MediatorDesignPattern {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
