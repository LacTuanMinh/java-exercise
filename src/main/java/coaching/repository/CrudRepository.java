package coaching.repository;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Generic CRUD repository
 */
public interface CrudRepository<T> {

    /**
     * Save data into persistence storage
     *
     * @param data Data
     */
    void save(Collection<T> data) throws SQLException;

    /**
     * Get all data existing in storage
     *
     * @return Data
     */
    Collection<T> findAll();

    void get() throws SQLException;
}
