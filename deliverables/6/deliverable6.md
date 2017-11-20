# CS 1632 - Software Quality Assurance
Fall Semester 2017

DUE 6 DEC 2017

## Deliverable 6

For this final deliverable, you and a partner will develop a project from scratch (see details) below, along with a detailed report on the testing strategy used.

Expect no mercy from my testing!  This is a relatively simple program but you will be expected to deal with all edge cases, find defects ahead of time, think of performance issues as explained in the requirements, etc.  I expect as close to bullet-proof an application as one could be expected to deliver, and that you have proved this by creating a good testing strategy based on all that we have learned this term.

You will develop an entire testing strategy for the application.  This testing strategy should cover all aspects of testing that we have covered.  It should show that you have thought deeply about the particular concerns of this piece of software.

I expect you to do independent research to determine general information about how to develop this application.  You may also wish to review the syllabus to see all of the kinds of testing that we have discussed this semester and when they are relevant.

Your paper should include the following three sections.  You should LABEL each section clearly.  You may use graphs, charts, etc. if these would help in understanding your position.

You are not _required_ to create a traceability matrix for this assignment, but it would be a good addition to ensure that you have verified all of the requirements.

1. A review of the program's overall quality.  This should be done using the Red-Yellow-Green template.  It is up to you to determine the subsets of functionality and/or subsystems.
2. Areas of concern.  We want the program to compare favorably in terms of features and quality with similar software.  If there are known defects, list them here.  These should be written using the standard defect template.  It is much better for your grade if you find a defect yourself and report it than if I find it.
3. Testing strategies used.  You should answer the following questions.
   1. What kinds of tests did you write? Why?
   2. What percentage of time/effort was allocated to each kind of test?
   5. What recommendations would you give to help increase quality?
   6. What parts of the code need to be cleaned up?
   7. What kinds of things did you discover in exploratory testing?
   8 If you developed a manual testing plan, include it here.

## Program Functionality

You are going to develop an interpreter for a simple language, RPN++.  This allows user to calculate using Reverse Polish Notation.  It also supports simple output via the PRINT keyword, variables, and the ability to quit.

Running the program without a filename will cause the program to enter a read-eval-print-loop (REPL).  In REPL mode, users can enter expressions one line at a time.  REPLs are widely used in many programming languages such as Ruby, Clojure, and Lisp.

When running the program with one or more arguments, each argument shall be considered a path to a filename.  The program shall execute each program stored in that filename.

Detailed requirements are listed below.

## Requirements

1. The program shall be named RPN and should be runnable from the command line using the command "java RPN".
1. Tokens shall be numbers, variable names, operators, or one of the keywords QUIT, LET, or PRINT.
1. A number shall consist of one or more digits.  All numbers shall be arbitrary-precision (i.e., there shall be no integer overflow - 999999999999999999999999999 shall be considered a valid number and stored as such).
1. Variable names can be a single letter (A-Z) and are case-insensitive (e.g., `a` and `A` refer to the same variable).
1. Operators can be +, -, /, or *, for add, subtract, divide, and multiply, respectively.
1. The keyword QUIT causes the program to end.
1. Any lines or tokens after the QUIT keyword are ignored.
1. The keyword LET is followed by a single-letter variable, then an RPN expression.  The RPN expression is evaluated and the value of the variable is set to it. 
1. The keyword PRINT is followed by an expression, and the interpreter shall print the result of that expression to standard output (stdout).
1. Keywords shall be case-insensitive (e.g. `print`, `PRINT`, or `pRiNt` are interchangeable)
1. Keywords shall only start a line (e.g., you cannot have a line such as "1 2 + PRINT 3")
1. Variables shall be considered initialized once they have been LET.  It shall be impossible to declare a variable without initializing it to some value.
1. Referring to a variable which has not previously been LET (i.e. has not been declared) shall result in the program informing the user that the variable is uninitialized and QUIT the program with error code 1.  It should inform the user in the following format: "Line n: Variable x is not initialized." where `x` is the name of the variable and `n` is the line number of the file the error occurred in.
1. The exception to the previous requirement is that if this occurs in REPL mode, the user shall be informed, but the line will simply be ignored.
1. If the stack for a given line is empty OR does not contain the correct number of elements on the stack for that operator, and an operator is applied, the program shall inform the user and QUIT the program with error code 2.  It should inform the user in the following format: "Line n: Operator o applied to empty stack" where `o` is the operator used and `n` is the line number the error occurred in.
1. The exception to the previous requirement is that if this occurs in REPL mode, the user shall be informed, but the line will simply be ignored.
1. If the stack for a given line contains more than one element and the line has been evaluated, the program shall inform the user and QUIT the program with error code 3.  It should inform the user in the following format: "Line n: y elements in stack after evaluation" where `y` is the number of elements in the stack and `n` is the line number the error occurred in.
1. The exception to the previous requirement is that if this occurs in REPL mode, the user shall be informed, but the line will simply be ignored.
1. If an expression used for initializing a LET variable is invalid, the variable is considered to have not been initialized.  For example, "LET A 1 2" is invalid, and A is not initialized.
1. If an invalid keyword is used, the program shall inform the user and QUIT the program with error code 4.  It should inform the user in the following format: "Line n: Unknown keyword k" where `k` is the keyword and `n` is the line number the error occurred in.
1. The exception to the previous requirement is that if this occurs in REPL mode, the user shall be informed, but the line will simply be ignored.
1. All other errors shall result in the program informing the user of the error and exiting with error code 5.  At no point shall the end user of the system see a Java exception or stack trace.
1. All errors shall be written to standard error (stderr), not standard output (stdout).
1. In REPL mode, the result of each line shall be displayed immediately afterwards before another prompt comes up.
1. In REPL mode, PRINT shall not perform any additional work, as the result of the RPN expression evaluation will already be displayed.
1. In REPL mode, when displaying error messages, the current line shall be considered as the nth command entered. For example, the first line entered shall be considered Line 1, the second line entered Line 2, etc.
1. This program shall minimize real execution time, even at the expense of memory or CPU usage.
1. The ">" character shall be used as the prompt for REPL mode.
1. In case of ambiguity, the sample output shall be considered the ground truth.
1. When reading multiple files, all of the files shall be concatenated into one large file before processing.  For example, when executing file1.rpn and file2.rpn, and file1.rpn initializes a variable A, file2.rpn can use variable A without initializing it.  Similarly, if a QUIT is encountered at the end of file1.rpn, the entire program will quit and no lines in file2.rpn shall be executed.
1. Blank lines in files shall be ignored.
1. Lines in files are considered to be 1-indexed, that is, the first line in a file is line number 1, not 0.
1. Variable values shall not be persisted across executions.  In other words, if I initialize a variable `a`, then quit the program and start it again, variable `a` is no longer initialized.
1. Tokens shall be separated by whitespace.
1. For concatenated files, the line number shall continue to increment for each line of the file.  It shall not reset after a new file has been reached.

