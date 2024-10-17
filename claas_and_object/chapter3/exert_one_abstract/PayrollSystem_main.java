/**
 * 创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型，name,number,birthday,以及该对象生日。
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 */
public class PayrollSystem_main {
    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        emps[0] = new SalariedEmployee("xiaoming", 1001, new MyDate(1992, 12, 21), 18000);
        emps[1] = new HourlyEmployee("xiaohui", 456465, new MyDate(2005, 2, 14), 100.0, 120);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].toString());
            System.out.println("工资为；" + emps[i].earning());

        }
    }
}

//一：
//抽象（abstract）概念引入：
//随着继承层次中一个个新子类的定义，类变得越来越具体
//而父类则更一 般，更通用。类的设计应该保证父类和子类能够共享特征。有时将一个父类设计得非常抽象，以至于它没有具体的实例，这样的类叫做抽象类。

//abstract修饰类：抽象类
//①用abstract关键字来修饰一个类，这个类叫做抽象类。
//②抽象类不能被实例化。抽象类是用来被继承的，抽象类的子类必须重写父类的抽象方法，并提供方法体。若没有重写全部的抽象方法，仍为抽象类。
//                                                 |->（在父类中类比于只有方法的声明，没有方法体，具体不同的子类重写不同的抽象方法）
//③抽象类中一定有构造器，便于子类实例化时调用

//abstract使用注意：
//①不能用abstract修饰变量、代码块、构造器；
//②不能用abstract修饰私有方法、静态方法、final的方法、final的类。