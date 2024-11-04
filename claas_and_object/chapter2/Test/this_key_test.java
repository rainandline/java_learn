
public class this_key_test {
    public static void main(String[] args) {
        Boy boy1 = new Boy("杰克", 24);
        Girl girl1 = new Girl("朱丽叶", 20);



        girl1.marry(boy1);
        //我想要嫁给杰克
        //我要娶朱丽叶

        boy1.shout();
        //我终于可以结婚啦

        Girl girl2 = new Girl("肉丝", 18);
        int compare = girl1.compare(girl2);
        if (compare > 0)
            System.out.println(girl1.getName() + "大");
        else if (compare < 0)
            System.out.println(girl2.getName() + "大");
        else
            System.out.println(girl1.getName() + girl2.getName() + "一样大");
        //朱丽叶大
    }
}

class Boy {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void marry(Girl girl) {
        System.out.println("我要娶" + girl.getName());
    }

    public void shout() {
        if (this.age >= 22)
            System.out.println("我终于可以结婚啦");
        else
            System.out.println("我只能谈恋爱");
    }
}

class Girl {
    private String name;
    private int age;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void marry(Boy boy) {
        System.out.println("我想要嫁给" + boy.getName());
        boy.marry(this);
    }

    /**
     * 比较两个Girl对象的大小
     *
     * @return 正数说明当前的对象大   负数说明当前的对象小  0表示相同
     */
    public int compare(Girl girl) {
        if (this.age > girl.age)
            return 1;
        else if (this.age < girl.age)
            return -1;
        else
            return 0;
    }
}


//构造器的特征:
//（1）它具有与类相同的名称;
//（2）它不声明返回值类型。（与声明为void不同）;
//（3）不能被static、final、synchronized(同步)、abstract、native修饰，不能有return语句返回值；

//构造器的定义格式：权限修饰符 类名(形参列表){ }
//1.如果没有显式的定义类的构造器的话，系统默认提供一个空参的构造器；
//2.一个类中定义多个构造器，构造器之间构成重载；
//3.一旦我们显式定义了构造器，则系统不会提供空参的构造器；
//4.每个类中至少有一个构造器；
//5.一个类可以创建多个重载的构造器；
//6.父类的构造器不可被子类继承；

//构造器重载：
//构造器重载，参数列表必须不同；构造器重载使得对象的创建更加灵活，方便创建各种不同的对象。

//赋值的位置：
//① 默认初始化 ；
//② 显式初始化 ；
//③ 构造器中初始化；
//④ 通过“对象.属性“或“对象.方法”的方式赋值；
//赋值的先后顺序： ① - ② - ③ - ④

//我们需要避免用户在使用“对象.属性”的方式对属性进行赋值。则需要将属性声明为私有的（private）------>此时，针对属性就体现了封装性；
//我们设置类的属性xxx私有化(private)，同时，提供公共的（public）方法来设置（setXxx()）和获取（getXxx()）属性值；

//封装性体现的条件：
//① java规定了4种权限（从小到大）：private、缺省、protected、public；
//② 4种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类；
//③ 具体的，4种都可以用来修饰类的内部结构：属性、方法、构造器、内部类；
//④ 修饰类的话，只能使用：缺省、public；

//this关键字理解:
//this可以用来修饰和调用：属性、方法、构造器。
//理解：当前对象   正在创建对象；

//this修饰属性或方法
//我们可以使用“this.属性” 或“this.方法”的方式，调用当前对象属性和方法。
//但是，通常情况下，我们都选择省略“this.”。特殊情况下，如果方法的形参和类的属性同名时，我们必须显式的使用“this.变量”的方式，表明此变量为属性

//this调用构造器：
//① 我们在类的构造器中，可以显式的使用“this(形参列表)”方式，调用本类中指定的其他构造器；
//② 构造器中不能使用“this(形参列表)”方式来调用自身构造器；
//③ 如果一个类中有n个构造器，则最多有n-1个构造器中有“this(形参列表)”结构； （避免出现调用循环）
//④ 规定：“this(形参列表)”必须声明在当前构造器的首行；
//⑤ 构造器内部，最多只能声明一个“this(形参列表)”结构，来调用其他构造器；
