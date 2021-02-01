package coaching.repository;

import coaching.model.Staff;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

/**
 * Staff repository
 */
@Repository
public class StaffRepository implements CrudRepository<Staff> {

    DataSource dataSource;

    /**
     * Initialize
     *
     * @param dataSource Data source
     */
    public StaffRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * {@inheritDoc}
     *
     * @param data Data
     */
    @Override
    public void save(Collection<Staff> data) throws SQLException {

        if (data == null) {
            throw new IllegalArgumentException("Data is null.");
        }

        Connection connection = dataSource.getConnection();

        Statement st = connection.createStatement();

        String sql = "Insert into staff values (1,null,null,null,null,null,null,null)" ;

        int m = st.executeUpdate(sql);

        System.out.println(m);

    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Staff> findAll() {
        throw new UnsupportedOperationException("This method is not implemented yet");
    }

    @Override
    public void get() throws SQLException {
        Connection connection = dataSource.getConnection();

        Statement st = connection.createStatement();

        String sql = "select * from staff" ;

        ResultSet rs  = st.executeQuery(sql);


        while(rs.next()) {
            int id = rs.getInt(0);
            System.out.println(id);
        }
    }
}
