class Girl{
    //1.私有化构造器
    private Girl(){
    }
    //2.创建私有静态的Bank，并不实例化
    private static Girl instance = null;

    //3.创建静态方法获取该静态对象
    public static Girl getInstance(){
        if(instance==null){
            instance = new Girl();
        }
        return instance;
    }
}

public class exert_two {
    public static void main(String[] args) {
        Girl girl1=Girl.getInstance();
        Girl girl2=Girl.getInstance();

        System.out.println(girl1==girl2);
    }
}

//懒汉式的优缺点：
//好处：延迟对象的创建；
//目前坏处：线程不安全；------->到多线程内容时，再修正为线程安全；


//所谓类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，并且该类只提供一个取得其对象实例的方法。
//
//②创建单例模式的类步骤：
//①私有化（private）类的构造器；
//②类内部创建对象：要求此对象必须是static的
//③提供公共的静态的方法，返回类的对象；


//由于单例模式只生成一个实例，减少了系统性能开销，当一个对象的产生需要比较多的资源时，
//如读取配置、产生其他依赖对象时，则可 以通过在应用启动时直接产生一个单例对象，然后永久驻留内存的方式来解决。

//
