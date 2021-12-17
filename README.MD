# Sorting Manager Project

## Table of Contents 
1) ### _Project Overview_ 
2) ### _Features_
3) ### _Implementation Notes_
4) ### _Usage_

### Project Overview 
This is the Sort Manager Project. 
Its primary aim is to show users on the console line how the different sorting algorithms work and how quickly they are implemented.
It is a project developed in pure __Java__ and has been designed in a way to help facilitate further additions later down the line. 
For more information regarding this, please refer to the __*CONTRIBUTING.MD*__ file in the project. 

### Features 
The current features of the project are as follows: 
* There are 3 sorting algorithms that have implemented:
  * Bubble Sort Algorithm
  * Merge Sort Algorithm 
  * Binary Tree Algorithm
* There is a console view that allows users to select one of the following 
sorting algorithms and see the unsorted array as well as sorted array. 
* There is also the time it takes for the execution of each algorithm shown in the console view 


### Implementation Notes 
This project was designed in a way that the SOLID principles, DRY and design patterns were followed as much as possible.
The design pattern chosen here was the Creational design pattern, Factory design. { __*SortFactory*__ class in the project }

This allows for multiple sort algorithms to be implemented 
without having to change the main structure of the code as they all implement the same methods through the use of an interface. 
{ __*ISorter*__ interface in the project }

This project also used a printer class to output all the console view text to make the code more readable. 
{ __*PrintLoader*__ class in the project }

The most important part of the project was the use of test cases to ensure that the sort was working as expected. 
Various cases such as duplicate values, single element in the array, large arrays were tested. 
It was also designed so that you can conduct these tests for one sorting algorithm, and it should work the same for the remaining algorithms. 
This approach of Test Driven Development (__TDD__) has been very useful in ensuring that coding is always implemented from the tests, making it easier to understand the project
requirements. 

### Usage
To use this project, you will need to clone this project from the current repository and open this project in a __Java SDK__ ideally using __IntelliJ__. 
The code structure is based on the __MVC__ architecture. You then open the __*App*__ class in the __views__ folder to run the main program. 
It will then prompt the user on the console view to enter values to choose the sort you want to see in action. 

You can also go to the __test__ folder and open the __*SortingTests*__ class which has the tests relating to a single sort algorithm. 
You can change which algorithm it tests by changing the value in the variable which assigns it to a sort algorithm. 
This can be verified in the comments which outline the function for each method. 
