# Week2 学习总结

​        本周学习内容为哈希Map、Set，树、二叉树、二叉搜索树，堆、二叉堆、图。



## 哈希表

​        哈希表是常用的数据结构，在需要大量查找时即应想到使用该结构。对源码的分析在文末。

​        在做题时，涉及到利用value计数时采用getOrDefault()函数可以减少代码量，十分方便。

​        一般在需要修改value时使用put函数直接覆盖；在value是List等结构时直接修改value更方便。



## 树、二叉树

​        树的结构可以简单看作无环多下指针的链表结构。重点掌握前中后遍历代码，利用递归的方法。

​        二叉搜索树的查找、插入、删除操作都是logn的时间复杂度。空树也是二叉搜索树。定义中，是左子树上所有节点的值均小于根节点，右子树上所有节点的值均大于根节点。



## 堆、二叉堆

​        堆是指可以迅速找到一堆数中最大或者最小值的数据结构，常见有二叉堆、斐波那契堆。

​        一般需要熟练掌握二叉堆，对于大顶堆：查找O(1)、删除O(logN)、插入O(logN)或O(1)。二叉堆一般都是通过数组实现的。在题目中使用堆结构，可以用priorityDeque。

​	    索引为i的左孩子的索引是：(2 * i + 1);

​	    索引为i的右孩子的索引是：(2 * i + 2);

​	    索引为i的父节点的索引是：floor((i - 1) / 2);

​	    删除操作：堆尾元素替换到顶部，依次从根部向下调整整个堆结构

​		插入操作：新元素先插到堆的尾部，依次向上调整整个堆结构



## HashMap源码分析

### 1. 总述

​        由数组+链表（+红黑树）组成，综合了数组和链表的特性，查找、插入、删除效率都高。在一条长度为n的数组中，每个元素存储的都是链表的头结点，根据键的hashCode值对数组长度取模决定存储数据位置。非线程安全，若需保证线程安全，可用ConcurrentHashMap。

### 2. 内部实现

​        **Node<K, V>**：存储在链表里的是HashMap内部定义的Node<K, V>对象，本质是一个键值对。

```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash; //定位数组索引位置
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }
    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
    public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```

​        **Node<K,V>[] table**：哈希桶数据。Capacity必须是2的整数幂，默认16；长度最大值为2^30。loadFactor是负载因子，对时间和空间效率平衡的情况下，选择默认0.75。threshold是HashMap所能容纳的最大的键值对个数，threshold = capacity * loadFactor，超出threshold这个数目就要resize，扩容后的容量是之前的2倍。当链表中的元素个数超过8，但Node<K,V>[] table长度没有超过64时，对数组进行扩容，否则链接结构转换为红黑树。

```java
transient Node<K,V>[] table;
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
static final int MAXIMUM_CAPACITY = 1 << 30;
static final float DEFAULT_LOAD_FACTOR = 0.75f;
static final int TREEIFY_THRESHOLD = 8;
static final int UNTREEIFY_THRESHOLD = 6;
static final int MIN_TREEIFY_CAPACITY = 64;
```

### 3. 构造方法

​        可以通过空、给定初始容量、装载因子或直接复制一个Map对象来初始化。

```java
public HashMap(int initialCapacity, float loadFactor){...}
public HashMap(int initialCapacity){...}
public HashMap(){...}
public HashMap(Map<? extends K, ? extends V> m){...}
```

### 4. put方法

​        首先用hash(key)函数计算出key的hash值，然后用putVal实现put方法。

​        put方法执行逻辑图：

![img](https://img-blog.csdnimg.cn/20190610175315294.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3l3bG1zbTEyMjQ4MTE=,size_16,color_FFFFFF,t_70)

### 5. get方法

​        和put一样，用hash(key)函数计算出key的hash值，然后用getNode实现get方法。

​        判断是否是首节点、判断首节点是红黑树还是链表节点，按照相应的算法一层一层找。





















