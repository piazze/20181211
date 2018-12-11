package test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class TestMethod {
    public static void main(String[] args) {
        //test1();
        Class<Student> studentClass = Student.class;
        //test2(studentClass);

        Student stu = new Student();//空的student对象

        try {
            //获取setName方法，setName方法需要一个String类型的参数
            Method setName = studentClass.getMethod("setName", String.class);
            Method setAge = studentClass.getMethod("setAge", int.class);
            Method setSex = studentClass.getMethod("setSex", char.class);

            /*
            * Method对象的invoke方法负责执行方法
            * invoke(调用方法的对象,方法的参数列表)
            * invoke方法会根据该method对象代表的方法的返回值类型返回一个Object对象
            * 比如：setName有返回值，在调用了setName.invoke以后，就可以用一个Object接收方法的
            * 返回值
            *
            * 如果方法没有返回值，调用了invoke后，无需接收返回值
            * */
            Object obj = setName.invoke(stu, "李四");
            //System.out.println(obj);
            setAge.invoke(stu,18);
            setSex.invoke(stu,'女');

            Method getName = studentClass.getMethod("getName");//获取getName方法
            String name = (String) getName.invoke(stu); //因为getName有返回值，所以可以用String接收
            System.out.println("姓名：" + name);

            Method getAge = studentClass.getMethod("getAge");
            int age = (int) getAge.invoke(stu);
            System.out.println("年龄：" + age);

            Method getSex = studentClass.getMethod("getSex");
            char sex = (char) getSex.invoke(stu);
            System.out.println("性别：" + sex);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    private static void test2(Class<Student> studentClass) {
        /*
        * getDeclaredMethods()获取本类所有的公共的及私有的方法
        * */
        Method[] methods = studentClass.getDeclaredMethods();
        Stream.of(methods).forEach(t->{
            System.out.println("方法名：" + t.getName());
            Class<?>[] parameterTypes = t.getParameterTypes();
            System.out.println("参数列表：");
            Stream.of(parameterTypes).forEach(j->{
                System.out.print(j.getName());
            });
            Class<?> returnType = t.getReturnType();
            System.out.println("\n方法的返回值类型：" + returnType.getName());
            System.out.println();
        });
    }

    private static void test1() {
        Class<Student> studentClass = Student.class;
        /*
        * getMethods()获取本类及父类中所有公共的方法
        * */
        Method[] methods = studentClass.getMethods();
        Stream.of(methods).forEach(t->{
            System.out.println("方法名：" + t.getName());
            Class<?>[] parameterTypes = t.getParameterTypes();
            System.out.println("参数列表：");
            Stream.of(parameterTypes).forEach(j->{
                System.out.print(j.getName());
            });
            Class<?> returnType = t.getReturnType();
            System.out.println("\n方法的返回值类型：" + returnType.getName());
            System.out.println();
        });
    }
}
