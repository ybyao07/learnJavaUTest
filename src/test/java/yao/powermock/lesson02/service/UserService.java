package yao.powermock.lesson02.service;

import yao.powermock.common.User;
import yao.powermock.lesson02.dao.UserDao;

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
}
