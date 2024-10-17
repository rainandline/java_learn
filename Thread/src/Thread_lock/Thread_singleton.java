package Thread_lock;

/**
 * 懒汉式(线程安全)
 */

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static synchronized Bank getInstance() {//同步监视器，默认为Bank.class
        if (instance == null) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            instance = new Bank();

        }
        return instance;
    }
}



public class Thread_singleton {

    static Bank b1=null;
    static Bank b2=null;

    public static void main(String[] args) {
        Thread t1=new Thread(){
            @Override
            public void run() {
                b1=Bank.getInstance();
            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                b2=Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1==b2);
    }
}
