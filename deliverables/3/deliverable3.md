# CS 1632 - Software Quality Assurance
Fall Semester 2017

DUE 30 OCT 2017

## Deliverable 3

For this assignment, you and a partner will write systems-level, automated black-box tests for a web app using Selenium and JUnit. 

Test code should be on a private repository and GitHub, and the TA and myself should be added as collaborators by the beginning of class on the due date.

Please use the included TestRunner and Selenium jars.  You may modify the TestRunner class to include any test classes that you have created.  These are _not_ the latest Selenium jars, but they are guaranteed to work together.

The web app is located here: https://cs1632ex.herokuapp.com/

This is an Elixir/Phoenix application.  If you like, you may look at the source code here: https://github.com/laboon/cs1632d3ex.  However, this is NOT necessary (and technically would make this grey-box testing).  I do not expect you to learn yet another language for this course.  It might be interesting for you to see Elixir code, though (it is slightly more useful than learning Befunge).

## Format
Everyone should have a title page with:
* Your name
* The URL of your code and tests on GitHub
* The title "CS 1632 - DELIVERABLE 3: Unit Testing"

For the summary, add a description of issues you faced when writing these tests and problems you would expect going forward based on your experiences.  If any tests you wrote fail (some should!), they should be included here.

After this, there should be a printout or screen shot of the test execution results.

There is no need to print out the code.  It should be shared with me and the TA (i.e., we have been added as collaborators) on GitHub BY THE BEGINNING OF CLASS.

The JUnit tests shall have a description (a few sentences at most) of what they are testing written in the comments above the particular test. See RedditTest.java in the sample_code directory for an example.

Remember these are USER-level systems tests; comments should describe tests in a way that an intelligent user of the software would understand.  Even though we are using JUnit, these are _not_ unit tests.  Remember the differences between system-level tests and unit tests!

There should be a bare minimum of twenty tests, checking various base, edge, and corner cases.  There is a maximum of thirty tests.  However, do not focus on the number of tests too heavily; I am more concerned that you cover a broad variety of cases, check the requirements, and ones which are focused and yet still likely to find defects.

## Note on Selenium Drivers

Please use the following Selenium jars.  They are also included in this directory in the repository.

2.52 Selenium Server jar: http://selenium-release.storage.googleapis.com/2.52/selenium-server-standalone-2.52.0.jar

2.52 Java bindings jar: http://selenium-release.storage.googleapis.com/2.52/selenium-java-2.52.0.zip

## Note on Firefox / Selenium in Windows

To open the Selenium IDE from Firefox in Windows, right click the top bar of firefox, between the open tabs and the minimize button. Click "Menu Bar" so the menu bar shows up in the top left corner. Under "Tools" is "Selenium IDE".

Alternatively, "ctrl+alt+s" while in the Firefox window should also bring up the IDE.

## Requirements

Requirements for the application are listed in the `requirements.md` file in this directory.

Remember to check for implicit as well as explicit requirements!

You should have at least one test for each requirement, although there is no need to write a traceability matrix.

## Defects

This is another buggy product.  You should find at least three defects and report them using the standard defect template (just like in the first deliverable).  These defects should be detected by your automated tests (i.e., there should be at least _three_ failures of your tests).

You may want to do some exploratory testing first to see what kind of issues are found before writing automated tests for them.

## Traceability Matrix

Please make a traceability matrix (just as in the first deliverable).  Tests should be identified by the name of the test case method (e.g., `public void testFoo()` should be indicated on the matrix as `testFoo`).

## Grading
* Summary and Testing concerns - 5% 
* Screen shot or printout of test results - 5%
* Proper comment descriptions of tests - 10%
* JUnit Tests - 45%
* Defect reports - 25%
* Traceability matrix - 10%

Please feel free to email me or come to office hours to discuss any problems you have. 
 
