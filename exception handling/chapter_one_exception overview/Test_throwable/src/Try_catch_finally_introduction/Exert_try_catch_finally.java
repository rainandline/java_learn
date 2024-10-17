package Try_catch_finally_introduction;

public class Exert_try_catch_finally {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("An arithmetic exception has occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block is executed");
        }
    }


    public static int divide(int num1, int num2) {
        try {
            return num1 / num2;
        } finally {
            System.out.println("Finally block inside divide() method is executed");
        }
    }
}




//使用try-catch-finally处理编译时异常，使得程序在编译时就不报错，但是运行时仍可能报错。
//相当于我们使用try-catch-finally将一个编译时可能出现的异常，延迟到运行时出现。

//开发中，由于运行时异常比较常见，所以我们通常就不针对运行时异常编写try-catch-finally了。
//针对编译时异常，我们说一定需要考虑异常处理。



//Java采用的异常处理机制，是将异常处理的程序代码集中在一起， 与正常的程序代码分开，使得程序简洁、优雅，并易于维护。
//Java提供的是异常处理的抓抛模型。
//Java程序的执行过程中如出现异常，会生成一个异常类对象， 该异常对象将被提交给Java运行时系统，这个过程称为抛出 (throw)异常。



//如果一个方法内抛出异常，该异常对象会被抛给调用者方法中处理。如果异常没有在调用者方法中处理，它继续被抛给这个调用方法的上层方法。这个过程将一直继续下去，直到异常被处理。 这一过程称为捕获(catch)异常。
//（2）如果一个异常回到main()方法，并且main()也不处理，则程序运行终止。
//（3）程序员通常只能处理Exception，而对Error无能为力。


//在catch语句块中是对异常对象进行处理的代码。每个try语句块可以伴随 一个或多个catch语句，用于处理可能产生的不同类型的异常对象。


//捕获异常的最后一步是通过finally语句为异常处理提供一个统一的出口，使得在控制流转到程序的其它部分以前，能够对程序的状态作统一的管理。
//不论在try代码块中是否发生了异常事件，catch语句是否执行，catch语句是否有异常，catch语句中是否有return， finally块中的语句都会被执行。


//getMessage() 获取异常信息，返回字符串 。
//**printStackTrace() **获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。

//对于try内声明的变量，出了try后就无法使用,catch中由上到下的基本关系为子父类关系