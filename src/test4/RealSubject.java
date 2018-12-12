package test4;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject执行request方法");
    }
}
