package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class TestConstructor {
    public static void main(String[] args) {
        //test2();

        //通过反射，调用有参构造方法实例化Student对象
        Class<Student> studentClass = Student.class;
        try {
            Constructor<Student> constructor = studentClass.getConstructor(String.class, int.class, char.class);
            Student student = constructor.newInstance("李四", 18, '女');
            System.out.println(student);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取无参构造方法中的参数
     * 及通过无参构造方法实例化对象
     */
    public static void test1(){
        Class<Student> studentClass = Student.class;
        //studentClass.getConstructors()
        try {
            /*
             * 获取Student类的无参构 造方法
             * */
            Constructor<Student> constructor = studentClass.getConstructor(null);
            int modifiers = constructor.getModifiers();//获取访问修饰符
            String m_str = Modifier.toString(modifiers);//将int的访问修饰符转换字符串
            System.out.println("访问修饰符：" + m_str);

            int count = constructor.getParameterCount();
            System.out.println("构造函数参数个数：" + count);
            Class<?>[] parameterTypes = constructor.getParameterTypes();//获取构造函数的参数列表
            System.out.println("构造函数参数名字：");
            Stream.of(parameterTypes).forEach(t-> System.out.println(t.getName()));

            /*
             * 在java中，获取构造函数的目的是实例化对象
             * */
            Student student = constructor.newInstance(null);//实参
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取有参构造方法中的参数及
     * 通过有参构造方法实例化对象
     */
    public static void test2(){
        Class<Student> studentClass = Student.class;

        Constructor<?>[] constructors = studentClass.getConstructors();
        Stream.of(constructors).forEach(
                t->{
                    int count = t.getParameterCount();
                    System.out.println("参数个数：" + count);
                    Class<?>[] types = t.getParameterTypes();
                    System.out.println("构造函数参数列表：");
                    Stream.of(types).forEach(j->
                        System.out.print(j.getName() + ",")
                    );
                    System.out.println("------------------------------");
                }
        );

    }
}
