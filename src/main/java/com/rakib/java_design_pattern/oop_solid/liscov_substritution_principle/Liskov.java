package com.rakib.java_design_pattern.oop_solid.liscov_substritution_principle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

enum VehicalType {
    HEAVY, LIGHT, MEDIUM
}

@Data
@NoArgsConstructor
class Vehical {
    private String modelName;
    private String price;
    private VehicalType vehicleType;

    public Vehical(String modelName, String price, VehicalType vehicleType) {
        this.modelName = modelName;
        this.price = price;
        this.vehicleType = vehicleType;
    }
}
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
class Truck extends Vehical{
    private String engine;
    private String gear;

    public Truck(String modelName, String price, VehicalType vehicleType, String engine, String gear) {
        super(modelName, price, vehicleType);
        this.engine = engine;
        this.gear = gear;
    }

}

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
class Texi extends Vehical{
    private String color;
    private String passangerCapacity;

    public Texi(String modelName, String price, VehicalType vehicleType, String color, String passangerCapacity) {
        super(modelName, price, vehicleType);
        this.color = color;
        this.passangerCapacity = passangerCapacity;
    }

}

// Basically Liscov reflect in Java like inheritence (divade the class into small)
public class Liskov {

    public static void main(String[] args) {

    }
}
