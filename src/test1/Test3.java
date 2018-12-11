package test1;

import java.util.Enumeration;
import java.util.Properties;

public class Test3 {
    public static void main(String[] args) {
        /**
         * 获取jvm及操作平台相关信息
         */
        Properties prop = System.getProperties();
        Enumeration<?> enu = prop.propertyNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            //System.out.println(key);
            String value = prop.getProperty(key);
            System.out.println("key:" + key + "\t value:" + value);
        }
    }
}
