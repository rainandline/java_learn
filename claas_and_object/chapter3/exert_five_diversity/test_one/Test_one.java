class Animal1 {
    String name;
    int age;
    //构造方法
    public Animal1(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name + "正在吃食物~~~");
    }
}
class Cat1 extends Animal1 {
    //构造方法
    public Cat1(String name,int age) {
        super(name,age);
    }
}

public class Test_one {
    public static void main(String[] args) {
        Cat1 cat = new Cat1("布偶", 3);
        Animal1 animal1 = cat;
        animal1.eat();//布偶正在吃食物~~~

        Animal1 animal2 = new Cat1("橘猫", 2);
        animal2.eat();//橘猫正在吃食物~~~
    }
}


//父类对象直接引用子类对象就叫做向上转型