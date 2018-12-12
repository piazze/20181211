package test3;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Client {
    public static void main(String[] args) {
        /*
        * 使用JDK8LocalDateTime将日期格式化为字符串
        * */
        /*LocalDateTime time1 = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String current = time1.format(dateTimeFormatter);*/

        //long currentTimeMillis = System.currentTimeMillis(); //1970-1-1 0:0:0距今的毫秒数

        String current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());

        System.out.println("开始时间:" + current);
        IGamePlayer player = new GamePlayer("你最喜欢的老公");
        player.login("695055449@qq.com","123456");
        player.killBoos();
        player.upgrade();

        current = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date());
        System.out.println("结束时间:" + current);

    }
}
