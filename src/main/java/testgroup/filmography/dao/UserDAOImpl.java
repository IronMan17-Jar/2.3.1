package testgroup.filmography.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.filmography.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        List<User> resultList = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        return resultList;
    }

    @Transactional
    @Override
    public void save(User user) {
        User merge = entityManager.merge(user);
        entityManager.persist(merge);
    }

    @Transactional
    @Override
    public void delete(User user) {
        User merge = entityManager.find(User.class, user.getId());
        entityManager.remove(merge);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        User updatedUser = getById(id);
        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        entityManager.merge(updatedUser);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }
}
