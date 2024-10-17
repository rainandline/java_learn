class Bank{
    //1.私有化构造器
    private Bank(){
    }
    //2.创建私有静态的类对象
    private static Bank instance = new Bank();

    //3.创建静态方法获取该静态对象,不能用对象去调
    public static Bank getInstance(){
        return instance;
    }
}

public class exert {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);
    }
}

//饿汉式的优缺点：
//坏处：对象加载的时间过长；提前的占用系统的资源
//好处：饿汉式是线程安全；

