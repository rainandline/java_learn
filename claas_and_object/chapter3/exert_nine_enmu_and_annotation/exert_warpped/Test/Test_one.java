
public class Test_one {
    public static void main(String[] args) {

        //1.手动的实现装箱和拆箱
        //JDK5.0之前，拆装箱均是手动完成的。
        //手动装箱，可以使用包装类的构造器来完成，也可以使用 valueOf() 方法。
        //手动拆箱，以Integer类为例，需要用到 intValue() 方法。
        int temp = 19;
        //Integer integer_0 = new Integer(temp);      //划线表示该构造方法已过时
        //Integer integer_1 = new Integer(11);
        Integer integer_2 = Integer.valueOf(temp);
        //手动拆箱(包装/引用类型   ————>   基本类型)
        int tempI_0 = integer_2.intValue();     /*该方法的接收类型为int类型*/


        System.out.println("integer_2的值 = " + integer_2);
        System.out.println("tempI_0 = " + tempI_0);
        System.out.println("----------------------------------");



        //2.自动拆箱 : 实际上 底层仍然调用了valueOf() 方法。
        //自动装箱 : 实际上 底层仍然调用了intValue() 方法（以Integer包装类为例）
        Integer integer_3 = 199;    //（自动）装箱——其实底层调用的仍然是valueOf方法（可Debug）
        int tempI_1 = integer_3;    //（自动）拆箱——其实底层调用的仍然是intValue方法
        System.out.println("integer_3的值 = " + integer_3);
        System.out.println("tempI_1 = " + integer_3);
        System.out.println("----------------------------------");


    }
}

//包装类是为了让基本数据类型拥有引用数据的基本特性，继承了Number类，并且实现了若干接口。

//基本数据类型不是对象，不能使用类的方法；
// 因此， java针对基本类型提供了它们对应的包装类，八大基本数据类型，对应了八种包装类，以对象的形式来调用。
//包装类有了类的特点，使我们可以调用包装类中的方法。

//在形式上除了Integer和Character这两个包装类外，其他六个包装类的类名均是对应的基本类型首字母大写后得到的。
//Boolean类和Character类都没有继承Number类，它们都实现了一些相同的接口

//装箱 : 基本类型 ——> 包装类型（或者叫对象类型，引用类型)
//拆箱 : 包装类型 ——> 基本类型
//2.手动拆装箱 :
//JDK5.0之前，拆装箱均是手动完成的。
//动装箱，可以使用包装类的构造器来完成，也可以使用 valueOf() 方法。
//以Integer类为例，需要用到 intValue() 方法。


//!!!!!!对于valueOf()
//如果传入的int基本类型的值在这个范围内，我就不new新的Integer对象🌶，而是调用底层的缓冲数组。
// 通过追溯源码，我们可以得知这里的low和high 的实际范围是-128 ~ 127
//享元的形式，节省空间，调高效率