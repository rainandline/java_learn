package Thread_correspondence;

class Clerk{//店员
    private int production=0;//产品数目

    public synchronized void addProduction(){

        if(production>=20)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else{
            production++;
            System.out.println(Thread.currentThread().getName()+"生产第"+production+"个产品");

            notifyAll();
        }

    }

    public synchronized void subProduction(){
        if(production<=0)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
       else {
            System.out.println(Thread.currentThread().getName()+"消费第"+production+"个产品");
            production--;

            notifyAll();
        }
    }
}

class Producer extends Thread{//生产者

    private Clerk clerk;

    public Producer(Clerk clerk)
    {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while(true)
        {
            System.out.println("生产者开始生产商品。。。。");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            clerk.addProduction();
        }
    }
}

class Consumer extends Thread{//消费者

    private Clerk clerk;

    public Consumer(Clerk clerk)
    {
        this.clerk=clerk;
    }

    @Override
    public void run() {
        while(true)
        {
            System.out.println("消费者开始消费商品。。。。");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            clerk.subProduction();
        }
    }
}
public class ProducerTest {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();

        Producer pro1=new Producer(clerk);
        Consumer con1=new Consumer(clerk);

        pro1.setName("生产者1");
        con1.setName("消费者1");

        pro1.start();
        con1.start();

    }
}


//对于共享数据的两个对象分别为消费者和生产者，两者实现交互

//对于共享数据的增减由店员维护,相当于缓冲区