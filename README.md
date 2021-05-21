# SQA-FinalAssignment

You are going to create a software component for storing information about student grades. Each topic that a student is graded on has a Rubric. A Rubric is made up of multiple Criteria (up to a maximum of 10). When a student is graded they are awarded a score for each Criterion in the Rubric, which is an integer value between 1 and 5.

Here's an example to help you visualise the problem. Each of the columns is a Criterion for this Rubric (Design, Implementation, Testing, Documentation). The rows below capture the score of each student for each criterion. 

<img width="589" alt="Screenshot 2021-05-21 at 16 10 43" src="https://user-images.githubusercontent.com/76775453/119162753-a566e280-ba52-11eb-82ed-bfc9cd6303e5.png">


## Setup

The project has been developed in the Intellij Idea IDE, using java16 and junit5

## Team version control

3 additional branches have been created:
* develop: all the work done in the feature branches is merged to develop
* features/subClasses: Creation of all the necessary sub classes and creation of some useful methods (associated with task 2)
* features/controller: Creation of the controller class and creation of all the required methods (associated with task 3)

Once a task is done the associated branch is merged with develop with a pull request
Once the project is complete and functionnal and all the unit tests are working and effective, the project is pushed on master  

## Test coverage

The test coverage has been measured by the Intellij integrated coverage tool
To run the test coverage tool, press the "Run 'project' with coverage button

All the methods of the project have an associated Unit test :

<img width="375" alt="Screenshot 2021-05-21 at 16 40 27" src="https://user-images.githubusercontent.com/76775453/119163422-4e154200-ba53-11eb-9369-5c9b05f655fe.png">

That gives us a coverage of 100% of the methods :

<img width="452" alt="Screenshot 2021-05-21 at 16 39 50" src="https://user-images.githubusercontent.com/76775453/119163495-5ec5b800-ba53-11eb-9971-119ed8c5fa6c.png">
<img width="623" alt="Screenshot 2021-05-21 at 16 40 11" src="https://user-images.githubusercontent.com/76775453/119163515-62f1d580-ba53-11eb-8232-f7333d9e67dd.png">


**Test coverage tools** helps identify gaps in test coverage by indicating the percentage of methods and line that have been taken into consideration in the tests
The coverage tool indicates which methods are correctly tested or not, and allows the developer to do not forget to test any part of code


## Test driven development

**Test driven development** desribes an iterative and incremental way of developing a project. The code is not oriented on the functional part itself but on the tests, that are written at the same time or prior to the functional code, and that allow the developer to work around it and have a precise idea of what the code should do and not do.
For example, the commit c7ea35132ed357df87b25a7fce414e62e99015b8 (https://github.com/LsGiraffe/SQA-FinalAssignment/commit/c7ea35132ed357df87b25a7fce414e62e99015b8) of the project, that implement every calculation function, shows that every caculation methodhad its own test method. 100% of the methods have an associated unit tests.
