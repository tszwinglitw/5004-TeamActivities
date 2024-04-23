# Module 04 Team Activity - Java Collections Framework

For this activity, we are going to explore the collections framework, and
how to manipulate data structures with the Stream object. 

## Grading
Grades for team activities will be based on attendance and notes. You must attend, and as a team you need to generate notes that we can confirm your work. Ideally, you upload the notes as a PDF to the team meeting after you build them out. 

> [!TIP] 
> Good notes become a study guide for you and your team! Make sure they include everything you need to help better understand the weekly material. 

### ⭐ Working in Teams ⭐
When working in teams, remember do not let one person do all the work. Make sure to work together, and ask questions. It is also better if different people program, and you all take turns programming for various team assignments.

## Learning Objectives
This team activity is designed to help you understand the following concepts:
- How to use the Collections Framework
- Key Data Structures in Java
- Understanding Polymorphism to simplify your code
- How to use the Stream object to manipulate data structures
- How to use the Stream object to filter data
- How to use the Stream object to sort data
- How to use the Stream object to map data
- How to use the Stream object to reduce data


## Collections Framework

Java quickly gained in popularity since it came out in 1996 due to three major features. The first was built in garbage collection. You had a 'c' like language that managed memory for you. The second was that it was advertised to write once, and run on every machine. The third was an extensive API of classes that "shipped" with the Java Development Kit (JDK). These are now called the [Java Core Libraries].


Of the core libraries, the Collections Framework is one of the most used. It is a set of classes and interfaces that implement commonly reusable data structures.  In python, you know of List and Dictionary, those are both data structures. In Java, you have a similar set of data structures, though types are more strictly enforced.

The Collection Framework has the following interfaces and associated classes:

```mermaid
---
Java Collections Framework
---
classDiagram
    Collection <|-- List
    Collection <|-- Set
    Collection <|-- Queue
    List <|-- ArrayList
    List <|-- LinkedList
    Set <|-- HashSet
    Set <|-- SortedSet
    SortedSet <|-- TreeSet
    Queue <|-- PriorityQueue
    Map <|-- SortedMap
    Map <|-- HashMap
    SortedMap <|-- TreeMap    
    class Collection{
        <<interface>>
    }
    class List{
        <<interface>>
    }
    class Set{
        <<interface>>
    }
    class Queue{
        <<interface>>
    }
    class SortedSet{
        <<interface>>
    }
    class Map{
        <<interface>>
    }
    class SortedMap{
        <<interface>>
    }
```
In the above diagram, the interfaces much of the framework, with the sample classes being listed for each item. Technically, classes like LinkedList implement both List and Queue, so isn't as simple as the diagram above.  Java has extensive documentation on [Collections].

For a comparison between Python and Java, dictionaries are like maps, lists are like lists, and sets are like sets.  


> [!NOTE]
> For more details beyond this course a good tutorial can be found at https://stackabuse.com/java-collections-the-list-interface/, and the java framework can be found at https://docs.oracle.com/en/java/javase/21/core/java-core-libraries1.html.  Along with the tutorial at https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html. 


### 👉🏽 Discussion
Thinking back to your 5001 class, what were some cases to use a List or Dictionary in Python? The Collections framework is a bit more detailed in giving you more control of the underlying data structure, but the fundamentals are similar. 


<!-- Links -->
[Java Core Libraries]: https://docs.oracle.com/en/java/javase/21/core/java-core-libraries1.html
[Collections]: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/package-summary.html#JavaCollectionsFramework

### The power of inheritance and polymorphism
When you are programming, you need to know which collection to use. The details of the types
of data structures are covered more in CS 5008, but it is worth seeing the differences between. 

Look for [ListRunner.java](ListRunner.java). The file is a simple program that shows
two major concepts.

1) Why you often want to declare to the interface, and not the specific object in your code.
2) Knowing what you want to do, and picking the data structure that fits your needs is a drastic difference. 


> [!TIP]
> An ArrayList uses an array under the scenes. As a reminder, an array is a fixed size of multiple objects, and if you exceed the size, you need to create a new array and copy the data over. An ArrayList does this for you, constantly resizing the underlying array as needed. It gives you the advantages of an array (direct memory access) without needing to track sizes and limitations. 
>
> An LinkedList is something you cover in more detail in CS 5008, but it is a series of nodes that point to the next node. This allows for quick insertions and deletions, but slower access times.


### ListRunner.java methods

Take a look at ListRunner.java.  👉🏽 DISCUSS and define as a group what the following two methods do
* runAddToFrontTest(List<Integer> list)
* accessNthElement(List<Integer> list, int n)

### :fire: Task 1: Run ListRunner.java

Either in your IDE or via the command line, run ListRunner.java. If you are using the command line/terminal, you can run the following commands. 

```bash
cd Part1  #(or wherever you have the files)
javac ListRunner.java
java ListRunner
```

That will let you run it directly without worrying about the package. 👉🏽 DISCUSS the results! 

A powerful concept is that if your entire program uses List, you often only have one spot to change the class, and a simple change between ArrayList and LinkedList can make a big difference depending on what you are trying to do. 

## Streams
Introduced in Java 8, the Stream object is a powerful way to manipulate data structures. It is a way to process data in a functional way, and can be used to filter, sort, map, and reduce data. Modern languages will often start with streams as part of their data structures, but do to java's history it wasn't added until a bit later in the design. 

Traditionally, if I wanted to filter a list of numbers, I would have to write a loop to go through the list, and then add the numbers that met the criteria to a new list. 

The code would be the following:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class YourClassName {
    public static List<Integer> getEvens(List<Integer> numbers) {
        List<Integer> evens = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 0){
                evens.add(numbers.get(i));
            }
        }
        return evens;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        List<Integer> evens = getEvens(numbers);
        System.out.println(evens);
    }
}
```

### :fire: Task: Practice 
Go ahead and create a solution/java file, and put in the above code. Make sure to change YourClassName to match the name of the .java file you create. Throughout this Module you will continue to add to this file.

### Streams Example

Now, let's try the same example in a more modern way using the Stream object. 

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class YourClassName {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10); // this function is a quick way to build a list
        List<Integer> evens2 = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens2);
    }
}
```

Try the above code. 👉🏽 DISCUSS the results!

In english, what the code is saying is:
1. Take the list of numbers as a stream
2. Filter the stream to only include numbers that are even
3. Collect the stream back into a list

For the remainder of this TeamActivity, you will continue to build on your test file. While we have a solution, it is best for you all to work on your own versions and look towards the solution if stuck. 


### :fire: Task: 

The following code is an example of using a stream to "reduce" the results into a single value or set
of items.

```java
List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
```

:fire: Task - Write a method that does the same thing. It (a) takes in a list of Integers, and (b) returns the sum of the list.