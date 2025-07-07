package hr.algebra.java.hardware.controller;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.dto.HardwareDTO;
import hr.algebra.java.hardware.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/web-shop")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardwares() {
        return hardwareService.getAllHardwares().stream().toList();
    }

    @GetMapping("/{hardwareName}")
    public List<HardwareDTO> filterHardwaresByName(@PathVariable String hardwareName) {
        return hardwareService.getHardwaresByName(hardwareName).stream().toList();

    }
    
}