package testgroup.crud.service;

import testgroup.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void save(User user);

    void delete(User user);

    void update(User user, int id);

    User getById(int id);
}
