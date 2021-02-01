package coaching.repository;

import coaching.model.Staff;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {

        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:staff");   // In-memory database
        config.setDriverClassName("org.h2.Driver");                         // H2 driver
        config.setUsername("root");
        config.setPassword("root");
        CrudRepository repo = new StaffRepository(new HikariDataSource(config));

        Staff staff = new Staff();

        repo.save(Arrays.asList(staff));

    }
}
