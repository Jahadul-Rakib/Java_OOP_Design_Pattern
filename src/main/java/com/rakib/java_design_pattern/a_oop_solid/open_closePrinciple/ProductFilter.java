package com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple;

import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Color;
import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Size;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(product -> product.getColor().equals(color));
    }
    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(product -> product.getSize().equals(size));
    }
    public Stream<Product> filterByColorAndSize(List<Product> products, Color color, Size size){
        return products.stream().filter(product -> product.getColor().equals(color) && product.getSize().equals(size));
    }
}
