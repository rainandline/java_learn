
import java.util.Scanner;


class A{
    int m;
    int getM(){
        return m;
    }
    int seeM(){
        return m;
    }
}

class B extends A{
    int m;
    int getM(){
        return m + 100;
    }
}

public class Main {
    public static void main(String[] args) {
        String str="ABCDEFG";
        char[] chars=str.toCharArray();
        System.out.println(new String(chars,1,3));
    }
}
