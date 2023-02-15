package yao.powermock.lesson02;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import yao.powermock.common.User;
import yao.powermock.lesson02.dao.UserDao;
import yao.powermock.lesson02.service.UserService;

import static org.junit.Assert.*;


/**
 * @author yongboyao
 * create_date 2022/12/6$
 * @Description
 **/
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Test
    public void testQueryUserCountWithPowerMock(){
        UserDao uDao = PowerMockito.mock(UserDao.class);
        //PowerMockito.doReturn(10).when(uDao).getCount();
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService service = new UserService(uDao);
        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Test
    public void testQueryUserCountWithMockito(){
//        MockitoAnnotations.initMocks(this);
        UserService service = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        int result = service.queryUserCount();
        assertEquals(10, result);
    }

    @Before
    public void setup(){
        userService = new UserService(new UserDao());
    }

    @Ignore
    @Test
    public void testQueryUserCountWithJnit(){
        try {
            userService.queryUserCount();
            fail("should not process to here.");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }
    @Ignore
    @Test
    public void testSaveUserWithJunit(){
        try {
            userService.saveUser(new User());
            fail("should not process to here.");
        }catch (Exception e){
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

}
