
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = generateRandomArray(10, 0, 100);
        System.out.println("Original array");
        printArray(array);

        Quick_Sort(array, 0, array.length - 1);

        System.out.println("Sorted array");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static int[] generateRandomArray(int size, int minvalue, int maxvalue) {
        int[] array = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(maxvalue - minvalue + 1) + minvalue;
        }
        return array;
    }

    public static void Quick_Sort(int[] array, int low, int high) {
        if (low < high) {
            int privation = partition(array, low, high);
            Quick_Sort(array, low, privation - 1);
            Quick_Sort(array, privation + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (array[high] >= pivot && low < high)
                high--;
            array[low] = array[high];
            while (array[low] <= pivot && low < high)
                low++;
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}

//生成指定范围内的整数
//为了生成一个从 minValue 到 maxValue 的整数，我们需要调整生成的随机数的范围。
//rand.nextInt(maxValue - minValue + 1) 会生成一个从 0 到 (maxValue - minValue) 的整数。

//方法参数的值传递机制（重点）：
//①基本数据类型的变量，此时赋值是变量所储存的数据值；
//②引用数据类型的变量，此时赋值是变量所储存数据的地址值;
//注意：地址值类型一致时，才可以相互赋值。

//递归方法使用：
//一个方法体内调用它自身。
//方法递归包含了一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制。
//递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。

//我们程序设计追求的：
//高内聚：类的内部数据操作细节自己完成，不允许外部干涉。
//低耦合：仅对外暴露少量的方法用于使用。
//隐藏对象内部的复杂性，只对外公开简单的接口。便于外界调用，从而提高系统的可扩展性、可维护性。
//通俗的说，把该隐藏的隐藏起来，该暴露的暴露出来。这就是封装性的设计思想。
