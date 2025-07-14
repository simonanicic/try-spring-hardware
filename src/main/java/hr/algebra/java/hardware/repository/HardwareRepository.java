package hr.algebra.java.hardware.repository;

import hr.algebra.java.hardware.domain.Hardware;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {
    List<Hardware> getAllHardwares();
    Optional<Hardware> getHardwareById(Long id);
    Integer saveNewHardware(Hardware hardware);
    Boolean hardwareByIdExists (Long id);
    Optional<Hardware> updateHardware (Hardware hardware, Long id);
    Boolean deleteHardwareById (Long id);
}
