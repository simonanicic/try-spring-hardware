import hr.algebra.java.hardware.domain.Category;
import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.repository.HardwareRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HardwareRepositoryImpl implements HardwareRepository {

    private static List<Hardware> HardwareList;

    static {
        HardwareList = new ArrayList<>();

        Hardware firstHardware = new Hardware(1, "Tesla Model Y", "Electric car", new BigDecimal(50000), Category.CARS);
        Hardware secondHardware = new Hardware(2, "Apartment on the main square", "Luxury apartment", new BigDecimal(500000),
                Category.PROPERTIES);
        Hardware thirdHardware = new Hardware(3, "House on the beach", "Vacation house", new BigDecimal(5000000), Category.PROPERTIES);
        Hardware fourthHardware = new Hardware(4, "Oldtimer Mercedes X 1800", "Vintage car", new BigDecimal(100000), Category.CARS);

        HardwareList.add(firstHardware);
        HardwareList.add(secondHardware);
        HardwareList.add(thirdHardware);
        HardwareList.add(fourthHardware);
    }
        @Override
        public List<Hardware> getAllHardwares() {
            return HardwareList;
        }

        @Override
        public List<Hardware> getHardwaresByName(String HardwareName) {
            return HardwareList.stream()
                    .filter(a -> a.getName().toLowerCase().contains(HardwareName.toLowerCase()))
                    .collect(Collectors.toList());

        }

}