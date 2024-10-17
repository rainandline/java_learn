public class Test_two_toString {
    public static void main(String[] args) {
        User u1=new User("tom",12);
        System.out.println(u1.toString());//User@2f4d3709
        System.out.println(u1);//User@2f4d3709

        String s1=new String("HELLO");
        System.out.println(s1.toString());//HELLO
    }
}

class User{
    String name;
    int age;


    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


//!!!这个地址值不是真实的内存中的地址，而是Java虚拟机中的地址

//对于String File Date和包装类，他们都重写了Object类中的方法,调用时返回实体内容
