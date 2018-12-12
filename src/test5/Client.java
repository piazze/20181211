package test5;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //dynameicProxy();
        testGame();
    }

    /**
     * 动态代理
     */
    private static void dynameicProxy() {
        Subject subject = new RealSubject();

        ClassLoader classLoader = subject.getClass().getClassLoader();
        Class<?>[] interfaces = {Subject.class}; //代理对象需要实现的接口
        //动态代理生成代理类的对象，该代理动态实现了Subject接口
        Subject proxy = (Subject) Proxy.newProxyInstance(classLoader, interfaces, new MyInvoke(subject));

        proxy.action();//通过代理执行action方法
    }

    private static void testGame(){
        IGamePlayer player = new GamePlayer("你最喜欢的老公");

        //获取player的类加载器
        ClassLoader classLoader = player.getClass().getClassLoader();

        //列出被代理对象实现的接口
        Class<?>[] interfaces = player.getClass().getInterfaces();

        //通过 Proxy.newProxyInstance产生动态代理的对象
        IGamePlayer proxy = (IGamePlayer) Proxy.newProxyInstance(classLoader, interfaces, new MyInvoke(player));
        proxy.login("admin","123456");
        proxy.killBoos();
        proxy.upgrade();
    }
}
