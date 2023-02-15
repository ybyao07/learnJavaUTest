package yao.powermock.lesson7matcher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author yongboyao
 * create_date 2023/2/8$
 * @Description
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserDaoService.class)
public class UserDaoServiceTest {
    @Test
    public void testFind() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName("alex")).thenReturn("aaa");
        UserDaoService service = new UserDaoService();
        String result = service.find("alex");
        assertEquals("aaa", result);

        PowerMockito.when(userDao.queryByName("Jacky")).thenReturn("aaa");
        String jacky = service.find("Jacky");
        assertEquals("aaa", result);
    }

    @Test
    public void testFindWithMatcher() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName(ArgumentMatchers.argThat(new MyArgumentMatcher()))).thenReturn("aaa");
        UserDaoService service = new UserDaoService();
        assertEquals("aaa", service.find("Alex"));
        assertEquals("aaa", service.find("Jacky"));
        assertEquals("aaa", service.find("Van"));
    }


    @Test
    public void testFindWithAnswer() throws Exception{
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);
        PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(invocation ->{
          String arg = (String ) invocation.getArguments()[0];
          switch (arg){
              case "Jacky":
                  return "I am Jacky.";
              case "Alex":
                  return "I am Alex";
              default:
                  throw new RuntimeException("Not support " + arg);
          }
        });
        UserDaoService service = new UserDaoService();
        assertEquals("I am Jacky.", service.find("Jacky"));
        assertEquals("I am Alex", service.find("Alex"));
        try {
            String anyValue = service.find("AnyValue");
        }catch (Exception e){
            assertTrue(e instanceof RuntimeException);
        }
    }

    static class MyArgumentMatcher implements ArgumentMatcher<String> {
        @Override
        public boolean matches(String s) {
            switch (s){
                case "Alex":
                case "Jacky":
                case "Van":
                    return true;
                default:
                    return false;
            }
        }
    }
}
