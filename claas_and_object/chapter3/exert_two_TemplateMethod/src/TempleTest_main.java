/**
 * 模板方法模式定义了一个算法的骨架，将一些步骤的实现延迟到子类。模板方法使得子类可以在不改变算法结构的情况下重新定义算法的某些步骤。
 */

public class TempleTest_main {
    public static void main(String[] args) {
        Template t1=new SubTemplate();//多态性
        SubTemplate t2=new SubTemplate();

        t1.spendTime();
        System.out.println("*****************************");
        t2.spendTime();
    }
}


//抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展、改造，但子类总体上会保留抽象类的行为方式。

//当功能内部一部分实现是确定的，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。