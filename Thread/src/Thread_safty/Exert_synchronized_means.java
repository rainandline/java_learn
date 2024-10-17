package Thread_safty;

class SaleTicket1 implements Runnable {
    int tick = 100;
    boolean isFlag = true;

    @Override
    public void run() {
        while (isFlag) {
                show();
        }
    }

    public synchronized void show() {
        if (tick > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "售票，票号为： " + tick);
            tick--;
        } else {
            isFlag = false;
        }
    }
}

public class Exert_synchronized_means {
    public static void main(String[] args) {
        SaleTicket1 s=new SaleTicket1();

        Thread t1=new Thread(s);
        Thread t2=new Thread(s);
        Thread t3=new Thread(s);

        t1.start();
        t2.start();
        t3.start();
    }
}
