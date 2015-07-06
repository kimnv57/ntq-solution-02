*** Java data types
- Primitive data types: byte, short, int, long, float, double, boolean, char
	store primitive values
- Reference data types:	String, Scanner, Random, Die, int[], String[], etc.
	reference variables store addresses


**** Java Collection Framework: big o
- ArrayList fast iteration - a lot of insertion and deletion:
	+ get/set: O(1)
	+ add: O(1)
	+ contains,remove... : O(n)
- LinkedList fast insertion and deletion:
	+ get/set:	O(n)
	+ add/remove (beginning/end)   O(1)
	+ add/remove (middle)  search + O(1)
	+ iteration slow
- LinkedHashSet:
    + add/remove: O(1) - if hash function is good - BUT SLOWER THAN HashSet
    + contains: O(1) - if hash function is good
    + iteration: O(element count)
- HashMap
	dont care obout order
    + get/put/contains:  O(1) - if hash function is good

- LinkedHashMap:
   + get/put/contains: O(1) - if hash function is good - BUT SLOWER THAN HashMap
   + iteration: better than HashMap

- TreeSet:
    +add/remove/contains: O(log n)

- TreeMap:
	care about order
    + get/put/contains/remove: O(log n)

 ***** exceptions
 - Checked: are the exceptions that are checked at compile time. If some code within a method throws a checked exception, then the method must either handle the exception or it must specify the exception using throws keyword
 - Unchecked: are the exceptions that are not checked at compiled time.

 *****Java Memory Management
 - Stack: Local variables
 - Heap: Object and instance variable

 *****
