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
    public HardwareDTO getHardwareById(Long id) {
        Hardware hardware = hardwareRepository.getHardwareById(id);
        if (hardware == null) {
            throw new RuntimeException("Hardware not found with id: " + id);
        }
        return convertHardwareToHardwareDTO(hardware);
    }

    @Override
    public Integer saveNewHardware (HardwareDTO hardwareDTO) {
        return hardwareRepository.saveNewHardware(convertHardwareDTOToHardware(hardwareDTO));
    }

    @Override
    public Boolean hardwareByIdExists (Integer hardwareId) {
        return hardwareRepository.hardwareByIdExists(hardwareId.longValue());
    }

    @Override
    public Hardware updateHardware (HardwareDTO hardwareDTO, Integer id) {
        return hardwareRepository.updateHardware(convertHardwareDTOToHardware(hardwareDTO),id.longValue());
    }

    @Override
    public Boolean deleteHardwareById (Integer hardwareId) {
        return hardwareRepository.deleteHardwareById(hardwareId.longValue());
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getNaziv(),
                hardware.getSifra(),
                hardware.getCijena(),
                hardware.getTip(), hardware.getKolicinaNaStanju());
    }
    private Hardware convertHardwareDTOToHardware(HardwareDTO hardwareDTO) {
        return new Hardware(-1L,hardwareDTO.getHardwareNaziv(),
                hardwareDTO.getHardwareSifra(),
                hardwareDTO.getHardwareCijena(),
                hardwareDTO.getHardwareTip(), hardwareDTO.getHardwareKolicinaNaStanju());
    }
}