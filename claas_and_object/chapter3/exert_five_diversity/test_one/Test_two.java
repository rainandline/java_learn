class Animal2 {
    String name;
    int age;
    //构造方法
    public Animal2(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name + "正在吃食物~~~");
    }
}
class Dog2 extends Animal2 {
    //构造方法
    public Dog2(String name,int age) {
        super(name,age);
    }
    public void eat(){
        System.out.println(this.name + "正在吃狗粮~~~");
    }
}
class Cat2 extends Animal2 {
    //构造方法
    public Cat2(String name,int age) {
        super(name,age);
    }
    public void eat(){
        System.out.println(this.name + "正在吃猫粮~~~");
    }
}

public class Test_two {
    public static void main(String[] args) {

        Animal2 animal1 = new Dog2("哈士奇",2);
        animal1.eat();//哈士奇正在吃狗粮~~~
        Animal2 animal2 = new Cat2("橘猫",2);
        animal2.eat();//橘猫正在吃猫粮~~~
    }
}

//当我们的子类继承了父类后，
//我们对父类中的方法不改变其方法名，参数列表，返回值，我们只改变方法内部的细节，


//类在重写父类的方法时，一般必须与父类方法原型一致： 返回值类型 方法名 (参数列表) 要完全一致
//被重写的方法返回值类型可以不同，但是必须是具有父子关系的
//访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类方法被public修饰，则子类中重写该方法就不能声明为 protected
//父类被static、private修饰的方法、构造方法都不能被重写
//重写的方法, 可以使用 @Override 注解来显式指定. 有了这个注解能帮我们进行一些合法性校验. 例如不小心
//将方法名字拼写错了 (比如写成 aet), 那么此时编译器就会发现父类中没有 aet 方法, 就会编译报错, 提示无法构成重写

//多态的运用是虚拟方法的调用，再多态下调用方法时
//编译时认为时左边声明的父类方法，实际执行的时子类重写父类的方法

//多态仅仅适宜于方法，不适应属性，看那个左边的对象就行

//如果我们要实现多态，就需要在继承体系之下并且子类必须要对父类中的方法进行重写，然后通过父类的引用调用重写的方法