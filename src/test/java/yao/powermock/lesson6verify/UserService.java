package yao.powermock.lesson6verify;

import yao.powermock.common.User;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/

public class UserService {

    public void saveOrUpdate(User user){
        UserDao userDao = new UserDao();
        if (userDao.getCount(user) > 0){
            userDao.update(user);
        }else {
            userDao.insert(user);
        }
    }
}