## Sample Output

Simple runs

```
$ java RPN
> 4 3 +
7
> LET a 10
10
> a 1 +
11
> 2
2
> LET b 2 2 +
4
> LET c a b +
14
> PRINT c
14
> PRINT c 1 +
15
> 10 10 * 5 5 * 0 0 * + +
125
> QUIT

$
```

Errors

```
$ java RPN
> a 4 +
Line 1: Variable a is not initialized
> 1 2 + +
Line 2: Operator + applied to empty stack
> 3 4 5
Line 3: 3 elements in stack after evaluation
> LOOP
Line 4: Unknown keyword LOOP
> 4 3 LET + a
Line 5: Could not evaluate expression
> LET a
Line 6: Operator LET applied to empty stack
> QUIT BUMBLEBEE

$ echo Note BUMBLEBEE was ignored
Note BUMBLEBEE was ignored
```

Big numbers

```
> 999999999999999999 999999999999999999 *
999999999999999998000000000000000001
> LET a 0 999999999999999999999999999 -
-999999999999999999999999999
> LET b -1
-1
> a b +
-1000000000000000000000000000
> QUIT
```

Files

```
$ cat File1.rpn
LET A 1
LET B 2
PRINT A B +

$ java RPN File1.rpn
3

$ cat File2.rpn
PRINT -1 1 +
PRINT 0
PRINT 100 0 *
QUIT

$ java RPN File2.rpn
0
0
0

$ java RPN File1.rpn File2.rpn
3
0
0
0

$ java RPN File2.rpn File1.rpn
0
0
0

$ echo Note that the QUIT keyword in File2 made File1 not run
Note that the QUIT keyword in File2 made File1 not run
```

Errors in files

```
$ cat Bad.rpn
LET A 1
LET B 2
PRINT 1 2 3
PRINT B
PRINT C

$ java RPN Bad.rpn
Line 3: 3 elements in stack after evaluation

$ cat Bad2.rpn
QUOMBLE
1 2 +
3 4 -

$ java RPN Bad2.rpn
Line 1: Unknown keyword QUOMBLE

$ cat Bad3.rpn
LET a 100 100 +
LET b 60 +
LET c a b +
PRINT c

$ java RPN Bad3.rpn
Line 2: Operator + applied to empty stack

$ cat Bad4.rpn
PRINT 1
LET a 100 100 +
LET b 60 +
LET c a b +
PRINT c

$ java RPN Bad4.rpn
1
Line 3: Operator + applied to empty stack
```

## Format
Every assignment should have a title page with:
* The name of the students in the group
* The title "CS 1632 - DELIVERABLE 6: Testing Strategy for RPN++"

## Automated Test Suite

I expect a unit test suite of at least 20 unit tests, evaluating a variety of different base, edge, and possibly corner cases.  As always, this should be well-commented and of high quality.

## Grading
```
Overall review of quality: 10%
Description of issues and enhancements: 10%
Description of testing strategy: 20%
Program Functionality: 50%
Automated Test Suite: 20%
```

Please feel free to email me or come to office hours to discuss any problems you have. 
 
