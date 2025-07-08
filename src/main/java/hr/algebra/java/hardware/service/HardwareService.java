package hr.algebra.java.hardware.service;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardwares();

    HardwareDTO getHardwareById(Long id);

    Integer saveNewHardware(HardwareDTO hardwareDTO);

    Boolean hardwareByIdExists (Integer hardwareId);

    Hardware updateHardware (HardwareDTO hardwareDTO, Integer id);

    Boolean deleteHardwareById (Integer hardwareId);
}