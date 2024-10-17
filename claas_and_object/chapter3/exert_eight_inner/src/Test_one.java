public class Test_one {
    public static void main(String[] args) {

        //1.标准的写法
        SubA a=new SubA();
        a.method();//Sub A

        //2.举例1：提供接口匿名实现的对象
        A a1=new A(){
            public void method() {
                System.out.println("匿名实现类的重写的方法");
            }
        };
        a1.method();

        //3.举例2（极其的抽象）：提供接口匿名实现的匿名对象
        new A(){
            public void method() {
                System.out.println("匿名实现类的重写的方法");
            }
        }.method();

        //4.举例3：标准的写法
        SubB s1=new SubB();
        s1.method1();

        //5.提供继承于抽象类的匿名子类的对象
        B b=new B(){
            public void method1(){
                System.out.println("继承于抽象类的子类调用的方法");
            }
        };
        b.method1();
        System.out.println(b.getClass());//class Test_one$3  直接Test类中的
        System.out.println(b.getClass().getSuperclass());//class B     获取当前类的父类

        //6.继承于抽象类的子类调用的方法1
        new B(){
            public void method1(){
                System.out.println("继承于抽象类的子类调用的方法1");
            }
        }.method1();

        //7.直接的调用
        C c=new C();
        c.method2();

        //8.提供了一个继承于C的匿名子类的对象
        C c1=new C(){};
        c1.method2();
    }
}

interface A
{
    public abstract void method();
}

class SubA implements A{

    @Override
    public void method() {
        System.out.println("Sub A");
    }
}

abstract class B{
    public abstract void method1();
}

class SubB extends B {
    @Override
    public void method1() {
        System.out.println("Sub B");
    }
}

class  C{
    public void method2(){
        System.out.println("C");
    }
}


//匿名内部类不能定义任何静态成员、方法和类，只能创建匿名内部类的一 个实例。一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。

