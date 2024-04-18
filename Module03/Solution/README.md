# Solution

:warning: **Note**: This is a solution to the team activity. This is **A** solution. There are other ways your team could have implemented the code.


Each section in the readme corresponds to a section in the team activity. The code itself exists in this directory. Remember, you do NOT have to stick with this solution. This is just one to help guide you. 

- [Solution](#solution)
  - [Question 1 - What are the needed Nouns](#question-1---what-are-the-needed-nouns)



## Question 1 - What are the needed Nouns

- Animal 
- Companion 
- Trick
- Menagerie
- Taxonomy

Note, there is a logical argument for Companion to be specific animals, but the problem with that argument as every time a new animal companion type is added a new class needs to be added. It is not a scalable solution, but it can fit depending on the scope of the project.

In this solution, we broke Taxonomy into its own object, assuming an Animal - "has-a" set of labels called a taxonomy. 
