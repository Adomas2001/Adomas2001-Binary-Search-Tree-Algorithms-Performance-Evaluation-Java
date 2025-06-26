# Binary Search Tree Algorithms & Performance Evaluation (Java)

This project explores the implementation and performance benchmarking of Binary Search Trees (BST) and AVL Trees in Java. It includes custom data structure development, algorithm benchmarking using JMH, and optional enhancements for verifying balance and advanced tree traversal methods.

## 📚 Overview

Lab 2 is divided into **mandatory** and **optional** parts, covering both theoretical and practical understanding of binary trees.

---

## ✅ Mandatory Part

### 🔧 Data Structure Implementation

Implemented in `BstSet<E>` and `AvlSet<E>` classes:

- `remove(E element)` and helper recursive methods
- `addAll(Set<E> set)` – Add unique elements from another set
- `containsAll(Set<E> set)` – Membership test
- `retainAll(Set<E> set)` – Retain common elements
- `headSet(E e)`, `tailSet(E e)`, `subSet(E e1, E e2)` – Range-based subset operations

### ⚡ Performance Benchmarking with JMH

- Compared method pairs (e.g. `remove()` in `BstSet` vs `AvlSet`)
- Benchmarked runtime performance across increasing dataset sizes
- Recorded:
  - Asymptotic complexities
  - CPU & memory specs of test machine
  - Graphs of execution time vs input size
- Conclusions drawn on performance reliability vs theoretical expectations

---

## 🧪 Optional Enhancements

- 🧮 **k-Balanced Tree Validator**: Check if BST’s height difference ≤ *k*
- 🔍 **Is BST Valid?**: Validate a tree’s binary search property
- 🌳 **Convert Tree to LinkedList**: Linearize BST nodes into a singly linked list
- 🔁 **Vertical Layer Traversal**: Level-by-level and vertical order traversal
- 🔎 **Path Sum Checker**: Determine if a node path adds up to a target sum
- 🔄 **Non-recursive Tree Operations**: Iterative alternatives for common tasks

---

## 🛠️ Technologies Used

- Java 17+
- JMH (Java Microbenchmark Harness)
- IntelliJ / NetBeans

---


