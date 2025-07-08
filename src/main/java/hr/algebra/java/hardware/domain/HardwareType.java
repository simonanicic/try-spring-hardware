package hr.algebra.java.hardware.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HardwareType {
    CPU("CPU"),
    GPU("GPU"),
    MBO("Motherboard"),
    RAM("RAM"),
    STORAGE("Storage"),
    OTHER("Other");

    private final String naziv;
}
