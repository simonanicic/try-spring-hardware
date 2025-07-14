package hr.algebra.java.hardware.repository;

import hr.algebra.java.hardware.domain.Hardware;
import hr.algebra.java.hardware.domain.HardwareType;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
@AllArgsConstructor
public class JDBCHardwareRespository implements HardwareRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Hardware> getAllHardwares() {
      return jdbcTemplate.query("SELECT * FROM hardware", new HardwareMapper());
    };
    @Override
    public Optional<Hardware> getHardwareById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT * FROM hardware WHERE ID = ?", new HardwareMapper(), id));
    };
    @Override
    public Integer saveNewHardware(Hardware hardware) {
        return jdbcTemplate.update(
                "INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju) VALUES (?, ?, ?, ?, ?)",
                hardware.getSifra(),
                hardware.getNaziv(),
                hardware.getCijena(),
                hardware.getTip().name(), // Store enum as String
                hardware.getKolicinaNaStanju()
        );
    };
    @Override
    public Boolean hardwareByIdExists (Long id) {
        Long count = jdbcTemplate.queryForObject("SELECT COUNT (*) FROM hardware WHERE ID = ?", Long.class, id);
        return count > 0;
    };
    @Override
    public Optional<Hardware> updateHardware (Hardware hardware, Long id) {
        final String query = "UPDATE hardware SET sifra = ?, naziv = ?, cijena = ?, tip = ?, kolicina_na_stanju = ? WHERE ID = ?";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,hardware.getSifra());
            ps.setString(2,hardware.getNaziv());
            ps.setDouble(3,hardware.getCijena());
            ps.setObject(4,hardware.getTip());
            ps.setInt(5,hardware.getKolicinaNaStanju());
            ps.setLong(6,hardware.getId());
            return ps;
        });
        hardware.setId(id);
        return Optional.of(hardware);
    };
    @Override
    public Boolean deleteHardwareById (Long id) {
        if(hardwareByIdExists(id)) {
            jdbcTemplate.update("DELETE FROM hardware WHERE ID = ?",id);
            return true;
        } else {
            return false;
        }
    };

    private static class HardwareMapper implements RowMapper<Hardware> {
        @Override
        public Hardware mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hardware hardware = new Hardware();
            hardware.setId(rs.getLong("id"));
            hardware.setSifra(rs.getString("sifra"));
            hardware.setNaziv(rs.getString("naziv"));
            hardware.setCijena(rs.getDouble("cijena"));
            hardware.setTip(HardwareType.valueOf(rs.getString("tip")));
            hardware.setKolicinaNaStanju(rs.getInt("kolicina_na_stanju"));
        return hardware;
        }
    }
}
