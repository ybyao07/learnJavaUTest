package yao.powermock.lesson4static.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import yao.powermock.common.User;
import yao.powermock.lesson4static.dao.UserDao;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {
       mockStatic(UserDao.class);
       when(UserDao.getCount()).thenReturn(10);
       UserService service = new UserService();
       int result = service.queryUserCount();
       assertEquals(10, result);
    }

    @Test
    public void saveUser() {
        mockStatic(UserDao.class);
        doNothing().when(UserDao.class);
        User user = new User();
        UserService service = new UserService();
        service.saveUser(user);
//        verifyStatic(Mockito.times(1));

    }
}