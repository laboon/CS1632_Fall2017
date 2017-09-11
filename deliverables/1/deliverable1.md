# CS 1632 - Software Quality Assurance
Fall Semester 2017

* ASSIGNED: 11 SEP 2017

* DUE: 20 SEP 2017

## Deliverable 1

For this assignment, your group will determine a test plan for JBefunge, based on the requirements listed in the file requirements.md.  Note that these are a _subset_ of all of the requirements of the program.  There are several known defects in the software; you will need to find and report on at least three, as well as request one enhancement.  Additionally, a traceability matrix showing the mapping of test cases to requirements is required.

The JBefunge IDE repository is here: https://github.com/laboon/JBefunge

Time will be given in class to group yourself into groups.  There should be two and only two members of a group.

There should be, at an absolute bare minimum, twice as many test cases as requirements, although I would normally expect several test cases per requirement.   However, if the number of test cases is more than 4x the number of requirements, you are probably overtesting for our purposes.

Each requirement should have AT LEAST one test case associated with it, and each test should have EXACTLY ONE requirement associated with it.  This can easily be checked via a traceability matrix (which you should also deliver).  Note that some test cases may actually test several requirements.  You should specify the one that the test case fits best - that is, what are you really trying to test with this test case?

Test cases should mention all necessary preconditions, execution steps, and postconditions.  You do not need to separate out preconditions vs input values or postconditions vs output values for this test plan.

It is NOT necessary to make multiple test plans inside a test suite; it is enough for there to be one test plan.

I expect you to test three edge or corner cases as part of the test plan.  These need to be marked in the description of the relevant test case.

It is expected that you actually execute the test plan in order to find the defects, along with some exploratory testing to determine how the system works and where defects might lie.  There are AT LEAST three defects.  While you are not expected to find *all* of the defects, a reasonable test plan should definitely find at least three.  This is an intentionally target-rich environment.

You will also write up one request for enhancement to the program.  This should be something that is _not_ specified in the requirements, but you, as a budding Befunge programmer, would like to see added to the IDE.

## Format
Please hand in the paper to me with a cover page with:
* The name of the project under test ("JBefunge")
* The names of the people in the group
* The title "CS 1632 - DELIVERABLE 1: Test Plan and Traceability Matrix"

There should be a short introduction (a few paragraphs) in which you may note any concerns or difficulties you may have had or anticipate with the testing process.  You should also note why you considered certain test cases, how you thought of edge cases, etc.

This should be followed ON A NEW PAGE by the list of test cases.  You may name or number them any way you wish, but be consistent.  You should write them out in this format -

	IDENTIFIER:
	TEST CASE: 
	PRECONDITIONS:
	EXECUTION STEPS:
	POSTCONDITIONS:

The IDENTIFIER is some value which will UNIQUELY specify the test case.  It should consist of some mnemonic (e.g. TEST-INVALID-TIMES, TEST-LOW-NUM-TIMES, etc.).  

ON A SEPARATE PAGE, a traceability matrix should be provided mapping the test cases with their associated requirements.  Remember that all requirements should map to AT LEAST ONE test case (but usually more), and all test cases should map to EXACTLY ONE requirement.  

Finally, ON A SEPARATE PAGE, list at least three defects found.  The defects should follow the defect reporting template:

	 SUMMARY:
	 DESCRIPTION:
	 REPRODUCTION STEPS:
	 EXPECTED BEHAVIOR:
	 OBSERVED BEHAVIOR:
	 SEVERITY:
	 IMPACT:

The test case which found the defect should be listed as part of the DESCRIPTION.

The SEVERITY and IMPACT will obviously be a bit subjective; use your best judgment and explain why you believe that 

You may find it useful to review chapters 5 through 9 of the textbook.

## Grading
* Introduction: 10% of grade
* Test Plan: 45% of grade
* Traceability Matrix: 10% of grade
* Defects Found and Described: 35% of grade

The requirements are listed in the file requirements.md.

Please feel free to email me or come to office hours to discuss any problems you have. 
 
