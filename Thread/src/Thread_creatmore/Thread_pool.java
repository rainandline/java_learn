package Thread_creatmore;

public class Thread_pool {
    public static void main(String[] args) {
        System.out.println("introduction thread pool");
    }
}

//经常创建和销毁、使用量特别大的资源，比如并发情况下的线程， 对性能影响很大。

//思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。类似生活中的公共交通工具。


//好处：
//提高响应速度（减少了创建新线程的时间）；
//降低资源消耗（重复利用线程池中线程，不需要每次都创建）；