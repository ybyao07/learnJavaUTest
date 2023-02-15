package yao.powermock.lesson5final;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import yao.powermock.lesson5final.dao.UserDao;
import yao.powermock.lesson5final.service.UserService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {
    @Mock
    UserDao userDao;

//    @Ignore
    @Test
    public void testQueryUserCountWithMockito() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(userDao.getCount()).thenReturn(10);
        UserService userService = new UserService(userDao);
        int result = userService.queryUserCount();
        assertThat(10, equalTo(result));
    }

    @Test
    public void testQueryUserCountWithPowerMock() throws Exception {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService userService = new UserService(uDao);
        int result = userService.queryUserCount();
        assertThat(10, equalTo(result));
    }
}
