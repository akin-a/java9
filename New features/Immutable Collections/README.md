Motivation
---------
Prior to JDK 9, creating a small, unmodifiable collection of List, Set, or Map involves constructing it, storing it in a local variable, and invoking add() on it several times, and then wrapping it. For example,

```
 List lst1 = new ArrayList<>();  // construct and store in a local variable /n
   lst1.add("apple1");             // several add()'s
   lst1.add("orange1");
   lst1.add("banana1");
   lst1 = Collections.unmodifiableList(lst1);  // wrap it
```

Alternatively, you could populate a collection using a "copy constructor" from another collection, for example,

```
// Using the "copy constructor" of ArrayList
List lst2 = Collections.unmodifiableList(
new ArrayList<>(Arrays.asList("apple2", "orange2", "banana2")));
````

Another alternative is to use the so-called "double brace" technique, which uses the instance-initializer construct in an anonymous inner class, for example,

List lst3 = Collections.unmodifiableList(new ArrayList<>() {{
add("apple3"); add("orange3"); add("banana3");
}});
You could also use the Java 8's Stream API to construct small collections, by combining stream factory methods and collectors, for example,

List lst4 = Collections.unmodifiableList(
Stream.of("apple4", "orange4", "banana4").collect(Collectors.toList()));
JDK 9 New Features
JDK 9 provides a static factory method called of() in the List, Set, and Map interfaces to simplify creation of unmodifiable instances of these collections. We can write:

List<String> lst = List.of("apple", "orange", "banana");
Set<String> set = Set.of("apple", "orange", "banana");
Map<Integer, String> map = Map.of(1, "apple", 2, "orange", 3, "banana");
For List and Set, the factory methods of() are heavily overloaded for zero to ten elements, plus arbitrary number of elements, as follows:

// List interface's factory method to return an immutable list
static <E> List<E> of​(E... elements)  // an arbitrary number of elements with varargs
static <E> List<E> of​()               // zero elements
static <E> List<E> of​(E e1)           // one element (fixed)
static <E> List<E> of​(E e1, E e2)     // two elements
static <E> List<E> of​(E e1, E e2, E e3)  // three elements
......
static <E> List<E> of​(E e1, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10)  // ten elements

// Set interface has a similar set of overloaded methods
The of() includes varargs overloads, so that there is no limit on the size. It is tuned for smaller sizes with fixed-argument overloads for up to ten of elements. While this introduces some clutter in the API, it avoids array allocation, initialization, and garbage collection overhead that is incurred by varargs calls.

For Map, a set of fixed-argument methods are provided for zero to ten elements:

static <K,V> Map<K,V> of​()  // zero elements
static <K,V> Map<K,V> of​(K k1, V v1)  // one element
static <K,V> Map<K,V> of​(K k1, V v1, K k2, V v2)  // two elements
......
static <K,V> Map<K,V> of​(K k1, V v1, K k2, V v2,
K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6,
K k7, V v7, K k8, V v8, K k9, V v9, K k10, V v10)  // ten elements
To support arbitrary number of elements, the Map interface provides a static method called ofEntries(), which takes argument of Map.Entry objects, as follows:

static <K,V> Map<K,V> ofEntries​(Map.Entry<? extends K,? extends V>... entries)
Another static method called entry() is also provided to create a Map.Entry object:

static <K,V> Map.Entry<K,V> entry​(K k, V v)  // Returns an immutable Map.Entry containing the given key and value.
For examples,

Map<Integer, String> m1 = Map.of(1, "apple1", 2, "orange2", 3, "banana3");  // three elements (fixed)

Map<Integer, String> m2 = Map.ofEntries(  // arbitrary elements
Map.entry(1, "apple2"),
Map.entry(2, "orange2"),
Map.entry(3, "banana2"));
Note that interface's static methods are not inherited, so it will not be possible to invoke them via an implementing subclasses, nor via an instance of the interface type.
