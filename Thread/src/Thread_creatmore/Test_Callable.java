package Thread_creatmore;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ExecutionException;

class NewThread implements Callable {
    private int sum;
    //线程操作：求100以内的偶数和
    //2.实现Callable接口中的方法，将此线程需要执行的操作声明在call()中；
    @Override
    public  Object call() throws Exception {
        for (int i = 1; i <=100; i++) {
            if(i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;  //int——>Integer:自动装箱
    }
}



public class Test_Callable {
    public static void main(String[] args) {
        //3.创建实现类的对象；
        NewThread n1 = new NewThread();

        //4.将实现类的对象作为实参传入FutureTask的构造器中，创建FutureTask类的对象；
        FutureTask task = new FutureTask(n1);

        //5.将FutureTask类的对象作为实参传入Thread的构造器中，创建Thread类的对象，并调用start();
        new Thread(task).start();

        try {
            //6.FutureTask类的对象调用get()方法获取call()的返回值；
            //获取call()方法的返回值；
            Object sum = task.get();
            System.out.println("100以内的偶数和："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//与使用Runnable相比， Callable功能更强大些：
//call()相比run()方法，可以有返回值；
//call()法可以抛出异常；
//Callable是支持泛型的返回值；
//需要借助FutureTask类，比如获取返回结值


//可以对具体Runnable、Callable任务的执行结果进行取消、查询是否完成、获取结果等。
//FutrueTask是Futrue接口的唯一的实现类。
//FutureTask 同时实现了Runnable, Future接口。它既可以作为 Runnable被线程执行，又可以作为Future得到Callable的返回值。




