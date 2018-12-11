package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        try {
            Class<?> class_stu = Class.forName("test1.Student");

            /**
             * 调用Student类的无参构造方法实例化Student对象
             * 和Student stu = new Student();等价
             */
            Student stu = (Student) class_stu.newInstance();
            System.out.println(stu.toString());

            //得到完整类名
            String fullName = class_stu.getName();
            System.out.println("完整类路径：" + fullName);

            String simpleName = class_stu.getSimpleName();
            System.out.println("类名：" + simpleName);

            String super_name = class_stu.getSuperclass().getName();
            System.out.println("父类路径：" + super_name);

            /*获取实现的所有接口*/
            Class<?>[] interfaces = class_stu.getInterfaces();
            System.out.println("实现的接口：");
            Stream.of(interfaces).forEach(t -> System.out.println(t.getName()));

            /*获取所有构造函数*/
            Constructor<?>[] constructors = class_stu.getConstructors();
            System.out.println("所有的构造函数：");
            Stream.of(constructors).forEach(t -> System.out.println(t.getName()));

            /*获取所有的属性
            * getDeclaredFields()  获取公共的，私有的属性
            *
            * getFields()           获取公共的属性
            * */
            Field[] fields1 = class_stu.getFields();
            System.out.println("所有公共的属性");
            Stream.of(fields1).forEach(t -> System.out.println("属性：" + t.getName() + ",类型：" + t.getType().getName()));

            Field[] declaredFields = class_stu.getDeclaredFields();
            System.out.println("所有属性");
            Stream.of(declaredFields).forEach(t -> System.out.println("属性：" + t.getName() + ",类型：" + t.getType().getName()));


            /*
            * getDeclaredMethods()     获取所有的方法，包括私有的，不能获取父类中的方法
            *
            * getMethods()              获取公共的方法,包括父类中能被访问的方法
            * */
            Method[] methods = class_stu.getMethods();
            System.out.println("所有公共方法：");
            Stream.of(methods).forEach(t -> System.out.println(t.getName()));
            System.out.println();
            Method[] declaredMethods = class_stu.getDeclaredMethods();
            System.out.println("所有的方法");
            Stream.of(declaredMethods).forEach(t -> System.out.println(t.getName()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
