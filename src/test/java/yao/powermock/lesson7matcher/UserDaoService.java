package yao.powermock.lesson7matcher;

import org.powermock.api.mockito.PowerMockito;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/

public class UserDaoService {
    public String find(String name){
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);

    }
}
