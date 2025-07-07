package hr.algebra.java.hardware.repository;

import hr.algebra.java.hardware.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardwares();
    Hardware getHardwareByName(String name);
}
