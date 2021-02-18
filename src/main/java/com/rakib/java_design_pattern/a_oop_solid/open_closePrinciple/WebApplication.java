package com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple;

import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Color;
import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Stream;

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> listOfItem, Specification<T> specification);
}

class ColorSpecification implements Specification<Product> {
    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getColor() == color;
    }
}

class SizeSpecification implements Specification<Product> {
    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.getSize() == size;
    }
}

class ColorAndSizeSpecification<T> implements Specification<T> {
    private Specification<T> first, second;

    public ColorAndSizeSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> listOfItem, Specification<Product> specification) {
        return listOfItem.stream().filter(specification::isSatisfied);
    }
}

@Slf4j
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);


        Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
        Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
        Product house = new Product("House", Color.BLUE, Size.LARGE);
        Product car = new Product("Car", Color.RED, Size.MEDIUM);

        List<Product> productList = List.of(apple, tree, house, car);

        //Traditional Way ------------------------------------------------------------------
        ProductFilter productFilter = new ProductFilter();
        productFilter.filterByColor(productList, Color.GREEN).forEach(System.out::println);


        //Followed By OC principle --------------------------------------------------------
        BetterFilter betterFilter = new BetterFilter();

        betterFilter.filter(productList, new ColorSpecification(Color.GREEN)).forEach(System.out::println);

        betterFilter.filter(productList, new SizeSpecification(Size.SMALL)).forEach(System.out::println);

        betterFilter.filter(productList, new ColorAndSizeSpecification<>(
                new ColorSpecification(Color.GREEN),
                new SizeSpecification(Size.SMALL)
        )).forEach(System.out::println);


    }

}
