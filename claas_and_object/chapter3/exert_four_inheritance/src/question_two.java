public class question_two {
    public static void main(String[] args) {
        Father f = new Father();
        Son s = new Son();
        System.out.println(f.getInfo());//woshisb
        System.out.println(s.getInfo());//woshisb
        s.test();//woshisb，woshisb

        System.out.println();

        s.setInfo("我是弱智");
        System.out.println(f.getInfo());//woshisb
        System.out.println(s.getInfo());//我是弱智
        s.test();//我是弱智 我是弱智
    }
}

class Father {
    private String info = "woshisb";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Son extends Father {
    private String info = "我是傻逼";

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }

}

//在子类方法中 或者 通过子类对象访问成员时：
//
//如果访问的成员变量子类中有，优先访问自己的成员变量
//如果访问的成员变量子类中无，则访问父类继承下来的，如果父类也没有定义，则编译报错
//如果访问的成员变量与父类中成员变量同名，则优先访问自己的
//成员变量访问遵循就近原则，自己有优先自己的，如果没有则向父类中找


