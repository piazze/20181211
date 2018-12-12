package test4;

public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy();//代理
        subject.request();//请求方法
    }
}
