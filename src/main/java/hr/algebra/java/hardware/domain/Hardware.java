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
    private String sifra;
    private String naziv;
    private double cijena;
    private HardwareType tip;
    private int kolicinaNaStanju;
}