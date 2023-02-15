package yao.powermock.lesson3local;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import yao.powermock.lesson3local.dao.UserDao;
import yao.powermock.lesson3local.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {
    @Test
    public void testQueryUserCount() {
        try {
            UserDao userDao = PowerMockito.mock(UserDao.class);
//            UserDao userDao = new UserDao();
            PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            PowerMockito.when(userDao.getCount()).thenReturn(10);
            UserService service = new UserService();
            int result = service.queryUserCount();
            assertEquals(20, result);
        }catch (Throwable e){
            fail();
        }
    }
}
