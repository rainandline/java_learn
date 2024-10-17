public class Test_three {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(arr);

        char[] arr1={'a','b','c'};
        System.out.println(arr1);
    }
}

//对于非字符类型的数组：调用 toString 会输出数组对象的地址，这通常表现为一个内存地址的哈希值。
//对于字符类型的数组：调用 toString 会将数组中的字符连接起来，并输出这个字符串