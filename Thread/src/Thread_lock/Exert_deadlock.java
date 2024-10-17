package Thread_lock;

import java.util.concurrent.locks.ReentrantLock;

class Window extends Thread {
    static int ticket = 100;
    private static final ReentrantLock lock = new ReentrantLock();//创建lock的实例，需要确保公用

    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，票号： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
public class Exert_deadlock {
    public static void main(String[] args) {
        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.start();
        w2.start();
        w3.start();
    }
}


//死锁：
//不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。
//出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续。

//synchronized 与 Lock 的对比（面试题）：
//Lock是显式锁（手动开启和关闭锁，别忘记关闭锁），synchronized是 隐式锁，出了作用域自动释放；
//Lock只有代码块锁，synchronized有代码块锁和方法锁。
//使用Lock锁，JVM将花费较少的时间来调度线程，性能更好。并且具有 更好的扩展性（提供更多的子类）

//Lock ——> 同步代码块（已经进入了方法体，分配了相应资源） ——> 同步方法 （在方法体之外）