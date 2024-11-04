package HashTable;

import java.util.Hashtable;

public class HashTable_Operate {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();

        // 插入元素
        table.put("apple", 1);
        table.put("banana", 2);
        table.put("orange", 3);

        // 查找元素
        System.out.println("Value for 'apple': " + table.get("apple")); // 输出: 1

        // 检查是否包含键
        System.out.println("Contains 'banana': " + table.containsKey("banana")); // 输出: true

        // 删除元素
        table.remove("orange");

        // 遍历元素
        for (String key : table.keySet()) {
            System.out.println(key + ": " + table.get(key));
        }

        // 获取大小
        System.out.println("Size of table: " + table.size());
    }
}
