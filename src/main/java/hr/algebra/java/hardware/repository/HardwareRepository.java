package hr.algebra.java.hardware.repository;

import hr.algebra.java.hardware.domain.Hardware;

import java.util.List;

public interface HardwareRepository {
    List<Hardware> getAllHardwares();
    Hardware getHardwareById(Long id);
    Integer saveNewHardware(Hardware hardware);
    Boolean hardwareByIdExists (Long id);
    Hardware updateHardware (Hardware hardware, Long id);
    Boolean deleteHardwareById (Long id);
}
