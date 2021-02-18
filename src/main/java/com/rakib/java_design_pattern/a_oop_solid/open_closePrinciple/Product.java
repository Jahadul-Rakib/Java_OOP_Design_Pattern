package com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple;

import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Color;
import com.rakib.java_design_pattern.a_oop_solid.open_closePrinciple.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private Color color;
    private Size size;
}
