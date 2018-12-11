package test1;

public class Test1 {
    public static void main(String[] args) {
        //获取Class对象的第一种方式
        Student stu = new Student();

        Class<? extends Student> clas_student = stu.getClass();

        //获取Class对象的第二种方式
        Class<Student> clas_student2 = Student.class;

        //获取Class对象的第三种方式,用得最多
        try {
            Class<?> clas_student3 = Class.forName("test1.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
