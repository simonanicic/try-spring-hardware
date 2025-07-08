package hr.algebra.java.hardware.repository;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.domain.HardwareType;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static List<Hardware> hardwareList;

    static {
        hardwareList = new ArrayList<>();

        Hardware firstHardware = new Hardware(1L, "123", "CPU", 250.0, HardwareType.CPU, 5);
        Hardware secondHardware = new Hardware(2L, "143", "RAM", 250.0, HardwareType.RAM, 8);

        hardwareList.add(firstHardware);
        hardwareList.add(secondHardware);
    }
        @Override
        public List<Hardware> getAllHardwares() {
            return hardwareList;
        }

        @Override
        public Hardware getHardwareById(Long id) {
            return hardwareList.stream()
                    .filter(a -> a.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Hardware not found with id: " + id));
        }

}