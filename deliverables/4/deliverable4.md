# CS 1632 - Software Quality Assurance
Fall Semester 2017

DUE 8 NOV 2016

## Deliverable 4

In this deliverable, you and a partner will write software to determine whether or not a group of names listed in a file can be written as a grouping of element abbreviations.

I have included a list of element names and their abbreviations in the file `elements.txt` in this directory.

You may want to look into the concept of macros in your text editor to modify this list into something appropriate for whichever format you want to use.  

Under _no_ circumstances should the program crash or should the user see an exception or stack trace.  You should handle all edge cases that might be thrown at you, such as a non-existent file, no arguments, etc.  I will not enumerate all of these but several will be tested.

The program shall accept one argument, which is the name of a file.  Your program will read in each line of the file and attempt to convert that name to its element abbreviations.  Spaces and any other non-alphabetic characters should be ignored.  Your program will then write to standard output (i.e., `System.out.println(...)`) the abbreviations separated by " - "'s, and the element names beneath that.  Empty lines in the file should be ignored.  If you cannot make the name into elements, you should print "Could not create name *name* out of elements." where *name* is the name passed in.

The program shall be case-insensitive.

See sample_output.txt for samples.

You should work on making this program execute as quickly as possible.  You may use all computing resources available to you.  This will be run on a four-core system with eight gigabytes of RAM.  No other programs will be running at the time.

Your program will be timed using the sample_input.txt text file.  Make sure that your code works with this.

The fastest three programs in the class will receive bonus points.

You should explain how your program has been sped up in your summary.  You should do at least one modification to speed it up after initial input.

## Format
Every assignment should have a title page with:
* The name of the students in the group
* The title "CS 1632 - DELIVERABLE 4: Performance Testing Using VisualVM"

There is no need to print out the code.  It should be available on GitHub or a similar code-sharing site BY THE BEGINNING OF CLASS.

In order to determine the "hot spots" of the application, you will need to run a profiler such as VisualVM (download at https://visualvm.java.net/).  Using a profiler, determine what code/methods/objects you can modify to speed up the execution time of this program.  

For the summary, describe how you profiled the application and determined the methods to refactor, and why you changed what you did.  The summary should not be more than a few paragraphs - definitely less than a page. 

After this, include a screenshots of VisualVM (or another profiler, if you use that) profiling your code.

There should be at least twelve unit tests.  These should be run with a TestRunner just like in D2 and D3.

You should time program with the sample file three times AND indicate the mean and median amount of time it took to execute.  You can do this with the `time` command in Unix-like systems (Linux, OS X, BSD) or the `Measure-Command` command in PowerShell on Windows systems.

## Grading
* Summary - 10%
* VisualVM (or other profiler) screenshots - 10%
* Final times (>= 3 of each + mean) included - 10%
* Code and Execution Speed - 50%
* Unit Tests - 20%

