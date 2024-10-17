package Thread_handing;

import org.w3c.dom.ls.LSOutput;

public class Exert_handing {
    public static void main(String[] args) {
        System.out.println("Thread introduction about foundation");
    }
}



//一：基本概念:程序、进程、线程

//******程序是静态的，进程是动态的******
//*****堆是空间的分配，栈是程序运行*******

//程序(program)是为完成特定任务、用某种语言编写的一组指令的集合。即指一段静态的代码，静态对象
//进程(process)是程序的一次执行过程，或是正在运行的一个程序
//线程(thread)，进程可进一步细化为线程，是一个程序内部的一条执行路径。线程作为调度和执行的单位，每个线程拥有独立的运行栈和程序计数器(pc)，线程切换的开销小。


//二：线程理解
//1.一个Java应用程序java.exe，其实至少有三个线程：main()主线程，gc() 垃圾回收线程，异常处理线程

//2.多线程程序的优点：
//提高应用程序的响应。对图形化界面更有意义，可增强用户体验。**提高计算机系统CPU的利用率**改善程序结构。将既长又复杂的进程分为多个线程，独立运行，利于理解和修改。

//调度策略：
//时间片；     抢占式：高优先级的线程抢占CPU；



//线程的优先级：
//MAX_PRIORITY：10
//MIN _PRIORITY：1
//NORM_PRIORITY：5
//涉及的方法：
//
//getPriority() ：返回线程优先值；
//setPriority(int newPriority) ：改变线程的优先级；

////main方法其实也是一个线程。在java中所以的线程都是同时启动的，至于什么时候，哪个先执行，完全看谁先得到CPU的资源。
////在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
////因为每当使用java命令执行一个类的时候，实际上都会启动一个ＪＶＭ，每一个ｊＶＭ实习在就是在操作系统中启动了一个进程。