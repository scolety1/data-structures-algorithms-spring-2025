# Data Structures and Algorithms — Spring 2025

A collection of Java course exercises uploaded by Spencer Colety. Keep this as one browsable archive rather than many tiny repositories.

## Independently written sample

Spencer Colety confirmed on November 14, 2026 that he personally wrote the [`insert`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L19) and [`inOrder`](https://github.com/scolety1/data-structures-algorithms-spring-2025/blob/main/Jan30_2/src/jam30/BinarySearchTree.java#L71) methods in `Jan30_2/src/jam30/BinarySearchTree.java`. `insert` iteratively descends the tree, rejects duplicates and sets parent links; `inOrder` recursively visits left subtree, value and right subtree. This attribution is based on his firsthand confirmation, not inferred from the bulk-upload commit.

The claim covers those two methods only. Other methods, support classes and exercises may include lecture or starter material; their independent authorship is not established. This is an unbalanced binary search tree, so insertion can take linear time in the worst case.

## Where to start

Read [binary search tree](Jan30_2/src/jam30/BinarySearchTree.java), [hash table](Lab_05/src/lab5/HashTable.java), and [graph representation](Lab_08/src/lab8/UndirectedGraph.java). These show explicit data representations, traversal and control flow rather than framework glue. Dated lecture folders, labs and larger assignments remain separate; not every folder is a completed application.

## Run a verified example

Verified with Java 21 on November 14, 2026. From the repository root:

```sh
javac -d build/demo Jan30_2/src/jam30/BinarySearchTree.java Jan30_2/src/jam30/BinarySearchTreeDemo.java Jan30_2/src/jam30/Node.java
java -cp build/demo jam30.BinarySearchTreeDemo
```

Compilation and the sample program completed successfully. The sample inserts integers, prints in-order traversal, then height and a cousin query. It is a smoke demonstration, not comprehensive correctness proof; other folders include unfinished exercises.

## Contribution and reuse

The Git history records a bulk upload by `scolety1`, which establishes collection stewardship but does not distinguish student-authored methods from instructor starter code, examples or teammate work. Existing source credits remain authoritative. This archive should not be represented as wholly original or independently hand-coded without file-level confirmation.

No new assignment solutions or instructor materials were added for this documentation update. Course restrictions and third-party rights still apply; public availability is not a blanket reuse license. This README was prepared with AI assistance. The exercise source was left unchanged.
