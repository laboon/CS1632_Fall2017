## Exercise 6 - Static Analysis

In this exercise, you will run the FindBugs program on a Sieve of Eratosthenes program, and then fix any issues found by the FindBugs program.  This will allow you to see what kinds of bugs a static analysis program can find (and which ones it cannot).

The Sieve of Eratosthenes is an ancient way of finding all prime numbers below a specific value.  For details on the algorithm itself, please see https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.

This program accepts one integer value and will tell you all prime numbers up to and including the passed-in value.  However, there are some defects hidden in the code.  You are going to use FindBugs to find and fix them.

Examples:

```
penelope:bug-fodder laboon$ java Sieve 100
Sieve of Eratosthenes
> 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

penelope:bug-fodder laboon$ java Sieve 13
Sieve of Eratosthenes
> 2 3 5 7 11 13
```

## Clone and Compile bug-fodder

1. Clone the bug-fodder repository (https://github.com/laboon/bug-fodder)
2. Go to the directory
3. Compile the Sieve.java file 

## Download and Run FindBugs

1. You may download FindBugs from here: http://findbugs.sourceforge.net/downloads.html.  It is a Java program and so theoretically it can run on any machine which Java also runs on.
2. Unzip the downloaded file
3. Run the program `./bin/findbugs`
4. Wait a few moments for the screen to appear
5. Click on "New Project"
6. Give the project a name (doesn't matter what it is)
7. Select the Sieve class file to analyze
8. Click "Analyze"
9. You should now see a list of defects found by static analysis on the left tab.  

## Fix Bugs

1. Fix all of the defects found by the FindBugs program, _except_ any ones labeled Dead Local Store.  These are often false positives and I have found it useful to ignore them (a "dead local store" is a variable whose value is not read after assignment.  However, Java's compiler puts "dummy" values for final local variables, and since FindBugs only reads compiled bytecode, it often tells you about these problems which you have no way of fixing from a code perspective).
2. Ensure that the Sieve program still works by sending in a few different values (there is no need for "official" pinning tests for this assignment, although it would be a good idea to do in industry)

## Grading

```
Sieve works: 1 point
All FindBugs bugs fixed: 1 point
```