package coaching.repository;

import coaching.model.Staff;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:" + UUID.randomUUID().toString());   // In-memory database
        config.setDriverClassName("org.h2.Driver");                         // H2 driver
        config.setUsername("root");
        config.setPassword("root");

        HikariDataSource dataSource = new HikariDataSource(config);

        // Create staff table
        try (final Connection connection = dataSource.getConnection();
             final Statement statement = connection.createStatement()) {

            final File staffTable = new File(classLoader.getResource("staff-table.sql").getFile());

            BufferedReader br = new BufferedReader(new FileReader(staffTable));

            StringBuilder tableSQL = new StringBuilder("");
            String line;
            while ((line = br.readLine()) != null) {
                tableSQL.append(line + "\n");
            }

            statement.execute(tableSQL.toString());

        } catch (Exception ex) {
            System.out.println("Error !!!");
        }

        CrudRepository<Staff> repo = new StaffRepository(new HikariDataSource(config));

        Staff staff = new Staff();

        repo.save(Arrays.asList(staff));

        System.out.println(staff.getId());

        List<Staff> data = (List<Staff>) repo.findAll();


        for (Staff aStaff : data) {
            System.out.println(aStaff.toString());;
        }

    }
}
