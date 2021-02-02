package coaching.repository;

import coaching.model.Staff;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
            throw new IllegalArgumentException("Data can not be null.");
        }

        String sql = "Insert into staff (firstName, middleName, lastName, dob, gender, phone, address) values (?,?,?,?,?,?,?)";

        Connection connection = dataSource.getConnection();

        for (Staff staff : data) {

            PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, staff.getFirstName());
            st.setString(2, staff.getMiddleName());
            st.setString(3, staff.getLastName());
            st.setObject(4, staff.getDob());
            st.setBoolean(5, staff.getGender());
            st.setString(6, staff.getPhone());
            st.setString(7, null);
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                staff.setId(rs.getInt(1));
            }

            st.close();
        }

        connection.close();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public Collection<Staff> findAll() throws SQLException {

        List<Staff> data = new ArrayList<>();

        Connection connection = dataSource.getConnection();

        Statement st = connection.createStatement();

        String sql = "select * from staff";

        ResultSet rs = st.executeQuery(sql);


        while (rs.next()) {
            Staff staff = new Staff();
            staff.setId(rs.getInt("id"));
            staff.setGender(rs.getBoolean("gender"));
            staff.setAddress(rs.getString("address"));
            staff.setDob((LocalDateTime) rs.getObject("dob"));

            staff.setFirstName(rs.getString("firstName"));
            staff.setLastName(rs.getString("lastName"));

            staff.setMiddleName(rs.getString("middleName"));
            staff.setPhone(rs.getString("phone"));

            data.add(staff);

        }

        return  data;
    }

}
