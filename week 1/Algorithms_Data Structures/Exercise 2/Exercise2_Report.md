# Exercise 2: E-commerce Platform Search Function

## 1. Understand Asymptotic Notation

### Big O Notation
**Big O notation** is a mathematical notation used in computer science to describe the performance or complexity of an algorithm. Specifically, it describes the upper bound of the time complexity (how the execution time grows) or space complexity (how the memory usage grows) in the worst-case scenario as the input size ($n$) increases. It helps analyze how scalable an algorithm is.

### Scenarios for Search Operations
*   **Best-case scenario:** The element we are looking for is found at the very first position checked. The algorithm does the minimum possible amount of work.
*   **Worst-case scenario:** The element we are looking for is at the very last position checked, or it is completely absent from the collection. The algorithm has to perform the maximum possible number of checks.
*   **Average-case scenario:** The expected amount of work to find an element, assuming the element could be at any position with equal probability.

---

## 4. Analysis

### Time Complexity Comparison

| Algorithm | Best Case | Average Case | Worst Case |
| :--- | :--- | :--- | :--- |
| **Linear Search** | $O(1)$ | $O(n)$ | $O(n)$ |
| **Binary Search** | $O(1)$ | $O(\log n)$ | $O(\log n)$ |

### Algorithm Suitability for an E-commerce Platform

For an e-commerce platform, **Binary Search** is far more suitable and heavily preferred over Linear Search. 

**Why?**
An e-commerce catalog typically contains thousands or even millions of items (large $n$). 
*   If we use **Linear Search** ($O(n)$), searching through 1 million products could require up to 1,000,000 comparisons in the worst case, leading to noticeably slow page loads and a poor user experience.
*   If we use **Binary Search** ($O(\log n)$), searching through 1 million products would require at most about $\approx 20$ comparisons. This ensures lightning-fast search functionality.

**Caveat:** Binary Search strictly requires the underlying dataset to be **sorted**. While sorting an array has its own cost (typically $O(n \log n)$), an e-commerce platform usually handles far more read operations (searches) than write operations (adding new products). Therefore, keeping the data sorted (or using data structures that maintain sorted order, like self-balancing trees, or database indexes) pays off massively by allowing rapid $O(\log n)$ searches for customers.
