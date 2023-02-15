package yao.powermock.lesson6verify;

import yao.powermock.common.User;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/

public class UserDao {
    public int getCount(User user){
        throw new UnsupportedOperationException();
    }
    public void insert(User user){
        throw new UnsupportedOperationException();
    }

    public void update(User user){
        throw new UnsupportedOperationException();
    }
}
