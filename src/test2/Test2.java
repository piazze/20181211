package test2;

import test1.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",18);
        map.put("sex",'男');
        Student student = init(Student.class, map);
        System.out.println(student);

        Map<String,Object> foodMap = new HashMap<>();
        foodMap.put("foodName","牛肉干");
        foodMap.put("price",20);
        foodMap.put("count",10);
        Food food = init(Food.class, foodMap);
        System.out.println(food);
    }

    public static <T> T init(Class<T> bean, Map<String,Object> properties){
        //通过内省机制为属性赋值
        T obj = null;
        try {
            obj = bean.newInstance(); //空的对象

            //通过内省机制为obj对象赋值
            BeanInfo beanInfo = Introspector.getBeanInfo(bean);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor prop : propertyDescriptors) {
                String key = prop.getName();  //获取根据内省机制推断的属性名，name,age,sex
                if (key.equals("class")){
                    continue;
                }
                if (properties.containsKey(key)){
                    Object value = properties.get(key); //从集合中获取属性名对应的值
                    Method writeMethod = prop.getWriteMethod();
                    writeMethod.invoke(obj,value);//通过调用方法为属性赋值，值从map中获取
                } else {
                    throw new RuntimeException("have no property that is " + key);
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
