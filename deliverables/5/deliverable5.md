# CS 1632 - Software Quality Assurance
Fall Semester 2017

DUE 20 NOV 2017

## Deliverable 5

For this assignment, you and a partner will use static analysis as part of developing a pairwise test generator.

This project will consist of the following steps:

1. Write a program which accepts a list of arguments, then uses the naive pairwise test generation algorithm discussed in class to determine a pairwise test plan
1. Use findbugs and checkstyle to statically analyze your code
2. Use checkstyle with the included configuration file (google_checks_modified.xml) to find any style issues with your code
3. Fix *all* of the errors found by findbugs (with the exception of "Dead store to local variables" issues) and checkstyle

Your final version should have no bugs found by findbugs (except for dead local stores) and no violations reported by checkstyle.

You and your partner should have tests for all of your methods except for `public static void main()`.  There should be at a bare minimum twelve unit tests checking for both edge cases and happy path cases.  You do not need to use stubs/mocks/doubles/fakes if you prefer not to do so.

Your code should be well-written and separated into appropriate methods and/or classes.

The specific requirements for the program are listed in the file `requirements.md` in this directory.

The checkstyle jar file is also in this directory.  Checkstyle is a static analysis tool which acts as a linter - that is, it will tell you if there are style issues with your code which would not ordinarily impact compilation and execution, but may indicate errors, poor commenting, style violations, or simply difficult-to-read code.

We are using a modified Google style guide (also included in this directory).

You may want to run checkstyle on a previous piece of code (I recommend deliverable 4!) that you have written to see what kinds of issues it will find (and which ones you are likely to make).

You will also use findbugs, as described in class, to find possible bugs in your code and fix them.  FindBugs is available here: http://findbugs.sourceforge.net/

Note that findbugs has a known issue with the "Dead store to local variable" analysis.  You may ignore any errors of this kind (you can filter them out or just mentally ignore them).  

Run checkstyle using the included google_checks_modified.xml configuration file on all of your code.  Fix all of the issues so that the style is in line with the modified Google code guidelines (these are actual Google Java style guidelines, btw, with some small modifications by yours truly).  Before turning this in, your checkstyle run should show _no_ issues.

Checkstyle Usage Example:
```
java -jar ~/checkstyle/checkstyle-7.0-all.jar -c ./google_checks_modified.xml ~/pitt/CS1632/*.java
```

For the summary, include a listing of the issues you found with your code and .  This should not be more than a few paragraphs.  

Include screenshots of both the FINAL findbugs and checkstyle output (should have no errors for either).

## Format
Every assignment should have a title page with:
* The name of the students in the group and their GitHub usernames
* The title "CS 1632 - DELIVERABLE 5: Static Analysis"
* The URL for your git repository

There is no need to print out the code, only the deliverable paperwork.  It should be available on GitHub or a similar code-sharing site BY THE BEGINNING OF CLASS.

## Grading
* Summary - 5%
* Screenshots of Findbugs and checkstyle output - 5%
* Functionality (including handling bad input!) - 25%
* All issues from checkstyle fixed - 20%
* All issues from FindBugs fixed - 20%
* Unit tests (all should pass): 25%

Please feel free to email me or come to office hours to discuss any problems you have. 
 
