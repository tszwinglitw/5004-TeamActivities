# Module 06 Team Activity  - Comparators and Sorting

In this Team Activity, you will explore using Comparable interface to sort objects in Java, along with specialized sorts using streams. You will also explore how to use the `Collections.sort()` method to sort objects in a collection. We will also explore the use of Sorted Collections in java such as the `TreeSet` and `TreeMap` classes.


## Grading
Grades for team activities will be based on attendance and notes. You must attend, and as a team you need to generate notes that we can confirm your work. Ideally, you upload the notes as a PDF to the team meeting after you build them out. 

> [!TIP] 
> Good notes become a study guide for you and your team! Make sure they include everything you need to help better understand the weekly material. 

### ⭐ Working in Teams ⭐
When working in teams, remember do not let one person do all the work. Make sure to work together, and ask questions. It is also better if different people program, and you all take turns programming for various team assignments.

## Learning Objectives
This team activity is designed to help you understand the following concepts:
* Implement the `Comparable` interface to sort objects in a collection
* Sort data using the `Collections.sort()` method and sorted() method in streams
* Sort data using lambda expressions 
* Use the `TreeSet` and `TreeMap` classes to keep data presorted in a collection


## Comparators and Sorting

In Java, there is the `Comparable` interface, that any object can implement. If that is implemented, then it is possible to sort and order objects as they are added to a collection. The `Comparable` interface has one method, `compareTo()`, that is used to compare two objects. The `compareTo()` method returns a negative integer, zero, or a positive integer if the object is less than, equal to, or greater than the specified object.

The question then becomes, what does this comparison mean. 

Let's look at String (which implements Comparable). Given the following example, what do you think the output will be?

```java
String s1 = "aloha";
String s2 = "world";


System.out.println(s1.compareTo(s2));

```

Now, let's try something a bit harder. What do you think the output will be? You just need to say greater than 0, less than 0, or zero!

```java
String a = "a";
String b = "b";
String A = "A";
String B = "B";

System.out.println(a.compareTo(b));
System.out.println(a.compareTo(a));
System.out.println(b.compareTo(a));

System.out.println();
System.out.println(A.compareTo(B));
System.out.println(B.compareTo(A));

System.out.println();
System.out.println(a.compareTo(A));
System.out.println(A.compareTo(a));
```

Now try running the code. The example is in the [solutions/StringComparableExamples.java](solutions/StringComparableExamples.java) file, or you can write your own and copy/paste it. 

### 👉🏽  Discussion
What were some surprises? Why do you think 'a' is greater than 'A'?

> [!WARNING]
> A common mistake in code is using comparable assuming the results are -1, 0, 1. As you can see from the example, less than 0, 0, greater than 0 is the correct answer.
> That is because java leaves it up to the implementation. In the case of strings, they convert it to the int value of the characters and subtract them, which
> can be negative, zero, or positive. 


## :fire: Java Practice Problem
As part of **every** team activity, we will ask you to work on a Java Practice problem, and submit the code to the team files section (or as part of your notes). This is meant to give you practice similar to technical interviews, but also help build up your java skills. **Each team member needs to select a different problem!** But you can share/and should share answers and help each other. Remember, to learn a new language, the best thing you can do is practice! Here are some resources to find practice problems but you are not limited to them:

* [CodeHS - Java Practice](https://codehs.com/practice/java)
* [Coding Bat - Java](https://codingbat.com/java)
* [Hacker Rank - Java(Basic)](https://www.hackerrank.com/domains/java?filters%5Bskills%5D%5B%5D=Java%20%28Basic%29)