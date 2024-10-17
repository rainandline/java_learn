class Person {
    private int id;
    private static int total = 0;
    public static int getTotalPerson() { //static修饰方法：静态方法
        //id++; //非法
        return total;
    }
    public Person() {  //无参构造器
        total++;
        id = total;
    }
}

public class exert_one {
    public static void main(String[] args) {
        System.out.println("Number of total is " + Person.getTotalPerson());  //类名直接调用静态方法
        //没有创建对象也可以访问静态方法
        Person p1 = new Person();
        System.out.println( "Number of total is "+ p1.getTotalPerson());  //创建对象，对象名调用静态方法
    }

}

//①实例变量：我们创建了类的多个对象，每个对象都有一套类中的非静态属性。当修改其中一个对象的非静态变量时，不会导致其他对象中同样的属性值的修改；
//②静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，修改过了的；

//静态变量随着类的加载而加载，可以通过“类.静态变量”的方式进行调用；
//静态变量加载要早于对象的创建；
//由于类只会加载一次，则静态变量在内存中也只存在一份，存在方法区的静态域中；

//①没有对象的实例时，可以用“类名.方法名()”的形式访问由static修饰的类方法。
//②在static方法内部只能访问类的static修饰的属性或方法，不能访问类的非static的结构。
//③static修饰的方法不能被重写。

//1）在静态方法中，不能使用this和super关键字；
//（2）关于静态属性和静态方法的使用，从生命周期的角度去理解（静态的结构随着类的加载而加载）；

//①属性可以被多个对象所共享的，不会随着对象的不同而不同；
//② 类中的常量也常常声明为static；