package yao.mockito.lesson02;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yongboyao
 * create_date 2022/11/27$
 * @Description
 **/

public class AccountLoginController {
    private final AccountDao accountDao;

    public AccountLoginController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public String doLogin(HttpServletRequest request){
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Account account = accountDao.getAccount(userName, password);
            if (account != null){
                return "/index";
            }else {
                return "/login";
            }
        }catch (Exception e){
            return "/500";
        }
    }
}
