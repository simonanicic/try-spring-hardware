package hr.algebra.java.hardware.service;

import hr.algebra.java.hardware.dto.HardwareDTO;
import hr.algebra.java.hardware.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServicelmpl implements HardwareService {

    private HardwareRepository HardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardwares() {
        return HardwareRepository.getAllHardwares().stream()
                .map(this :: convertHardware ToHardwareDTO)
                .toList();

    }

    @Override
    public List<HardwareDTO> getHardwaresByName(String HardwareName) {
        return HardwareRepository.getHardwaresByName(HardwareName).stream()
                .map(this :: convertHardware ToHardwareDTO)
                .toList();

    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware Hardware) {
        return new HardwareDTO(Hardware.getName(),
                Hardware.getDescription(), Hardware.getPrice(),
                Hardware.getCategory().getName());
    }
}