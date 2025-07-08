package hr.algebra.java.hardware.dto;

import hr.algebra.java.hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String hardwareNaziv;
    private String hardwareSifra;
    private double hardwareCijena;
    private HardwareType hardwareTip;
    private int hardwareKolicinaNaStanju;
}