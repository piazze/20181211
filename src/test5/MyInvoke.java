package test5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvoke implements InvocationHandler {

    private Object obj;
    public MyInvoke(Object obj) { //被代理对象的实例
        this.obj = obj;
    }

    /**
     * @param proxy  被代理类的对象
     * @param method 本例中被执行的action方法
     * @param args   method方法需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------开始代理------------");
        Object obj = method.invoke(this.obj,args);
        System.out.println("---------代理完成------------");
        return obj;
    }
}
