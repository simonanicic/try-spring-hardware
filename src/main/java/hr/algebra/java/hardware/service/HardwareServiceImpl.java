package hr.algebra.java.hardware.service;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.dto.HardwareDTO;
import hr.algebra.java.hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardwares() {
        return hardwareRepository.getAllHardwares().stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();

    }

    @Override
    public List<HardwareDTO> getHardwaresByName(String HardwareName) {
        return hardwareRepository.getHardwaresByName(HardwareName).stream()
                .map(this::convertHardwareToHardwareDTO)
                .toList();

    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getName(),
                hardware.getDescription(), hardware.getPrice(),
                hardware.getCategory().getName());
    }
}