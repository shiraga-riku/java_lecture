package jp.co.aivick.demo.service;

import java.util.List;
import jp.co.aivick.demo.dao.UserDao;
import jp.co.aivick.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserService implements UserService
{
    private UserDao userDao;

    @Autowired
    public DefaultUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findALl();
    }
}
