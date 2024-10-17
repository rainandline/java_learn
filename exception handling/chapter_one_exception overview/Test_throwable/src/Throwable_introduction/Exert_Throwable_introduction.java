package Throwable_introduction;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class Exert_Throwable_introduction {

    // ClassCastException类型转换异常
    @Test
    public void test1(){
        Object obj = new Date();
        Order order;
        order = (Order) obj;
        System.out.println(order);
    }

    //ArrayIndexOutOfBoundsException
    @Test
    public void test2(){
        String friends[] = { "lisa", "bily", "kessy" };
        for (int i = 0; i < 5; i++) {
            System.out.println(friends[i]); // friends[4]?
        }
        System.out.println("\nthis is the end");
    }
}



//在Java语言中，将程序执行中发生的不正常情况称为“异常” 。 (注意：开发过程中的语法错误和逻辑错误不是异常)


//异常事件分类：
//① Error：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。
//比如：StackOverflowError和OOM（堆溢出）。一般不编写针对性的代码进行处理

//②Exception：其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。
//空指针访问 ；试图读取不存在的文件；网络连接中断；数组角标越界；


//Exception：编译时异常 与 运行时异常
//运行时异常：
//是指编译器不要求强制处置的异常。一般是指编程时的逻辑错误，是程序员应该积极避免其出现的异常。java.lang.RuntimeException类及它的子类都是运行时异常。
//对于这类异常，可以不作处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响。

//编译时异常
//是指编译器要求必须处置的异常。即程序在运行时由于外界因素造成的一 般性异常。编译器要求Java程序必须捕获或声明所有编译时异常。
//对于这类异常，如果程序不处理，可能会带来意想不到的结果。


//Java.lang.Throwable
//-----java.lang.Error:一般不编写针对性的代码进行处理。
//-----java.lang.Exception:可以进行异常的处理
//-------------编译时异常（checked）
//-------------------------IOException
//-------------------------FileNotFoundException
//-------------------------ClassNotFoundException
//-------------运行时异常（unchecked）
//--------------------------NullPointerException
//--------------------------ArrayIndexOutOfBoundException
//--------------------------ClassCastException
//--------------------------NumberFormatException
//--------------------------InputMismatchException
//--------------------------ArithmeticException

