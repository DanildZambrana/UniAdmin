package us.siriusteam.uniadmin.database.sql.students;

import us.siriusteam.uniadmin.Models.User;
import us.siriusteam.uniadmin.database.DataBaseManager;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class StudentsManager implements DataBaseManager {
    @Override
    public void registerTable() {

    }

    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public List<User> selectAll() throws SQLException {
        return null;
    }

    @Override
    public User getUser(UUID uniqueId) throws SQLException {
        return null;
    }

    @Override
    public User getUser(String userName) throws SQLException {
        return null;
    }
}
