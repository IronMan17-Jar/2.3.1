package testgroup.filmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.dao.UserDAO;
import testgroup.filmography.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    //@Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Override
   // @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    //@Transactional
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Override
    //@Transactional
    public void update(User user, int id) {
        userDAO.update(user, id);
    }

    @Override
    //@Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
