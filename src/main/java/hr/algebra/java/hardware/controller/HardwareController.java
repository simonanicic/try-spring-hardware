package hr.algebra.java.hardware.controller;

import hr.algebra.java.hardware.dto.HardwareDTO;
import hr.algebra.java.hardware.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public ResponseEntity<List<HardwareDTO>> getAllHardwares() {
        return ResponseEntity.ok(hardwareService.getAllHardwares().stream().toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardwareDTO> filterHardwareById(@PathVariable Long id) {
        return ResponseEntity.ok(hardwareService.getHardwareById(id));
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO) {
        Integer generatedId = hardwareService.saveNewHardware(hardwareDTO);
        return ResponseEntity.ok(generatedId);
    }

    @PutMapping("/hardware/{hardwareId}")
    public ResponseEntity<HardwareDTO> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            hardwareService.updateHardware(hardwareDTO, hardwareId);
            return ResponseEntity.ok(hardwareDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("hardware/{hardwareId}")
    public ResponseEntity<?> deleteHardwareById(@PathVariable Integer hardwareId) {
        if(hardwareService.hardwareByIdExists(hardwareId)) {
            boolean result = hardwareService.deleteHardwareById(hardwareId);
            if(result) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        return ResponseEntity.notFound().build();
    }
    
}