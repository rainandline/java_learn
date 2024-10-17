package tool;
import java.util.*;

/**
 * 可用来方便地实现键盘访问。
 */

public class TSUtility {
    private static final Scanner scanner = new Scanner(System.in);
    //final 关键字防止 scanner 被重新赋值，即 scanner 引用的 Scanner 对象不会被更改为另一个 Scanner 对象。
    //但Scanner对象本身的状态和行为是可以改变的

    //！！！！个人理解：对于Scanner的对象只能有一个，即为scanner，不能被修改


    /**
     * 该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
     */
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            //此处的false是限制不能返回空的字符串

            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新选择：");
            } else
                break;
        }
        return c;
    }

    /**
     * 该方法提示并等待，直到用户按回车键后返回
     */
    public static void readReturn() {
        System.out.println("按回车键继续....");

        readKeyBoard(100, true);
        //允许用户输入最多 100 个字符，并允许空输入。

    }

    /**
     * @return 返回用户输入的整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);//将字符串包装为

                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 从键盘读取‘Y’或’N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            //toUpperCase() 是 String 类的方法，用于将字符串中的所有字符转换为大写。

            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }


    /**
     *@param limit  指定输入的最大长度
     * @param blankReturn 指定是否允许空输入
     * @return 返回用户输入的有效字符串
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        //scanner.hasNextLine() 是 java.util.Scanner 类的一个方法，用于检查输入中是否还有下一行。它返回一个布尔值：
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();//读取用户输入的一行
            if (line.isEmpty()) {
                if (blankReturn) //如果字符串可以为0，则可以直接的返回
                    return line;
                else continue;
            }

            if (line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }
}



