# Week3学习总结

​        本周学习内容为递归，铭记递归模板的前提下，练习写各类递归题：树的递归、分治、回溯。

## 递归模板

```java
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
}
```

​        一般写递归题目的时候，可以把具有重复性的模块单元单独写成递归函数，这样思路会比较清晰，不用考虑原函数递归的参数、返回值格式的问题。

​        递归函数模板，包括终止条件、当前层处理逻辑、下探公式、清理参数。此处最需要仔细的就是是否需要清理当前层改变过的函数，很多回溯的题目，比如全排列、组合等，都需要注意在终止条件中加入结果时，用拷贝后的函数，然后每一层返回前都要清理当前层的痕迹，否则会产生空结果或者错误的结果。



## 各类递归要点

​        树的题目一般都可以递归来解，因为树的定义本来就具有递归特性，且树的操作具有重复性（自相似性）。基本树的题目无外乎前序中序后续遍历、求深度类型，例如验证搜索二叉树就可以通过中序遍历加上判定条件解答。需要熟练各类遍历、各类判定条件、前中后遍历数组写法的关系。

​        分治、回溯即分不同条件递归下去再返回，split/merge，关键也是找最小重复子问题。

```java
private static int divide_conquer(Problem problem, params) {
  
  if (problem == NULL) {
    int res = process_last_result();
    return res;     
  }
  subProblems = split_problem(problem)
  
  res0 = divide_conquer(subProblems[0])
  res1 = divide_conquer(subProblems[1])
  
  result = process_result(res0, res1);
  
  return result;
}
```

​        分治与递归模板本质上别无二致，此类问题的关键点实际在如何拆解为子问题来解决该问题，需要通过练习不同类型的题目来积累经验，掌握一些常见的思路和解法。

​        回溯方法即通过递归调用反复试错，此路不通则转回上一层继续，典型题目即N皇后。此类题目也是得见多识广。