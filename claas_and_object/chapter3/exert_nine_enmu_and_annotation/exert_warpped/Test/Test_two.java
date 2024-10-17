public class Test_two {

    public static void main(String[] args) {

        //1.String和基本数据类型的转换（除了char)

        //parseXxx(String)，以对应的基本类型作接收
        byte temp_byte = Byte.parseByte("11");
        short temp_short = Short.parseShort("141");
        int temp_int = Integer.parseInt("430");
        long temp_long = Long.parseLong("11211");
        float temp_float = Float.parseFloat("66.66F");
        double temp_double = Double.parseDouble("666.666");
        boolean temp_boolean = Boolean.parseBoolean("true");

        System.out.println("temp_byte = " + temp_byte);
        System.out.println("temp_short = " + temp_short);
        System.out.println("temp_int = " + temp_int);
        System.out.println("temp_long = " + temp_long);
        System.out.println("temp_float = " + temp_float);
        System.out.println("temp_double = " + temp_double);
        System.out.println("temp_boolean = " + temp_boolean);

        //char数据的两种方式
        String string = "CSDN_yyds";
        //利用toCharArray() 方法将字符串转换为字符数组
        char[] charArray = string.toCharArray();
        //利用charAt方法来直接获取字符串中的每一个字符元素
        char temp_char_0 = string.charAt(0);



        //2.基本类型 ——> String类
        int temp_int_String = 428;
        String temp_string_2 = temp_int_String + "";
        System.out.println("temp_string_2 = " + temp_string_2);

        temp_string_2 = String.valueOf(temp_int_String) + "_EX";
        System.out.println("temp_string_2 = " + temp_string_2);


        //3.String类型和包装类的相互转化
        //方式一
        String string_0 = "141";
        Integer integer_0 = Integer.parseInt(string_0);
        //方式二
        String string_1 = "133";
        //Integer integer_1 = new Integer(string_1);
        System.out.println("integer_0的值 = " + integer_0);

        //演示 : 包装类 ————> String类
        //方式一 :
        Integer integer_0_warp = 141;    //自动装箱
        String string_0_warp = integer_0_warp + "";
        //方式二 :
        Integer integer_1_warp = 135;
        String string_1_warp = Integer.toString(integer_1_warp) + " hello";
        //方式三 :
        Integer integer_2_warp = 431;
        String string_2_warp = String.valueOf(integer_2_warp) + " world";
        System.out.println("string_0 = " + string_0_warp);
        System.out.println("string_1 = " + string_1_warp);
        System.out.println("string_2 = " + string_2_warp);


    }

}

//除了Character类外，其他的7种包装类中都有parseXxx方法。
// 如果你想将字符串类型的数据转换成char类型的数据，你可以通过String类中的toCharArray() 方法和 charAt() 方法来做到。
//charAt() 方法。该方法接受一个索引作为参数，并返回指定索引位置的字符。
//char[] toCharArray() : 将字符串转换成字符数组


// 基本类型要转字符串那就太简单了，最常见的两种方式——①直接与空字符串进行拼接，②String类的valueOf方法。

//String类 ——> 包装类
//方式一 : Integer integer_0 = Integer. parseInt(字符串类型变量);
//方式二 : 利用包装类的 构造器，例如 : Integer integer_1 = new Integer(字符串类型变量);
//方式一中用到了parseInt方法，注意，我们在上文String类型转基本类型时就用到了parseInt方法，
// 但我们当时是用int类型变量来作接收的。当然，parseInt方法的返回值类型本来就是int类型，

//包装类 ——> String类
//方式一 : String xxx = 包装类变量名 + "";
//方式二 : String xxx = 包装类类名.toString();
//方式三 : String xxx = String.valueOf(...);
