import org.junit.jupiter.api.Test;

@SuppressWarnings(value = "unused")
public class  Test_one {
    @Test
    public void teat(){
        System.out.println("hello");
    }
}


//是通用的测试 java 程序的测试框架JUnit可以对Java代码进行白盒测试。
//org.junit.Assert.* 断言，用于对比结果是否符合预期，用来判断测试结果的常用框架


//Annotation（注解）就是Java提供了一种元程序中的元素关联任何信息和着任何元数据（metadata）的途径和方法。
//Annotion(注解)是一个接口，程序可以通过反射来获取指定程序元素的Annotion对象，然后通过Annotion对象来获取注解里面的元数据。

//个Annotation可以将name=value对作为没有定义默认值的Annotation成员的值，当然也可以使用name=value对来覆盖其它成员默认值

//三个内置标准注解的作用和使用场景
//@Override，限定重写父类方法：
//@Deprecated，标记已过时：
//SuppressWarnnings，抑制编译器警告