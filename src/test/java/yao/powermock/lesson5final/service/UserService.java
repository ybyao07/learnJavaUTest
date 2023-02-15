package yao.powermock.lesson5final.service;

import org.junit.Test;
import yao.powermock.common.User;
import yao.powermock.lesson5final.dao.UserDao;

/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public int queryUserCount(){
        return userDao.getCount();
    }

    public void saveUser(User user){
        userDao.insertUser(user);
    }

    @Test
    public void name() {
    }
}
