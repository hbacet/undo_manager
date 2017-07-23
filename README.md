# undo_manager

Result of running Application.java:

**************Example #1 is running*************************
Registering new change: BasicChange{pos=0, s='I ', type='insertion'}
Document content: [I ], dot at position: 2
proceeding to apply Undo...
Document content: [], dot at position: 0
Undo applied successfully!
Error: No changes to undo
**************Example #2 is running*************************
Registering new change: BasicChange{pos=0, s='I ', type='insertion'}
Document content: [I ], dot at position: 2
Registering new change: BasicChange{pos=2, s='can ', type='insertion'}
Document content: [I can ], dot at position: 6
Registering new change: BasicChange{pos=6, s='see ', type='insertion'}
Document content: [I can see ], dot at position: 10
Registering new change: BasicChange{pos=10, s='you.', type='insertion'}
Document content: [I can see you.], dot at position: 1
Registering new change: BasicChange{pos=2, s='can', type='deletion'}
Document content: [I  see you.], dot at position: 2
Registering new change: BasicChange{pos=2, s='want to', type='insertion'}
Document content: [I want to see you.], dot at position: 2
proceeding to apply Undo...
Document content: [I  see you.], dot at position: 2
Undo applied successfully!
proceeding to apply Undo...
Document content: [I can see you.], dot at position: 2
Undo applied successfully!
proceeding to apply Undo...
Document content: [I can see ], dot at position: 10
Undo applied successfully!
proceeding to apply Redo...
Document content: [I can see you.], dot at position: 1
Undo applied successfully!
Registering new change: BasicChange{pos=2, s='really ', type='insertion'}
Removing tailing elements:
--> Removing BasicChange{pos=2, s='can', type='deletion'}
--> Removing BasicChange{pos=2, s='want to', type='insertion'}
Document content: [I really can see you.], dot at position: 2
Error: No changes to redo
