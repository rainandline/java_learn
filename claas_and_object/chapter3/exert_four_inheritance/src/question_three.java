public class question_three {
    public static void main(String[] args) {
        Derived d = new Derived();
    }
}

class Base {
    public Base(){
        System.out.println("Base()");
    }
}

class Derived extends Base {
    public Derived() {
        super(); // 注意子类构造方法中默认会调用基类的无参构造方法：super(),
        // 用户没有写时,编译器会自动添加，而且super()必须是子类构造方法中第一条语句，
        // 并且只能出现一次
        System.out.println("Derived()");
    }
}

//这里用户没有写 super（）的话，编译器也会自动添加，因此输出结果也是一样的
//在子类构造方法中，super(...)调用父类构造时，必须是子类构造函数中第一条语句
//                                                     |->注定和this只能二选一

//在子类构造方法中，并没有写任何关于基类构造的代码，但是在构造子类对象时，先执行基类的构造方法，然后执行子类的构造方法.
//因为：子类对象中成员是有两部分组成的，基类继承下来的以及子类新增加的部分 .
//父子父子肯定是先有父再有子，所以在构造子类对象时候 ，先要调用基类的构造方法，将从基类继承下来的成员构造完整，
//然后再调用子类自己的构造方法，将子类自己新增加的成员初始化完整

