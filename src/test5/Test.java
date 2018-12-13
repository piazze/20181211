package test5;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) {
        /*数字自增长*/
        AtomicInteger ai = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            int andIncrement = ai.getAndIncrement();//获取后自增数字
            System.out.println(andIncrement);

        }
    }
}
