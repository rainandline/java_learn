public class Test_one_equal {
    public static void main(String[] args) {
        //案例
        //判断两个Person对象的额内容是否相等，如果两个对象的各个属性值
        //（内容一样即可，不需要对象（地址）相同）
        // 都一样则返回true 否则 返回 false
        Person person = new Person("Tom",18,'男');
        Person person2 = new Person("Tom",18,'男');
        Person person3 = new Person("kangkang",18,'男');
        System.out.println(person.equals(person2));//true
        System.out.println(person.equals(person3));//false

    }
}

//Person类
class Person{//Object类是所有类的父类 默认Person extends Object
    private String name;
    private int age;
    private char gender;
    //重写Object类中的 equals方法
    public boolean equals(Object obj) {
        if (this == obj) {//若两个对象是同一个对象，即地址相同直接返回true，无需再比较内容
            return true;
        }
        if (obj instanceof Person) {//先判断是否是Person，是才比向下转型，为了得到obj的各个属性
            //instance函数
            Person p1 = (Person) obj;//向下转型
            return this.name.equals(p1.name) && this.age == p1.age && this.gender == p1.gender;
        } else {//如果不是Person，则直接返回false
            return false;
        }
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender  ) {
        this.gender = gender;
    }

    public void test(char gender  ) {
        this.gender = gender;
    }
}

//equals方法
//1.equals：是Object类中的方法，只能判断引用类型，比较的时两个两个的对象的引用地址是否相同
//2.默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等。
//对于String File Date和包装类，他们都重写了Object类中的方法


//==是一个比较运算符
//1.==：既可以判断基本类型，又可以判断引用类型
//2.==：如果判断类型为基本类型，判断的值是否相等
//3.==：如果判断的是引用类型，判断的是地址是否相等，即是不是同一个对象



