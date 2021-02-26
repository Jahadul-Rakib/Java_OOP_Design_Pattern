
// Singleton Pattern always return a single object
// Ensure No other object exist of the specific class on JVM

package com.rakib.java_design_pattern.a_creational;

import java.util.Objects;

// regular singleton
class EagerSingleton {
    public EagerSingleton() {
    }
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }
}
// Lazy singleton
class LazySingleton{
    public LazySingleton() {
    }
    private static volatile LazySingleton INSTANCE;
    public static LazySingleton getInstance(){
        if (Objects.isNull(INSTANCE)){
            synchronized (LazySingleton.class){
                if (Objects.isNull(INSTANCE)){
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}

public class SingletonDesignPattern {
    public static void main(String[] args) {
        EagerSingleton registry0 = EagerSingleton.getInstance();
        EagerSingleton registry1 = EagerSingleton.getInstance();
        if (registry0 == registry1) System.out.println("T1");

        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        if (singleton1 == singleton2) System.out.println("T2");
    }
}
