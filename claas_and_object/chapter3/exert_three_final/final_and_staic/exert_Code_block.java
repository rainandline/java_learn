import java.util.HashMap;

class helloA{
    public helloA()
    {
        System.out.println("HelloA");
    }

    {
        System.out.println("I am a A class");
    }

    static {
        System.out.println("static A");
    }
}

class helloB extends helloA
{
    public helloB()
    {
        System.out.println("Hello b");
    }

    {
        System.out.println("I am a B class");
    }

    static {
        System.out.println("static B");
    }
}

public class exert_Code_block {
    public static void main(String[] args) {
        new helloB();
    }
}

//静态代码块和非静态代码块：
//一个类中代码块若有修饰符，则只能被static修饰，称为静态代码块 (static block)，没有使用static修饰的，为非静态代码块。
//注意：代码块的加载要早于构造器的加载；


//静态代码块：用static 修饰的代码块
//可以有输出语句。
//可以对类的属性、类的声明进行初始化操作。
//不可以对非静态的属性初始化。即：不可以调用非静态的属性和方法。
//若有多个静态的代码块，那么按照从上到下的顺序依次执行。
//静态代码块的执行要先于非静态代码块。
//静态代码块随着类的加载而执行，且只执行一次。

//非静态代码块：没有static修饰的代码块
//可以有输出语句。
//可以对类的属性、类的声明进行初始化操作。
//除了调用非静态的结构外，还可以调用静态的变量或方法。
//若有多个非静态的代码块，那么按照从上到下的顺序依次执行。
//每次创建对象的时候，都会执行一次。且先于构造器执行。

//①默认初始化；
//②显式初始化/⑤在代码块中赋值；（赋值谁先谁后看顺序）
//③构造器初始化；
//④有了对象以后，可以通过“对象.属性” 或者“对象.方法”的方式，进行赋值；
//赋值（结构）顺序：①——②| ⑤——③——④


//类中结构执行顺序的总结：
//由父及子，静态先行；