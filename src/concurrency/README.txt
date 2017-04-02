1.3.1. Safety Hazards
1.3.2. Liveness Hazards
Ex : 	In Sequential programming – infinite loop
	In MultiThreaded programming – deadlock situation
1.3.3. Performance Hazards

Chapter 2 : Thread Safety
2.1. ThreadSafety
2.2. AtomicityLocking
	2.2.1. Race Conditions
	2.2.3. Compound Actions
2.3. Locking
	2.3.1. Intrinsic Locks
	2.3.2. Reentrancy	
2.4. Guarding State with Locks

2.5. Liveness and Performance

Chapter 3. Sharing Objects
3.1. Visibility
	3.1.1. Stale Data
	3.1.2. Nonatomic 64-bit Operations
	3.1.3. Locking and Visibility
	3.1.4. Volatile Variables
3.2. Publication and Escape
3.3. Thread Confinement
	3.3.1. Ad-hoc Thread Confinement
	3.3.2. Stack Confinement
	3.3.3. ThreadLocal
3.4. Immutability
	3.4.1. Final Fields
	3.4.2. Example: Using Volatile to Publish Immutable Objects
3.5. Safe Publication
	3.5.1. Improper Publication: When Good Objects Go Bad
	3.5.2. Immutable Objects and Initialization Safety
	3.5.3. Safe Publication Idioms
	3.5.4. Effectively Immutable Objects
	3.5.5. Mutable Objects
	3.5.6. Sharing Objects Safely
	
Chapter 4. Composing Objects
4.1. Designing a Thread-safe Class
	4.1.1. Gathering Synchronization Requirements
	4.1.2. State-dependent Operations
	4.1.3. State Ownership
4.2. Instance Confinement
	4.2.1. The Java Monitor Pattern
	4.2.2. Example: Tracking Fleet Vehicles
4.3. Delegating Thread Safety
	4.3.1. Example: Vehicle Tracker Using Delegation
	4.3.2. Independent State Variables
	4.3.3. When Delegation Fails
	4.3.4. Publishing Underlying State Variables
	4.3.5. Example: Vehicle Tracker that Publishes Its State
4.4. Adding Functionality to Existing Thread-safe Classes
	4.4.1. Client-side Locking
	4.4.2. Composition
4.5. Documenting Synchronization Policies
	4.5.1. Interpreting Vague Documentation	
4.1. Designing a Thread-safe Class
	4.1.1. Gathering Synchronization Requirements
	4.1.2. State-dependent Operations
	4.1.3. State Ownership
	
Chapter 5. Building Blocks
5.1. Synchronized Collections
	5.1.1. Problems with Synchronized Collections
	5.1.2. Iterators and Concurrentmodificationexception
	5.1.3. Hidden Iterators
5.2. Concurrent Collections
	5.2.1. ConcurrentHashMap
	5.2.2. Additional Atomic Map Operations
	5.2.3. CopyOnWriteArrayList
5.3. Blocking Queues and the Producer-consumer Pattern
	5.3.1. Example: Desktop Search
	5.3.2. Serial Thread Confinement
	5.3.3. Deques and Work Stealing
5.4. Blocking and Interruptible Methods
5.5. Synchronizers
	5.5.1. Latches
	5.5.2. FutureTask
	5.5.3. Semaphores
	5.5.4. Barriers
	
Chapter 6. Task Execution
6.1. Executing Tasks in Threads
	6.1.1. Executing Tasks Sequentially
	6.1.2. Explicitly Creating Threads for Tasks
	6.1.3. Disadvantages of Unbounded Thread Creation
6.2. The Executor Framework
	6.2.1. Example: Web Server Using Executor
	6.2.2. Execution Policies
	6.2.3. Thread Pools
	6.2.4. Executor Lifecycle
	6.2.5. Delayed and Periodic Tasks
6.3. Finding Exploitable Parallelism
	6.3.1. Example: Sequential Page Renderer
	6.3.2. Result-bearing Tasks: Callable and Future
	6.3.3. Example: Page Renderer with Future
	6.3.4. Limitations of Parallelizing Heterogeneous Tasks
	6.3.5. CompletionService: Executor Meets BlockingQueue
	6.3.6. Example: Page Renderer with CompletionService
	6.3.7. Placing Time Limits on Tasks
	