# Objective: Explain the need and benefit of Criteria Query

## What is Criteria Query?
Criteria Query is a programmatic and type-safe way to fetch data from a relational database using JPA/Hibernate. Instead of writing hardcoded HQL (Hibernate Query Language) or JPQL strings, you use Java objects and methods to construct the query dynamically.

## The Need for Criteria Query (Scenarios where it helps)
1. **Dynamic Queries:**
   Consider an e-commerce platform like Amazon. When searching for a "laptop," users have multiple optional filters (e.g., RAM size, CPU, Weight, Customer Review, Operating System). 
   * **With HQL/JPQL:** You would have to concatenate strings based on which filters the user selected, leading to messy, error-prone code full of `if/else` statements.
   * **With Criteria Query:** You can programmatically add filter predicates (conditions) to the `CriteriaBuilder` only if the user selected them. The query is built dynamically and safely.

2. **Type Safety:**
   Since Criteria Queries are built using Java objects, errors in field names or data types are caught at compile-time rather than at runtime (which commonly happens with string-based HQL/JPQL when you make a typo).

## Core Interfaces in Criteria Query
*   **`CriteriaBuilder`**: The factory used to construct the criteria query, expressions, predicates (WHERE clauses), and orderings. You obtain this from the `EntityManager`.
*   **`CriteriaQuery`**: Represents the actual query being built. It holds the SELECT, FROM, WHERE, and ORDER BY clauses.
*   **`Root`**: Represents the entity in the FROM clause of the query. It is used to define the starting point of the query and to access the entity's attributes for building conditions.
*   **`TypedQuery`**: An interface used to control the execution of the typed criteria query. It is created by the `EntityManager` by passing in the constructed `CriteriaQuery`.

## Summary
While HQL and JPQL are great for static, fixed queries (like `@Query("SELECT e FROM Employee e")`), **Criteria Query is the best solution for complex, dynamic queries** where the filter conditions change based on user input at runtime.
