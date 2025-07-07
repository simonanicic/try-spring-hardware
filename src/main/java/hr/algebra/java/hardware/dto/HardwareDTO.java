package hr.algebra.java.hardware.dto;

import hr.algebra.java.hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String articleName;
    private String articleDescription;
    private BigDecimal articlePrice;
    private String categoryName;
}