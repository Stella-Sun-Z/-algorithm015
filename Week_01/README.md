# Week1 学习总结
## 本周学习内容总结
&nbsp;&nbsp;&nbsp;&nbsp;本周学习了数组、链表、栈、队列几种基本数据结构，又在此基础上学习了几种衍生数据结构：跳表、优先队列、双端队列。需要掌握这些数据结构的原理、应用场景及基本的实现代码，还需要熟练分辨相应的获取、查找、插入、删除操作的时间复杂度。
## LeetCode题目小结
&nbsp;&nbsp;&nbsp;&nbsp;本周刷题主要集中在数组和链表题上。数组相关的题目很容易在第一时间找不到思路，可以采用五毒神掌，后期慢慢转化为自己的。  
&nbsp;&nbsp;&nbsp;&nbsp;这两类题，尤其是数组，经常会使用双指针、快慢指针、双指针夹逼等方法，要熟练掌握此类代码。  
&nbsp;&nbsp;&nbsp;&nbsp;链表类题目，大多可以用迭代和递归两种法，都可以尝试写一下；注意熟练操作前后指针变换，脑中理不顺的时候可以试着在纸上画出指针变换路径。链表题目经常容易因为代码顺序导致陷入死循环或者报错等问题，一定要想清楚指针更改的前后顺序。
## 分析Priority Queue源代码
&nbsp;&nbsp;&nbsp;&nbsp;优先队列可以被看作是二叉堆，由自定义comparator来判断先后顺序或者依照元素的自然顺序，最小值在queue[0]。  
**扩容机制：**  
&nbsp;&nbsp;&nbsp;&nbsp;利用grow(int minCapacity)函数实现。  
&nbsp;&nbsp;&nbsp;&nbsp;当原容量< 64 时，新容量为原来的2倍 + 2，如果大于等于 64 时扩容为原来的 1.5 倍。  
&nbsp;&nbsp;&nbsp;&nbsp;如果新容量大于最大size限制，新容量就转化为超大容量。  
**添加元素：**  
&nbsp;&nbsp;&nbsp;&nbsp;添加元素的方法有两个，分别是 add 与 offer， add 内部调用的是 offer 方法。  
&nbsp;&nbsp;&nbsp;&nbsp;如果数组容量不够，就进行扩容。  
&nbsp;&nbsp;&nbsp;&nbsp;除了第一次插入元素外，都调用siftUp函数进行调整，假如没有自定义比较器，siftUp则由siftUpComparable方法实现。  
&nbsp;&nbsp;&nbsp;&nbsp;具体实现方法即循环与父节点比较大小，调整插入到对应的位置上。  
**移除元素：**  
&nbsp;&nbsp;&nbsp;&nbsp;移除的方法有remove和poll，poll每次移除最小的顶部元素，remove可以移除第一次出现的指定元素，后续的重复出现该元素不移除。    
**其它方法：**  
&nbsp;&nbsp;&nbsp;&nbsp;peek：返回顶部元素；  
&nbsp;&nbsp;&nbsp;&nbsp;removeAt：移除某个位置的元素；  
## 作业题：
&nbsp;&nbsp;&nbsp;&nbsp;用 add first 或 add last 这套新的 API 改写 Deque 的代码
```java
public class MyDeque {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        deque.addLast("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str1 = deque.peek();
        System.out.println(str1);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }
```
