package test4;

public class Proxy implements Subject {

    private Subject subject;

    public Proxy() {
        this.subject = new RealSubject();
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();//被代理对象的request方法
        this.after();
    }

    /**
     * 在被代理对象方法执行前执行的方法
     */
    public void before(){
        System.out.println("------before-------");
    }

    /**
     * 在被代理对象方法之后执行的方法
     */
    public void after(){
        System.out.println("------after-------");
    }
}
