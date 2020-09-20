# Week3学习总结

​        本周学习了深度优先、广度优先算法；贪心算法及二分查找。

## DFS、BFS

​        在树或者图的情况下寻找特定的点。

​        DFS可以使用递归方法进行搜索遍历：

```java
public Set<Node> dfs(Node root) {
        Set<Node> visited = new HashSet<>();
        dfs_recur(visited, root);
        return visited;
    }

    private void dfs_recur(Set<Node> visited, Node root) {
        if (root == null) return;
        if (visited.contains(root)) return;
        visited.add(root);
        for (Node child : root.children) {
            if (!visited.contains(child)) 
                dfs_recur(visited, child);
        }
    }
```

​        DFS也可以用迭代的方法进行搜索遍历，借用栈：

```java
public Set<Node> dfs(Node root) {
        Set<Node> visited = new HashSet<>();
        if (root == null) return visited;

        Deque<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            if (visited.contains(node)) continue;
            visited.add(node);
            for (int i = node.children.size() - 1; i >= 0; i++) {
                stack.addLast(node.children.get(i));
            }
        }
        return visited;
    }
```

​        BFS一般直接用迭代方法，借用队列进行搜索：

```java
public Set<Node> bfs(Node root) {
        Set<Node> visited = new HashSet<>();
        if (root == null) return visited;
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            Node node = que.poll();
            if (visited.contains(node)) continue;
            visited.add(node);
            que.addAll(node.children);
        }
        return visited;
    }
```

​        BFS如果需要储存结果，可以在原迭代代码上增加储存的结构：

```java
public List<List<Node>> bfs_store(Node root) {
        List<List<Node>> store = new ArrayList<>();//如果需要返回每一层节点
        if (root == null) return store;
        Set<Node> visited = new HashSet<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Node> result = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                if (visited.contains(node)) continue;
                visited.add(node);
                result.add(node);
                que.addAll(node.children);
            }
            store.add(result);
        }
        return store;
    }
```

​        用递归的方法得到BFS层序遍历的结果，但实际底层是DFS实现：

```java
public List<List<Node>> bfs_store(Node root) {
        List<List<Node>> store = new ArrayList<>();//如果需要返回每一层节点
        if (root == null) return store;
        Set<Node> visited = new HashSet<>();
        gen_bfs(store, visited, root, 0);
        return store;
    }

    private void gen_bfs(List<List<Node>> store, Set<Node> visited, Node root, int level) {
        if (store.size() == level) store.add(new ArrayList<>());
        if (visited.contains(root)) return;
        store.get(level).add(root);
        for (Node child : root.children) {
            gen_bfs(store, visited, child, level + 1);
        }
    }
```



## 贪心算法

​        贪心算法是一种在每一步选择中都采取当前状态下最优解的算法。一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。

​        贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择并且不能回退；而动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，可以回退。

​        贪心法可以解决一些最优化问题：求图中最小生成树、求哈夫曼编码等。而对于工程和从生活中的问题，贪心法一般不能得到我们想要的答案。由于贪心的高效性以及其所求得的答案比较接近最优解，贪心法可以用作辅助算法或者直接解决一些要求结果不是特别精确的问题。有时可以在某一步用贪心算法，然后在全局加上搜索或递归。

### 适用贪心算法的场景

​        简单地说，问题能够分解成子问题来解决，子问题的最优解能递推到最终问题的最优解，这种子问题最优解成为最优子结构。



## 二分查找

​        二分查找的前提：

			1. 目标函数单调性	
   			2. 存在上下界

   				3. 能够通过索引访问

​        代码模板：

```java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

### 作业题

​        使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方。

思路：

1. 有序数组中，若发生旋转，必然满足nums[left] > nums[right]，可以此判断是否发生旋转的边界条件。
2. 用二分查找的方法，可以通过计算数组中间位置(mid = (left + right) / 2)的值是否大于left的值来判断无序开始的地方在mid的左边还是右边。
3. 当nums[mid] > nums[mid + 1]或nums[mid - 1] > nums[mid]，则可判断无序开始于此处。

```java
public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) return nums[0];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid - 1] > nums[mid]) return mid;
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
```

