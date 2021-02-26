package com.rakib.java_design_pattern.c_behavioral.state_design_pattern;
/*

 The state pattern in Java is a behavioural software design pattern that allows
 an object to alter its behaviour when its internal state changes.
 The state design pattern is generally used in cases where an object depends on
 its state and its behavior must be changed during run time depending on its internal state.

*/

interface MobileAlertState {
    public void alert(AlertStateContext ctx);
}

class AlertStateContext {
    private MobileAlertState currentState;

    public AlertStateContext() {
        currentState = new Vibration();
    }

    public void setState(MobileAlertState state) {
        currentState = state;
    }

    public void alert() {
        currentState.alert(this);
    }
}

class Vibration implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("vibration...");
    }

}

class Silent implements MobileAlertState {
    @Override
    public void alert(AlertStateContext ctx) {
        System.out.println("silent...");
    }

}

public class StateDesignPattern {
    public static void main(String[] args) {
        AlertStateContext stateContext = new AlertStateContext();
        stateContext.alert();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }
}
