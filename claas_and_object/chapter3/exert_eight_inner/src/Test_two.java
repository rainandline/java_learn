class Person{
    String name;
    int age;
    public void eat(){}
    static class Dog{ //静态成员内部
    }
    class bird{ //非静态成员内部类
        String name;
        public void display(String name){
            System.out.println(name); //方法的形参
            System.out.println(this.name); //内部类的属性
            System.out.println(Person.this.name);//外部类的属性
        }
    }
}

class Person1{
    static class Dog{ //静态成员内部类

    }
    class Bird{ //非静态成员内部类

    }
}

class Test_two {
    public static void main(String [] args){
        //静态而言
        Person1.Dog dog = new Person1.Dog();

        //非静态而言
        Person1 p = new Person1();
        Person1.Bird bird =p.new Bird();
    }

}



//作为外部类的成员：调用外部类的结构,可以被static修饰,可以被四种不同的权限修饰；
//作为一个类：类内可以定义属性、方法和构造器等；
//可以被final修饰，表示此类不能被继承。言外之意，不使用final就可以继承；可以被abstract修饰；

//只能在声明它的方法或代码块中使用，而且是先声明后使用。除此之外的任何地方都不能使用该类；
//但是它的对象可以通过外部方法的返回值返回使用，返回值类型只能是局部内部类的父类或父接口类型

//局部内部类的特点：
//内部类仍然是一个独立的类，在编译之后内部类会被编译成独立的.class文件，但前面冠以外部类的类名和$符号，以及数字编号。
//只能在声明它的方法或代码块中使用，而且是先声明后使用。除此之外的任何地方都不能使用该类。
//局部内部类可以使用外部类的成员，包括私有的。
//局部内部类可以使用外部方法的局部变量，但是必须是final的。由局部内部类和局部变量的声明周期不同所致。
//局部内部类和局部变量地位类似，不能使用public,protected,缺省,private。
//局部内部类不能使用static修饰，因此也不能包含静态成员。


//成员内部类和局部内部类，在编译以后，都会产生字节码文件。
//成员内部类：外部类$内部类名.class
//局部内部类：外部类$数字 内部类名.class