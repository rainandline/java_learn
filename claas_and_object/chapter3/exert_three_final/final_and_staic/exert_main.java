public class exert_main {
    public static void main(String[] args) {
        String[] arr = new String[]{"aa", "bb", "cc"};
        Mian.main(arr);
    }
}

class Mian{
    public static void main(String[] args) {//普通的静态方法
        System.out.println("Main的main()的调用");
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }
    }
}


//因为main() 方法是静态的，我们不能直接访问该类中的非静态成员，必须创建该类的一个实例对象后，才能通过这个对象去访问类中的非静态成员。

//main()方法作为程序的入口;
//main()方法也是一个普通的static（静态的）方法；
//main()方法可以作为我们与控制台的交互方法（之前，使用Scanner）；