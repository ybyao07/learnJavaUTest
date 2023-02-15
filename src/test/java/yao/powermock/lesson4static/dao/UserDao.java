package yao.powermock.lesson4static.dao;

import yao.powermock.common.User;

/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/

public class UserDao {
    public static int getCount(){
        throw new UnsupportedOperationException();
    }
    public static void insertUser(User user){
        throw new UnsupportedOperationException();
    }
}
