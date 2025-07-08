package hr.algebra.java.hardware.service;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.domain.HardwareType;
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
    public HardwareDTO getHardwareById(Long id) {
        Hardware hardware = hardwareRepository.getHardwareById(id);
        if (hardware == null) {
            throw new RuntimeException("Hardware not found with id: " + id);
        }
        return convertHardwareToHardwareDTO(hardware);
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getNaziv(),
                hardware.getSifra(),
                hardware.getCijena(),
                hardware.getTip(), hardware.getKolicinaNaStanju());
    }
}