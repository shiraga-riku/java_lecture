package jp.co.aivick.demo.service;

import java.util.List;
import jp.co.aivick.demo.dao.UserDao;
import jp.co.aivick.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{
    @Autowired
    private UserDao userDao;

    public User findBy(String id) {
        return userDao.find(id);
    }

    public List<User> findAll() {
        return this.userDao.findALl();
    }

    @Transactional
    public User create(User user) {
        userDao.insert(user);
        return user;
    }

    @Transactional
    public User update(User user) {
        userDao.update(user);
        return user;
    }
}
