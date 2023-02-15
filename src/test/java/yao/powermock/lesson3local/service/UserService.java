package yao.powermock.lesson3local.service;

import yao.powermock.common.User;
import yao.powermock.lesson3local.dao.UserDao;

/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/

public class UserService {
    public int queryUserCount(){
        UserDao userDao = new UserDao();
        int remainCnt = 10; //虚拟额外的逻辑
        return userDao.getCount() + remainCnt;
    }

    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}
