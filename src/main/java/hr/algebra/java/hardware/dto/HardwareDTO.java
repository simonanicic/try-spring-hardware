package hr.algebra.java.hardware.dto;

import hr.algebra.java.hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String naziv;
    private double cijena;
    private HardwareType tip;
    private int kolicinaNaStanju;
}
