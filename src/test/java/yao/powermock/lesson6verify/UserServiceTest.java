package yao.powermock.lesson6verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import yao.powermock.common.User;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void testSaveOrUpdateUserWithJoin() throws Exception{
        User user = PowerMockito.mock(User.class);
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.getCount(user)).thenReturn(0);
        UserService userService = new UserService();
        userService.saveOrUpdate(user);

        Mockito.verify(userDao).insert(user);
        Mockito.verify(userDao, Mockito.never()).update(user);
    }
}
