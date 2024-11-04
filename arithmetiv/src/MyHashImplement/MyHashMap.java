package MyHashImplement;
import java.util.NoSuchElementException;

//Java 泛型的类型擦除和数组的特性引起的。具体来说，Java 不允许直接创建泛型数组，因此你需要使用 Object 数组并进行类型转换

public class MyHashMap<K,V> {

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;   // 确保类型安全

        // 创建 Node 的内部类
        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 当前哈希表中实际存储元素的个数
    private int size;
    // 默认哈希表的长度
    private static final int DEFAULT_CAPACITY = 16;
    // 默认负载因子
    private static final double LOAD_FACTOR = 0.75;
    // 实际存储的 key-value 的数组
    private Node<K, V>[] data;  // 声明为 Node<K, V> 数组，使用 Object 数组
    // 哈希运算：取模
    private int M;


    public MyHashMap() {
        this(DEFAULT_CAPACITY);  //直接调用下边的方法
    }

    //注解，用于告诉 Java 编译器在特定的代码段中忽略与“未检查转换”（unchecked cast）相关的警告。这个警告通常出现在你尝试将一种类型的对象强制转换为另一种类型，特别是在使用泛型时
    @SuppressWarnings("unchecked")
    public MyHashMap(int initCap) {
        // 使用 Object 数组并进行强制转换
        data = (Node<K, V>[]) new Node[initCap];
        this.M = initCap;
    }

    // 添加操作
    public void put(K key, V value) {
        // 获得索引
        int index = hash(key);
        // 查找是否存在 key
        for (Node<K, V> node = data[index]; node != null; node = node.next) {
            if (node.key.equals(key)) {
                // 说明 key 已存在，那就更新 value 的值
                node.value = value;
            }
        }
        // 不存在 key,那就新增
        Node<K, V> newNode = new Node<>(key, value, data[index]);  //构建一个新的 Node
        data[index] = newNode;   // 相当于头插，新创建的节点（newNode）设置为哈希表中指定索引（index）位置的头节点
        size++;
        // 判断是否需要扩容
        if (size >= LOAD_FACTOR * data.length) {
            // 扩容
            resize();
        }
    }

    // 哈希表扩容
    @SuppressWarnings("unchecked")
    private void resize() {
        // 建立新的哈希表，长度为原来的二倍
        this.M = M * 2;
        Node<K, V>[] newData = new Node[M];
        // 遍历原表中的所有 key, 重新插入新表的位置
        for (Node<K, V> datum : data) {    // 遍历原哈希表的每一个哈希桶
            for (Node<K, V> j = datum; j != null; ) {   //遍历每个链表中的节点 j, 它被赋值为当前桶（链表）的头节点 datum
                int newIndex = hash(j.key);
                // 暂存 j 的后继节点
                Node<K, V> next = j.next;
                // 将 j 插入 newData 中的 newIndex 处
                j.next = newData[newIndex];
                newData[newIndex] = j;   //节点 j 插入到新数组 newData 中的相应位置，更新指针
                // 再搬移原来桶中的下一个节点
                j = next;
            }
        }
        // 更新引用
        this.data = newData;
    }

    // 删除操作
    public V remove(K key) {
        int index = hash(key);
        Node<K, V> prev = data[index];
        // 先看看是不是头节点
        if (prev != null && prev.key.equals(key)) {
            // 删除 prev
            V val = prev.value;
            data[index] = prev.next;
            size--;
            return val;
        }
        while (prev != null && prev.next != null) {
            if (prev.next.key.equals(key)) {
                // 删除 prev 的后继节点
                Node<K, V> node = prev.next;
                V val = node.value;
                prev.next = node.next;
                size--;
                return val;
            }
            prev = prev.next;
        }
        // 不存在 key
        throw new NoSuchElementException("没有该 key 值！");
    }

    // 查找操作
    public V get(K key) {
        int index = hash(key);
        for (Node<K, V> x = data[index]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        throw new NoSuchElementException("没有该 key 值！");
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        for (Node<K, V> x = data[index]; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {
        // 遍历全表查询
        for (Node<K, V> datum : data) {
            for (Node<K, V> j = datum; j != null; j = j.next) {
                if (j.value.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 哈希函数
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;   // hashCode 返回对象的哈希码。哈希码是一个整数，同时M 是哈希表的大小。
    }

    public static void main(String[] args) {
        // 创建 MyHashMap 实例
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();

        // 插入元素
        myHashMap.put("apple", 1);
        myHashMap.put("banana", 2);
        myHashMap.put("orange", 3);

        // 查找元素
        System.out.println("Value for 'apple': " + myHashMap.get("apple")); // 输出: 1

        // 检查是否包含键
        System.out.println("Contains 'banana': " + myHashMap.containsKey("banana")); // 输出: true

        // 删除元素
        Integer OldValue =  myHashMap.remove("orange");
        System.out.println("remove value"+OldValue);
        System.out.println("Contains 'orange' after removal: " + myHashMap.containsKey("orange")); // 输出: false

        // 检查是否包含值
        System.out.println("Contains value 2: " + myHashMap.containsValue(2)); // 输出: true
        System.out.println("Contains value 3: " + myHashMap.containsValue(3)); // 输出: false

    }
}

