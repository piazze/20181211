package test1;

import java.io.*;
import java.net.URL;

public class Test4 {
    public static void main(String[] args) {
        //当前项目的原文件夹中找包名+文件名 得到文件输入流
        //InputStream in = Test4.class.getClassLoader().getResourceAsStream("test2/data");

        //Test4.java类所在包中查找data文件
        InputStream in = Test4.class.getResourceAsStream("data");
        Reader reader = new InputStreamReader(in);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            String line = buffer.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
