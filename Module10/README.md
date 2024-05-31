# Module 10 Team Activity  - MVC: View

In this activity, we will build off last weeks activity (with some changes) to setup a view for our MVC application. Instead of having a console view, we will create a GUI view using Java Swing.

## Grading
Grades for team activities will be based on attendance and notes. You must attend, and as a team you need to generate notes that we can confirm your work. Ideally, you upload the notes as a PDF to the team meeting after you build them out. 

> [!TIP] 
> Good notes become a study guide for you and your team! Make sure they include everything you need to help better understand the weekly material. 

### ⭐ Working in Teams ⭐
When working in teams, remember do not let one person do all the work. Make sure to work together, and ask questions. It is also better if different people program, and you all take turns programming for various team assignments.

## Learning Objectives
This team activity is designed to help you understand the following concepts:
* Understand the Model-View-Controller (MVC) design pattern
* Implement a GUI view using Java Swing
* Work with an interface, so different types of views are interchangeable
* Explore the singleton design pattern
* Review the use of xml properties files

## Explore Provided Code

For this activity, we have provided a working program that uses a console view. The program is a simple calculator that can add, subtract, multiply, and divide two numbers. The program is divided into three parts: the model, the view, and the controller. The model is responsible for the business logic of the program, the view is responsible for displaying the data to the user, and the controller is responsible for handling user input and responding to it. 

👉🏽  Discuss the files provided in the [student](student/) package. In the last activity, we did a prefix calculator. Is it still a prefix calculator or did we update it to a normal infix calculator?


### Settings.java and a Singleton Pattern

You will see a new file called Settings.java, which uses the following method

```java
 public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
```
Where instance is a private static variable of the class. This is an example of the singleton design pattern. The singleton design pattern ensures that a class has only one instance and provides a global point of access to that instance. In this case, the Settings class is used to store the properties of the program, such as the title of the window. Arguably, it could be used to hold more information than what we are using, but wanted to just have it as an example.




### Running the current program

You can run the current program as is from the [CalculatorApp.java](student/CalculatorApp.java) file. This will run the program with a console view by default.

> [!CAUTION]
> This app probably has plenty of bugs/undocumented features, as we didn't put in the many layers of error checking that would be needed for a production application. Just remember, it is an example :) to get you started. 

## Replacing the view.





## Overall

Design takes practice! It takes discussion, refactoring, and more discussion. The more you practice, the better you will get at it. The more you discuss, the more you will learn. 



## :fire: Java Practice Problem
As part of **every** team activity, we will ask you to work on a Java Practice problem, and submit the code to the team files section (or as part of your notes). This is meant to give you practice similar to technical interviews, but also help build up your java skills. **Each team member needs to select a different problem!** But you can share/and should share answers and help each other. Remember, to learn a new language, the best thing you can do is practice! Here are some resources to find practice problems but you are not limited to them:

* [CodeHS - Java Practice](https://codehs.com/practice/java)
* [Coding Bat - Java](https://codingbat.com/java)
* [Hacker Rank - Java(Basic)](https://www.hackerrank.com/domains/java?filters%5Bskills%5D%5B%5D=Java%20%28Basic%29)