package hr.algebra.java.hardware.service;

import hr.algebra.java.hardware.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {
    List<HardwareDTO> getAllHardwares();

    HardwareDTO getHardwareById(Long id);
}