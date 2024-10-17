package Thread_introduction;

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
public class Exert_runnable {
    public static void main(String[] args) {
        //3.创建实现类的对象
        MyRunnable mThread=new MyRunnable();

        Thread t1=new Thread(mThread);
        t1.setName("线程一");
        t1.start();
    }
}

//**不管是扩展Thread类还是实现Runnable接口来实现多线程，
//最终还是通过Thread的对象的API来控制线程的，熟悉Thread类的API是进行多线程编程的基础。


//*****实现Runnable接口和继承Thread的区别**********
//继承Thread：线程代码存放Thread子类run方法中。
//实现Runnable：线程代码存在接口的实现类的run方法。


//实现Runnable接口比继承Thread类所具有的优势：
//1：适合多个相同的程序代码的线程去处理同一个资源
//2：可以避免java中的单继承的限制
//3：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立
//4：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类


