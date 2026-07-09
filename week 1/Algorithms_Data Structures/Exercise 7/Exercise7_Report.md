# Exercise 7: Financial Forecasting

## 1. Understand Recursive Algorithms

### What is Recursion?
**Recursion** is a programming approach where a function calls itself to break down a larger problem into smaller, more manageable sub-problems of the same type. 

A well-designed recursive function always consists of two main parts:
1.  **Base Case:** A straightforward condition that halts the recursion. This prevents an infinite loop (or stack overflow).
2.  **Recursive Step:** The part of the code where the function actually calls itself, typically with modified parameters that bring it one step closer to the base case.

### How Recursion Simplifies Problems
Recursion is an incredibly powerful tool for mathematically expressive programming. It simplifies code when solving tasks that have a naturally repeating or branching structure—such as calculating compound interest over time periods, navigating file directories, or searching through trees. It often requires fewer lines of code compared to iterative approaches, making the developer's intent mathematically clear.

---

## 4. Analysis

### Time Complexity
*   **Time Complexity of this Recursive Algorithm: $O(n)$**
    Our `calculateFutureValue` method calls itself exactly $n$ times (where $n$ is the number of `periods` left to calculate). For each period, it performs a single multiplication. Since the number of operations scales linearly with the input $n$, the time complexity is $O(n)$.
*   **Space Complexity: $O(n)$**
    Each recursive call is added to the Java Call Stack. For $n$ periods, it places $n$ frames onto the call stack memory before it hits the base case and begins resolving. This gives it a space complexity of $O(n)$.

### Optimizing the Recursive Solution
While our current recursive solution is perfectly fine for basic financial forecasting over a few decades, large recursive algorithms can suffer from excessive computation or memory usage. Here is how we can optimize them:

1.  **Iterative Approach (Bottom-Up):**
    By converting the recursion into a standard `for` loop, we can eliminate the memory overhead associated with call stacks. The time complexity stays $O(n)$, but the space complexity drops to $O(1)$.
2.  **Memoization (Caching):**
    If the algorithm was making overlapping calls (like recursively generating the Fibonacci sequence), we could use Memoization. This involves saving the result of a sub-problem (e.g., in a `HashMap`) as soon as it's computed. Before doing any computation, the function checks the cache. This prevents the algorithm from doing redundant, excessive calculations.
3.  **Fast Exponentiation (Math Optimization):**
    Since the financial formula reduces to $FV = PV \times (1 + r)^n$, we don't actually need to apply it period by period. We could optimize the exponentiation process using a Divide-and-Conquer strategy (e.g., calculating $x^n$ by doing $x^{n/2} \times x^{n/2}$) which reduces the time complexity from $O(n)$ to $O(\log n)$.
