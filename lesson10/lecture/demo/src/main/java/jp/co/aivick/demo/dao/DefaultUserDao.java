package jp.co.aivick.demo.dao;

import java.util.List;
import jp.co.aivick.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DefaultUserDao implements UserDao
{
    @Override
    public List<User> findALl() {
        return List.of(
            new User("taro", 25),
            new User("hanako", 30),
            new User("ichiro", 40),
            new User("jon", 28),
            new User("takeru", 35)
        );
    }
}
