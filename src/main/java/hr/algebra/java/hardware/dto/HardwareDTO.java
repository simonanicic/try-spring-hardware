package hr.algebra.java.hardware.dto;

import hr.algebra.java.hardware.domain.HardwareType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {

    @NotBlank(message = "Naziv hardwarea je obavezan!")
    private String hardwareNaziv;
    @NotBlank(message = "Šifra hardwarea je obavezna!")
    private String hardwareSifra;
    @PositiveOrZero(message = "Cijena mora biti 0 ili veca!")
    private double hardwareCijena;
    @NotNull(message = "Tip hardwarea je obavezan!")
    private HardwareType hardwareTip;
    @PositiveOrZero(message = "Kolicina na stanju mora biti 0 ili veca!")
    private int hardwareKolicinaNaStanju;
}