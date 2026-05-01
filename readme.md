# Modern Java Mastery: The "Java 25" Fundamentals Syllabus
**Goal:** Master Core Java by combining deep Object-Oriented fundamentals with modern features (Records, Virtual Threads, Pattern Matching).
**Philosophy:** 80/20 Rule. Zero Frameworks. Pure Core Java.

---

## Phase 1: The Language Core (Weeks 1-3)
**Focus:** Memory models, Type systems, and the Logic of Java.

### Week 1: Syntax, Types & Control Flow
* **The Metal:**
    * JVM Architecture basics: Bytecode, JDK vs JRE.
    * `void main()` (Instance Main Methods - JEP 477).
* **Data & Memory:**
    * Primitives vs Wrappers (Autoboxing/Unboxing).
    * Stack vs Heap memory basics.
    * `var` for local variable type inference.
* **Operators:**
    * Arithmetic, Relational, Logical, Bitwise.
    * Ternary Operator (`? :`).
* **Modern Logic:**
    * **Switch Expressions:** Arrow syntax (`->`), `yield`, and exhaustiveness.
    * **Loops:** Enhanced `for-each` vs `for(i=0)`.
* **Text Processing:**
    * String Immutability & The String Pool.
    * `StringBuilder` vs `StringBuffer`.
    * **Text Blocks** (`"""`) and `String.formatted()`.

### Week 2: OOP Pillars I & II (The Blueprint)
* **Encapsulation (Data Hiding):**
    * Access Modifiers: `private`, `package-private`, `protected`, `public`.
    * **The Modern Way:** **Records** (`record User(String name)`) for immutable data carriers.
    * Compact Constructors in Records.
* **Inheritance (Code Reuse):**
    * `extends`, `super` keyword, Constructor chaining.
    * Method Overriding (`@Override`) vs Hiding.
    * **The Modern Way:** **Sealed Classes** (`sealed interface Shape permits Circle`) to restrict hierarchy.

### Week 3: OOP Pillars III & IV (Abstraction & Design)
* **Abstraction (Contracts):**
    * **Interfaces:** `default` methods, `private` interface methods, `static` methods.
    * **Abstract Classes:** When to share state vs behavior.
* **Polymorphism:**
    * Runtime Polymorphism (Dynamic Dispatch).
    * Upcasting vs Downcasting.
    * **Pattern Matching:** `if (obj instanceof String s)` (No manual casting).
* **Generics:**
    * Generic Classes (`Box<T>`) and Methods.
    * Bounded Wildcards (`List<? extends Number>`).
    * Type Erasure concepts.

---

## Phase 2: The Data Engine (Collections & Streams) (Weeks 4-6)
**Focus:** Efficiently storing, processing, and transforming data.

### Week 4: The Collections Framework (Fundamentals)
* **The Hierarchy:** `Iterable` -> `Collection`.
* **Lists:**
    * `ArrayList`: Dynamic array internals (growth factor).
    * `LinkedList`: When to use (rarely) vs `ArrayList`.
* **Sets:**
    * `HashSet`: Hashing mechanics (`hashCode()` & `equals()` contract).
    * `TreeSet`: Sorted sets (Red-Black tree basics).
    * `LinkedHashSet`: Ordering.
* **Maps (Key-Value):**
    * `HashMap`: Buckets, collisions, Load Factor, Treeification.
    * `TreeMap` vs `LinkedHashMap`.

### Week 5: Concurrent Collections & Thread Safety
* **The Safety Problem:** `ConcurrentModificationException`.
* **Atomic Variables:** `AtomicInteger`, `AtomicReference` (CAS operations).
* **Concurrent Collections (java.util.concurrent):**
    * `ConcurrentHashMap`: Segmentation & non-blocking reads.
    * `CopyOnWriteArrayList`: Read-heavy optimizations.
    * `BlockingQueue`: `ArrayBlockingQueue` vs `LinkedBlockingQueue`.
    * `ConcurrentSkipListMap`.

### Week 6: Streams, Lambdas & Parallelism
* **Functional Programming:**
    * Interfaces: `Predicate<T>`, `Function<T,R>`, `Consumer<T>`, `Supplier<T>`.
    * Method References (`String::toUpperCase`).
* **Stream API:**
    * **Intermediate:** `filter`, `map`, `flatMap`, `distinct`, `sorted`.
    * **Terminal:** `collect`, `reduce`, `count`, `anyMatch`.
    * **Gatherers (Modern):** Custom stream operations (JEP 461).
* **Parallelism:**
    * `stream().parallel()`.
    * The ForkJoinPool.
    * Performance pitfalls (boxing overhead).

---

## Phase 3: Robustness & Concurrency (Weeks 7-8)
**Focus:** Handling errors, IO, and massive-scale concurrency.

### Week 7: Exceptions, IO & Reflection
* **Exception Handling:**
    * Checked vs Unchecked Exceptions.
    * `try-catch-finally`.
    * **Modern Resource Management:** `try-with-resources` (`AutoCloseable`).
* **Modern IO (NIO.2):**
    * `Path`, `Files` class (`readString`, `writeString`).
    * Reading large files with `Files.lines()`.
* **Meta-Programming:**
    * **Reflection:** Accessing private fields/methods at runtime.
    * **Annotations:** Basics of creating custom annotations.

### Week 8: Modern Concurrency (Virtual Threads)
* **The Revolution (Project Loom):**
    * OS Threads vs Virtual Threads.
    * `Thread.startVirtualThread()`.
* **Structured Concurrency:**
    * `StructuredTaskScope`: Managing groups of threads as a single unit.
    * Shutdown policies (`ShutdownOnFailure`).
* **Scoped Values:**
    * Implicit data passing (Modern replacement for `ThreadLocal`).
* **HTTP Client:**
    * `java.net.http.HttpClient` for async web requests.

---

## The 5 Capstone Projects
**Constraint:** No frameworks. Core Java Standard Library only.

### 1. Custom "Spotify" Playlist Manager
* **Focus:** Collections (`LinkedList`, `HashSet`), Comparators.
* **Description:** Build a playlist CLI. Use `LinkedList` for the queue (easy reordering), `HashSet` to prevent duplicate additions, and `Comparator` to sort by Duration or Artist.

### 2. Flight Booking System (The "Seat Map" Challenge)
* **Focus:** `TreeMap`, `HashMap`, Encapsulation, Custom Exceptions.
* **Description:** Store flight data. Use `TreeMap` to keep flights sorted by time. Use `HashMap` for fast O(1) passenger lookups. Handle overbooking with custom Exceptions.

### 3. High-Frequency Trading Simulator
* **Focus:** `PriorityQueue`, `ConcurrentSkipListMap`.
* **Description:** A stock order book. Use `PriorityQueue` to keep the highest "Buy" bid at the top. Match orders in real-time.

### 4. Multi-Threaded Web Crawler
* **Focus:** `ConcurrentHashMap`, `LinkedBlockingQueue`, Virtual Threads.
* **Description:** A bot that crawls URLs. Use `ConcurrentHashMap` to track "Visited" sites safely. Use `LinkedBlockingQueue` for the to-do list. Spawn a Virtual Thread for every URL fetch.

### 5. "Big Data" File Analyzer
* **Focus:** Parallel Streams, File IO, Collectors.
* **Description:** Read a 1-million-row CSV. Use `Files.lines()` and `parallel()` streams to group data by category and calculate averages concurrently.