package Thread_introduction;

//1.创建一个继承Thread类的子类；
class Thread1 extends Thread {
    private final String name;

    public Thread1(String name) {
        this.name = name;
    }

    //2.重写Thread类的run()
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行 ： " + i);
            try {
                //sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会。
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Exert_thread {
    public static void main(String[] args) {
        Thread1 t1=new Thread1("A");
        Thread1 t2=new Thread1("B");

        //通过此对象调用start():启动当前线程,一个对象只有一次调用的机会，否则就会报错
        t1.start();
        t2.start();
        //****注意哈，不能用t1.run替换
    }
}


//Java语言的JVM允许程序运行多个线程，它通过**java.lang.Thread **类来体现。
//通过该Thread对象的start()方法来启动这个线程，而非直接调用run( )。

//构造器：
//Thread()：创建新的Thread对象 。
//Thread(String thread_name)：创建线程并指定线程实例名。
//Thread(Runnable target)：指定创建线程的目标对象，它实现了Runnable接 口中的run方法。
//Thread(Runnable target, String name)：创建新的Thread对象。

//继承Thread类
//定义子类继承Thread类。
//子类中重写Thread类中的run方法。
//创建Thread子类对象，即创建了线程对象。
//调用线程对象start方法：启动线程，调用run方法。


//***********注意点******************
//如果自己手动调用run()方法，那么就只是普通方法，没有启动多线程模式。
//run()方法由JVM调用，什么时候调用，执行的过程控制都有操作系统的CPU 调度决定。
//想要启动多线程，必须调用start方法。
//一个线程对象只能调用一次start()方法启动，如果重复调用了，则将抛出以上的异常“IllegalThreadStateException”。


