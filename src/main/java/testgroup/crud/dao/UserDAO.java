package testgroup.crud.dao;

import testgroup.crud.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void save(User user);

    void delete(User user);

    void update(User user, int id);

    User getById(int id);
}
