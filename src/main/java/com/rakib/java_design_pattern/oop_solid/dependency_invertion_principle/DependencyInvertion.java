package com.rakib.java_design_pattern.oop_solid.dependency_invertion_principle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Person{
    private String name;
    private int Age;
}
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class RelationShip{
    private String nameOfRelation;
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class JoinRelation<P, R, P1> {
    //in here dependency inversion is coming
    private Person relationFrom;
    private RelationShip relationShip;
    private Person relationTo;
}

public class DependencyInvertion {
    public static void main(String[] args) {

        List<JoinRelation<Object, Object, Object>> relationList = new ArrayList<>();

        final Person rakib0 = Person.builder().name("Rakib0").Age(30).build();
        final Person rakib1 = Person.builder().name("Rakib1").Age(30).build();
        final Person rakib2 = Person.builder().name("Rakib2").Age(30).build();
        final Person rakib3 = Person.builder().name("Rakib3").Age(30).build();
        final Person rakib4 = Person.builder().name("Rakib4").Age(30).build();

        final RelationShip son = RelationShip.builder().nameOfRelation("Son").build();
        final RelationShip father = RelationShip.builder().nameOfRelation("Father").build();

        final JoinRelation<Object, Object, Object> build = JoinRelation.builder().relationTo(rakib0).relationFrom(rakib1).relationShip(father).build();
        final JoinRelation<Object, Object, Object> build1 = JoinRelation.builder().relationTo(rakib3).relationFrom(rakib4).relationShip(son).build();

        relationList.add(build);
        relationList.add(build1);

        System.out.println(relationList);

        /*
        * Always Low level dependency depend on High Level abstruction.
        * service and serviceImpl is the good example.
        * */
    }
}
