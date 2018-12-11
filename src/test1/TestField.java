package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class TestField {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;

        Student student = newInstance();

        //获取Student类所有的公共的属性
        //Field[] fields = studentClass.getFields();

        //获取Student类中所有的包括私有的属性
        Field[] fields = studentClass.getDeclaredFields();
        Stream.of(fields).forEach(
                t-> System.out.println("属性名称：" + t.getName() + ",类型：" + t.getType().getName())
        );

        try {
            Field name = studentClass.getDeclaredField("name");//获取Student类中的name属性
            name.setAccessible(true); //设置私有化属性可见

            Field age = studentClass.getDeclaredField("age");//获取age属性
            age.setAccessible(true);
            Field sex = studentClass.getDeclaredField("sex"); //获取sex属性
            sex.setAccessible(true);
            /*
            * 及时私有化的属性，通过反射也能够读取
            * 默认情况下，不能够直接读取或为私有的属性赋值
            * 在获取或为私有的属性赋值之前，应调用setAccessible方法设置私有的属性可见
            * */
            Object v_name = name.get(student);//获取student对象中name属性的值
            System.out.println("name=" + v_name);

            Object v_age = age.get(student);
            System.out.println("age=" + v_age);

            Object v_sex = sex.get(student);
            System.out.println("v_sex=" + v_sex);

            name.set(student,"王五");
            age.set(student,20);
            sex.set(student,'女');

            System.out.println("修改属性值后的学生信息：" + student);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    /**
     * 通过调用有参构造方法实例化对象
     * @return
     */
    public static Student newInstance(){
        Class<Student> studentClass = Student.class;

        try {
            //获取有参构造函数
            Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class, char.class);
            Student student = constructor.newInstance("张三", 21, '男');
            return student;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
