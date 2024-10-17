package Thread_correspondence;

class ThreadCommunication implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();  //就会唤醒wait的一个线程。如果有多个线程被wait，就唤醒优先级高的
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态,并且释放锁
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}


public class Thread_CommunicationTest {
    public static void main(String[] args) {
        ThreadCommunication t = new ThreadCommunication();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();    //start方法调用run方法，并启动线程
        t2.start();
    }
}

//*****wait() 与 notify() 和 notifyAll()********：
//wait()：一旦执行此方法，当前进程就进入阻塞状态，并释放同步监视器（锁）；
//notify()：一旦执行此方法，就会唤醒wait的一个线程。如果有多个线程被wait，就唤醒优先级高的；
//notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程；


//wait()说明
//调用方法的必要条件：当前线程必须具有对该对象的监控权（加锁）。
//调用此方法后，当前线程将释放对象监控权 ，然后进入等待。


//wait()、notify()、notifyAll()三个方法必须使用在同步代码块或同步方法中；
//wait()、notify()、notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现IllegalMonitorStateException异常；
//wait()、notify()、notifyAll()三个方法是定义在java.lang.Object类中；


//sleep() 和 wait()的异同：
//相同点：一旦执行方法，都可以是当前的线程进入阻塞状态；

//不同点：
//两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait();
//调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码块或同步方法中；
//关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁。wait()会释放锁；
