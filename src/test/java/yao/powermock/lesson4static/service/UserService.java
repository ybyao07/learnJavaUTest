package yao.powermock.lesson4static.service;

import yao.powermock.common.User;
import yao.powermock.lesson4static.dao.UserDao;

/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/

public class UserService {

    public int queryUserCount(){
        return UserDao.getCount();
    }

    public void saveUser(User user){
        UserDao.insertUser(user);
    }
}
