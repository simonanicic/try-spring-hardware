package hr.algebra.java.hardware.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private Long id;
    private String name;
    private double description;
    private BigDecimal price;
    private Category category;
}