package Thread_safty;

class SaleTicket implements Runnable {
    int tick = 100;

    @Override
    public void run() {
        while (true) {

            synchronized(this){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (tick > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票，票号为： " + tick);
                    tick--;
                } else {
                    break;
                }

            }
        }
    }
}

public class Exert_synchronized_mass {
    public static void main(String[] args) {
        SaleTicket s=new SaleTicket();

        Thread t1=new Thread(s);
        Thread t2=new Thread(s);
        Thread t3=new Thread(s);

        t1.start();
        t2.start();
        t3.start();
    }
}




//多线程出现安全问题:当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完，另一个线程参与进来执行。导致共享数据的错误。


//解决线程安全问题
//1.同步机制：（关键字：synchronized）
//同步代码块
//操作共享数据的代码，即为需要被同步的代码；---->不能包含代码多了也不能包含代码少；
//共享数据：多个线程共同操作的数据，例如ticket
//同步监视器：俗称：锁。任何一个类的对象都可以充当锁；
//要求：多个线程必须要共用同一把锁；
//补充：在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当同步监视器；

//同步方法 synchronized还可以放在方法声明中，表示整个方法为同步方法。

//释放锁的操作：
//当前线程的同步方法、同步代码块执行结束。
//当前线程在同步代码块、同步方法中遇到break、return终止了该代码块、 该方法的继续执行。
//当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致异常结束。
//当前线程在同步代码块、同步方法中执行了线程对象的**wait()**方法，当前线程暂停，并释放锁。
