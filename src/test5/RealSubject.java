package test5;

public class RealSubject implements Subject {
    @Override
    public void action() {
        System.out.println("被代理的RealSubject对象执行action方法");
    }
}
