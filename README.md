# Java-Hash-Map-and-Binary-Tree
Data Structures Class Project

DATA STRUCTURES

Competencies:
4021.1.1: Introduction to Abstract Data Types, Algorithms, and Data Structures Using Bags (unordered lists) - The graduate explains how to design abstract data types (ADTs), data structures to represent an ADT in storage, algorithms to manipulate ADTs (using the Bag ADT as an example), describes bag data types, and the use of both sequential and linked allocation to implement them.
4021.1.2: Introduction to Analysis of Algorithms - The graduate analyzes the time and space complexity of basic algorithms.
4021.1.3: Stacks, Queues, and Deques - The graduate describes design, specification, implementation of stacks, queues, and deques, and implements a simple application using sequentially allocated queues as well as stacks that employ a linked allocation.
4021.1.4: Lists - The graduate describes design, specification, and implementation of list structures.
4021.1.5: Sorting and Sorted Lists - The graduate identifies basic selection and insertion sorting algorithms, as well as faster sorting algorithms, and describes the design and implementation of sorted lists.
4021.1.6: Basic Searching Algorithms and Associative ADTs - The graduate describes how to use searching algorithms for lists, and explains the concept of a dictionary as an associative ADT.
4021.1.7: Hashing Algorithms and Structures - The graduate describes hash tables, bucket hashing, this use as an efficient way to implement an associative ADT, and implements a simple application that uses bucket hashing.
4021.1.8: Tree Structures - The graduate describes tree structures and binary trees, and implements a simple application involving building and searching a binary tree.
Introduction:

For this performance assessment, you will demonstrate your ability to apply the use of the algorithms and data structures studied in this course to the solution of a real programming problem. You will implement an online address book and compare the use of a binary search tree and a bucket hash structure by implementing both for the design of the address book.

Scenario:

Your employer is developing an online phone book that stores names, phone numbers, and e-mail addresses. Your boss has asked you to build a prototype in Java to help decide on the best data structures to use for the implementation. You will need to implement and test a single application that has two implementations of the address book built in so that the data may be stored using each design.

Requirements:

Note: Do NOT use any of the data structures provided by the Java API (e.g., java.util.ArrayDeque, java.util.Collections, java.util.HashMap, java.util.HashSet, java.util.Hashtable). You must build data structures from the “ground up.”

Note: You must design, write, implement, and debug all code that you turn in for this assessment. Code downloaded from the Internet or acquired from another student or any other source may not be submitted and will result in automatic failure of the assessment.

Note: You will need the latest Java SE Development Kit (JDK). This includes the Java Runtime Environment (JRE) and command line development tools that are useful for developing applets and applications.
A.  Develop a hash table data structure from the ground up that does not use any of the data structure classes and that includes the following:
 
Note: For all insertions, deletions, and look-ups, the suggestion is to apply an upper case function to convert all letters in both the first and last name to upper case and concatenate to form a single name string.
 
1.  An insertion function that takes the following components as input and that inserts the data element into the hash table:
●   first name
●   last name
●   e-mail address
●   phone number
2.  A deletion function that takes the following components as input and that deletes the corresponding data element from the hash table:
●   first name
●   last name
3.  A look-up function that takes the following components as input and that returns the corresponding data element:
●   first name
●   last name
4.  Implementation of 13 buckets in the bucket hash structure.
 
Note: The hash function used for the hash table may call the Java native method hashCode() as part of its implementation.
 
B.  Develop a tree data structure that does not use of any of the data structure classes and that includes the following:
 
Note: For all insertions, deletions, and look-ups, the suggestion is to apply an upper case function to convert all letters in both the first and last name to upper case, and concatenate to form a single name string.
 
1.  An insertion function that takes the following components as input and that inserts the data element into the tree:
●   first name
●   last name
●   e-mail address
●   phone number
2.  A deletion function that takes the following components as input and that deletes the data element from the tree:
●   first name
●   last name
3.  A look-up function that takes the following components as input and that returns the data element from the tree:
●   first name
●   last name
 
C.  Develop an application that tests the following functions:
 
Note: Applications copied from another student or other source may not be submitted and are not eligible for passing the assessment.
 
1.  insertion function for the hash table
2.  deletion function for the hash table
3.  look-up function for the hash table
4.  insertion function for the tree data structure
5.  deletion function for the tree data structure
6.  look-up function for the tree data structure
 
D.  Use the attached test cases to verify that the hash table and tree data structure run correctly by providing one screenshot that demonstrates successful test execution for each of the following:
 
Note: Test execution screenshots copied from another student or other source may not be submitted and are not eligible for passing the assessment.
 
1.  insert function for the hash table
2.  delete function for the hash table
3.  look-up function for the hash table
4.  insert function for the tree data structure
5.  delete function for the tree data structure
6.  look-up function for the tree data structure
