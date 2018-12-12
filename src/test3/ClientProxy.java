package test3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientProxy {
    public static void main(String[] args) {
        IGamePlayer player = new GamePlayer("你最喜欢的老公"); //被代理的对象
        IGamePlayer proxy = new GamePlayerProxy(player);//代理

        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        System.out.println("开始时间:" + current);
        proxy.login("695055449@qq.com","123456");
        proxy.killBoos();
        proxy.upgrade();

        current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        System.out.println("结束时间:" + current);
    }
}
