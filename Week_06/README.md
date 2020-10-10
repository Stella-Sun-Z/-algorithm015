# Week6学习笔记

​        动态规划 - Dynamic programming，本质上就是解决递归、分治问题。只是相对普通的分治，拥有最优子结构，即：dp = Divide & Conquer + Optimal substructure。Simplifying a complicated problem by breaking it down into simpler subproblems.(in a recursive manner)

### 动态规划关键点

​		动态规划和递归或分治没有根本上的区别（关键看有无最优的子结构）；

​		共性：找到重复子问题

​		差异性：最优子结构、中途可以淘汰次优解

### 三步走

​		1. 最优子结构 ：opt[n] = best_of(opt[n - 1], opt[n - 2], ...)

​		2. 储存中间状态：opt[i]

​		3. 递推公式：

​			一维(fib)：opt[n] = opt[n - 1] + opt[n - 2]

​			二维：opt[i, j] = opt[i + 1, j] +opt[i, j + 1] 

​		需要养成以上三步的思路，对于不是很难的dp题目，最重要的是第二步，只要能定义正确状态，基本都可以解出来；对于难的dp，第三步的递推公式不好找，此为难点。

### Fibonacci数列

​		加缓存的递归：（自顶向下的方式）

```java
int fib (int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    if (memo[n] == 0) {
        memo[n] = fib(n - 1) + fib(n - 2);
    }
    return memo[n];
}
```

​		也可以用循环实现自底向上，一般到后期都直接采用该方法：

```java
int fib (int n, int[] memo) {
    if (n <= 1) {
        return n;
    }
    for (int i = 2; i <= n; ++i) {
        memo[i] = memo[i - 1] + memo[i - 2];
    }
    return memo[n];
}
```

