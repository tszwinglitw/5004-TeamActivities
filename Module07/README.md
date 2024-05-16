# Module 07 Team Activity  - MVC: Model

In this activity, we will explore the model or data layer of the Model-View-Controller (MVC) design pattern. We will create a simple model that will be used to store data for our application. We will also explore how to read and write data from XML and JSON files, which are common file types used to store data in applications.


## Grading
Grades for team activities will be based on attendance and notes. You must attend, and as a team you need to generate notes that we can confirm your work. Ideally, you upload the notes as a PDF to the team meeting after you build them out. 

> [!TIP] 
> Good notes become a study guide for you and your team! Make sure they include everything you need to help better understand the weekly material. 

### ⭐ Working in Teams ⭐
When working in teams, remember do not let one person do all the work. Make sure to work together, and ask questions. It is also better if different people program, and you all take turns programming for various team assignments.

## Learning Objectives
This team activity is designed to help you understand the following concepts:
* Understand the Model-View-Controller (MVC) design pattern
* Implement a simple model
* Use record  classes to create objects from data
* Manipulate information from XML and JSON file types


## Reflection on HW05
In Homework 05, we created an immutable [BoardGame](bg_arena_planner/BoardGame.java) class. It was immutable, as we did not provide 
any setters for the class, and none of our methods modified any of the data in the class. 
It also involved implementing toString, equals, and hashCode methods.  

👉🏽  Discussion - Take a moment to remind yourself about toString(), equals, and hashCode. Discuss key points, and why they would be 
common in classes whose primary purpose is to store data/information. 

This type of class is very common to implement in programming,
and often called a "dataclass" in many languages such as Python or Kotlin. In Java, we can use the `record` class to create a similar
class with less boilerplate code.

### Java Records

`Record` classes are a new feature in Java 16+ that allow you to create simple data classes with less boilerplate code. They all have the following properties:
    * They are immutable
    * They have a `toString()` method that prints out the values of the fields
    * They have an `equals()` and `hashCode()` method that compares the values of all the fields
    * They can to extend other classes (because they extend the `java.lang.Record` class), but they can use implements to implement interfaces. 

They can be used at the top level of a file, or as a nested class. They can even be declared inline if you need a temp object to store information.

The following classes were added to this project. 
* [RecordExample.java](RecordExample.java) - Sample program loading records
* [Student.java](Student.java) - Example of a record class
* [Person.java](Person.java) - Example of a record class 

👉🏽  Discussion - Take time to discuss and run the above classes. Additionally, we have added [GameData.java](GameBoard.java) as an example of implementing GameBoard as a record.  For Record GameBoard as compared to Class GameBoard, there are some subtle differences that keep them from exactly equivalent. Can you uncover the difference? Maybe try modifying some of the values in the `main` in Record GameBoard to see the results.


> [!TIP]
> What is **var**? Starting in Java 11, you can use the `var` keyword to declare local variables. The compiler will infer the type of the variable based on the value you assign to it. This can make your code more concise and easier to read. We often don't introduce it right away, as most books are still stuck back at java 8.0. But it is a good feature to know about, and can help your code. Note it is only for local (internal to methods, loops, if statements) variables, and *not for class fields or method parameters*.

## File Types
Let's take a moment to discuss file types. There are often two major 'types' of files, binary and text. Binary files are files that are stored in a format that is not human-readable. They are often used to store data in a more compact form, and are often used by programs to store data. Text files are files that are stored in a human-readable format. They are often used to store data that needs to be read or edited by humans. That is it. Extensions tell you more about the file/formatting of the content of the file. For example, a `.txt` file is a open text file with no formatting, while a `.xml` file is an XML file which relies on a hierarchy of bracket notation to define information , and a `.json` file is a JSON file that is "code like" storage of the data.

It is worth exploring some basic formats, as you work with building your models often comes hand in hand with reading and writing data to files. 


### CSV Files
Explored before, Comma Separated Values are a "flat" data system. Meaning it is a single table of data, with rows and columns. Each row is a record, and each column is a field. It is a very simple format, and can be read and written by many programs. It is flat, as the rows are not 'nested' or 'hierarchical', and those type of relationships are not easily represented in CSV files.

While we have been using .split to parse CSV files, there are libraries that can help you read and write CSV files. One such library is OpenCSV. You can find more information about OpenCSV at [http://opencsv.sourceforge.net/](http://opencsv.sourceforge.net/). This allows for the more options, such as data with commas in it, or other special characters without causing .split issues. 

> [!NOTE]
> When you see things talk about Maven like the first page of OpenCSV, that also works for gradle! Gradle is built off of maven, and  uses a different file format to store the dependencies.



### XML Files


### JSON Files


## :fire: Java Practice Problem
As part of **every** team activity, we will ask you to work on a Java Practice problem, and submit the code to the team files section (or as part of your notes). This is meant to give you practice similar to technical interviews, but also help build up your java skills. **Each team member needs to select a different problem!** But you can share/and should share answers and help each other. Remember, to learn a new language, the best thing you can do is practice! Here are some resources to find practice problems but you are not limited to them:

* [CodeHS - Java Practice](https://codehs.com/practice/java)
* [Coding Bat - Java](https://codingbat.com/java)
* [Hacker Rank - Java(Basic)](https://www.hackerrank.com/domains/java?filters%5Bskills%5D%5B%5D=Java%20%28Basic%29)