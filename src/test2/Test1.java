package test2;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Test1 {
    /**
     * java Bean
     * 具有构造方法
     * 具有私有的属性
     * 具有setters/getters
     *
     * 通常java Bean指实体类
     * @param args
     */
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("test1.Student");

            //获取javaBean  Student类的信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);

            //获取bean中的属性
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            //内省机制通过获取get/set方法推断出bean中具有的属性
            Stream.of(propertyDescriptors).forEach(t->
                    {
                        System.out.println("属性名：" + t.getName());
                        Method m_read = t.getReadMethod();
                        if (m_read != null) {
                            String get = m_read.getName();
                            System.out.println("get方法：" + get);
                        }

                        Method m_write = t.getWriteMethod();
                        if (m_write != null) {
                            String set = m_write.getName();
                            System.out.println("set方法：" + set);
                        }

                        System.out.println();
                        System.out.println();
                    }

                    );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

}
