package Thread_means;

class PrintNumber extends Thread {
    public PrintNumber(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);

            if (i % 20 == 0)
                Thread.yield();
        }

    }

}

public class Exert_means {
    public static void main(String[] args) {

        PrintNumber t1 = new PrintNumber("线程一");
        t1.setName("子线程");
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":"
                        +Thread.currentThread().getPriority()+":"+ i + "*******");

                if (i == 20 ) {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        System.out.println("子线程1是否存活 "+t1.isAlive());
    }
}

//1.Thread currentThread(): 返回当前线
//  getName(): 返回线程的名称
//  setName(String name):设置该线程名称
//  start():启动线程，并执行对象的run()方法
//  run(): 线程在被调度时执行的操作
//  sleep(): 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）


//2. yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。
//sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
//yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。

//3.join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”

//4.isAlive()：返回boolean，判断线程是否还活着

//线程的调度方法：getPriority() ：返回线程优先值；setPriority(int newPriority) ：改变线程的优先级；
//******!!!!!线程的优先级高并不代表他一定会执行，他是相互交互的，只是概率的高低而已