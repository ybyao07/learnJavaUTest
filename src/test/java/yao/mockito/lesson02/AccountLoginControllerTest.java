package yao.mockito.lesson02;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author yongboyao
 * create_date 2022/11/27$
 * @Description
 **/
@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {

    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController controller;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao dao;
    @Before
    public void setUp(){
        accountDao = mock(AccountDao.class);
        request = mock(HttpServletRequest.class);
        controller = new AccountLoginController(accountDao);
    }
    @Test
    public void testSuccessLogin(){
        Account account = new Account();
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.getAccount(anyString(), anyString())).thenReturn(account);
        String result = controller.doLogin(request);
        assertThat(result, equalTo("/index"));
    }
    @Test
    public void testBackLogin(){
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.getAccount(anyString(), anyString())).thenReturn(null);
        String result = controller.doLogin(request);
        assertThat(result, equalTo("/login"));
    }

    @Test
    public void testExceptionLogin(){
        when(request.getParameter("username")).thenReturn("alex");
        when(request.getParameter("password")).thenReturn("123456");
        when(accountDao.getAccount(anyString(), anyString())).thenCallRealMethod();
        String result = controller.doLogin(request);
        assertThat(result, equalTo("/500"));
    }
}
