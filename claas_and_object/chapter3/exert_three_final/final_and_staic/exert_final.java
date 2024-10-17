
public class exert_final {
    public static int totalNumber = 5;
    public final int ID;
    public exert_final() {
        ID = ++totalNumber; // 可在构造器中给final修饰的“变量”赋值
    }
    public static void main(String[] args) {
        exert_final t = new exert_final();
        System.out.println(t.ID);//输出6
        final int I = 10;
        final int J;
        J = 20;
       // J = 30; // 非法
    }
}

//final修饰属性：
//可以考虑赋值的位置有：显式初始化、代码块初始化、构造器中初始化;
//fianl 修饰局部变量：
//尤其是使用final修饰形参时，表明形参是一个常量。当我们调用此方法时，给常量形参赋一个实参。一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值；


//final标记的类不能被继承。提高安全性，提高程序的可读性。
//String类、System类、StringBuffer类
//final标记的方法不能被子类重写。
//比如：Object类中的getClass()。
//② final标记的变量(成员变量或局部变量)即称为常量。名称大写，且只能被赋值一次。


//static final ：用来修饰属性：全局常量
