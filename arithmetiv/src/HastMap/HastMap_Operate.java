package HastMap;

import java.util.HashMap;

public class HastMap_Operate {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("apple",1);
        map.put("banana",2);
        map.put("orange",3);

        // 查找元素
        System.out.println("Value for 'apple': " + map.get("apple")); // 输出: 1

        // 检查是否包含键
        System.out.println("Contains 'banana': " + map.containsKey("banana")); // 输出: true

        // 删除元素
        map.remove("orange");

        // 遍历元素
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // 获取大小,哈希表中有几个键值对
        System.out.println("Size of map: " + map.size());
    }
}
