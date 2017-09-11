FUN-TEXT-DISPLAY - Upon startup, the system shall display a graphical user interface with three textboxes, labeled Program Area, Stack, and Output.  The Program Area textbox shall be user-editable; the other two will never be editable directly by the user.  

FUN-MENUS - There shall be three menu groups: File, Color, and Options.  Under File, there shall be four menu items: Open File, Save File, Save As, and Quit.  Under Color, there shall be six menu items: Red, Yellow, Blue, Pink, Green, and Orange.  Under Options, there shall be two checkable menu items: Time Program, and Check for End Opcode.

FUN-BEFUNGE - The system shall be able to run any valid Befunge-93 program, displaying valid stack data and output according to the Befunge-93 specification here: http://catseye.tc/view/befunge-93/doc/Befunge-93.markdown

FUN-RUN-SPEED - The system shall have three standard execution speeds, Run (no pauses in execution), Walk (50 ms pause after each opcode), and Mosey (500 ms pause after each opcode).  All of these shall be reachable by pressing a button of the appropriate name.

FUN-STEP - The system shall allow the user to step one opcode at a time, appropriately updating the stack and output, by pressing the Step button.

FUN-STOP - When no program is being executed, the Stop button shall be disabled.  When a program is being executed, the Stop button shall be enabled.  Upon clicking the Stop button, the currently running program shall stop execution.

FUN-TIME - If the "Options..Time program" option is checked, then after program execution has completed, the system shall inform the user how long, in microseconds, the program took to execute.  If the "Options..Time Program" option is not checked, the user shall not be informed.

FUN-TRACE - If and only if a program is being executed, the system shall display a cursor on the current opcode indicating that is being executed.  This cursor should start displaying immediately after starting execution of a program on the first opcode, and will do so no matter if started via Run, Walk, Mosey, or Step.  It shall not appear when a program is not being executed.

FUN-CHECK-END-OPCODE - If the "Options...Check For End Opcode" option is checked, then the system shall warn the user if no end opcode ("@" character) exists in the Program Area.  If an end opcode does exist, even if it is unreachable, no warning will be shown.  

PERF-EXECUTION-TIME - On any given computer, the system shall be able to complete execution of a reference FizzBuzz implementation (i.e., the one listed in the README.md file of the JBefunge repository), in less than 30 seconds (30,000,000 microseconds). 

