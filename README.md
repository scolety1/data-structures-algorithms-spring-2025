# Data Structures and Algorithms — Spring 2025

My Java coursework from Spring 2025, covering trees, hashing, graphs and algorithm implementation.

## Binary search tree example

In [BinarySearchTree.java](Jan30_2/src/jam30/BinarySearchTree.java), I implemented iterative insertion with duplicate rejection and parent links, and recursive in-order traversal. The tree is unbalanced, so insertion can take linear time in the worst case.

## Where to start

Read [binary search tree](Jan30_2/src/jam30/BinarySearchTree.java), [hash table](Lab_05/src/lab5/HashTable.java), and [graph representation](Lab_08/src/lab8/UndirectedGraph.java). These show explicit data representations, traversal and control flow rather than framework glue. Dated lecture folders, labs and larger assignments remain separate; not every folder is a completed application.

## Run a verified example

Verified with Java 21 on November 14, 2026. From the repository root:

```sh
javac -d build/demo Jan30_2/src/jam30/BinarySearchTree.java Jan30_2/src/jam30/BinarySearchTreeDemo.java Jan30_2/src/jam30/Node.java
java -cp build/demo jam30.BinarySearchTreeDemo
```

Compilation and the sample program completed successfully. The sample inserts integers, prints in-order traversal, then height and a cousin query. It is a smoke demonstration, not comprehensive correctness proof; other folders include unfinished exercises.

## About this archive

This coursework comes from the period when I primarily wrote and debugged code directly, before adopting coding agents. Course examples and starter code retain their original attribution.

These exercises were originally developed and kept on my computer, then uploaded together in November 2026. The recent Git history reflects that upload, not when I wrote the coursework. Original lab and project folders are retained as separate exercises.

README presentation was updated with AI assistance; exercise source is unchanged.
