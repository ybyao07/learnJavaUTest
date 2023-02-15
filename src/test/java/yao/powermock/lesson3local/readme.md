## 局部变量mock
场景：某个方法里面使用的局部变量对象，可以通过PowerMockito.whenNew(XX.class).withNoArguments().thenReturn(xx);来模拟
例如下面
public int queryUserCount(){
UserDao userDao = new UserDao();
return userDao.getCount();
}
如果要测试queryUserCount()方法，mockito默认是无法支持的，需要PowerMockito里面以动态代理的模式将创建对象嵌入到方法中