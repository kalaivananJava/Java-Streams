package com.telusko.streamss;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Training {
    public static void main(String[] args) {
          List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bobi", 30),
                new Person("Charlie", 35),
                new Person("Davidi", 40),
                new Person("Eve", 45),
                new Person("Frank", 50),
                new Person("Grace", 55),
                new Person("Henrye", 60),
                new Person("Isaace", 65),
                new Person("John", 70)
        );
persons.stream().filter( i ->i.getName().endsWith("e")).filter(i -> i.getAge()>50).map(i -> i.getName()).forEach(System.out::println);
// Optional<String> str=
Optional<String> age=persons.stream().max(Comparator.comparing(Person::getAge)).map(Person::getName);

 System.out.println(age.get());

 //If a person with the minimum name exists, this prints their name along with the specified message. If the stream is empty, nothing is printed.
persons.stream().min(Comparator.comparing(i -> i.getName())).ifPresent(i-> System.out.println("He is the small name" +i.getName()));

//.filter(s -> s.getName().endsWith("i")): This filters the stream, retaining only Person objects whose names end with the letter “i.”
//.collect(Collectors.toList()): This collects the filtered Person objects into a list.

List<Person> l1 = persons.stream().filter(s -> s.getName().endsWith("i")).collect(Collectors.toList());
l1.stream().map(i -> i.getName()).forEach(System.out::println);

// count
long n = persons.stream().filter(e -> e.getName().endsWith("i")).count();
System.out.println(n);

//
List<Person> p=persons.stream().distinct().collect(Collectors.toList());
p.stream().map(i -> i.getName()).forEach(System.out::println);



// The allMatch() method in Java streams checks whether all elements in the stream match a given condition. However, it doesn’t return a stream of elements; instead, it returns a boolean value indicating whether the condition holds for all elements.

boolean allMatchCondition = persons.stream()
    .allMatch(p1 -> p1.getAge() > 20 && p1.getName().startsWith("v"));

if (allMatchCondition) {
    persons.forEach(i -> System.out.println(i.getName() + " " + i.getAge()));
} else {
    System.out.println("No matching persons found.");
}

// nonematch
System.out.println("none match");
boolean b2 = persons.stream().noneMatch(p1 -> p1.getAge() < 20);


if (b2) {
    persons.forEach(i -> System.out.println(i.getName() + " " + i.getAge()));
} else {
    System.out.println("No matching persons found.");
}

   // anymatch
   boolean b3 = persons.stream().anyMatch(p1 -> p1.getAge() > 20 && p1.getName().startsWith("A"));
   System.out.println(b3);

   
if (b3) {
    persons.forEach(i -> System.out.println(i.getName() + " " + i.getAge()));
} else {
    System.out.println("No matching persons found.");
}

    // string reduce
    String[] myArray = { "this", "is", "a", "sentence" };
    String result = Arrays.stream(myArray).reduce("", (a, b) -> a + b+" ");
    System.out.println(result);
    
    Optional<Person> anyEmp= persons.stream().filter(s->s.getName().endsWith("i")).findAny();
    if (anyEmp.isPresent()) {
        System.out.println("Any Employee ends with i: " + anyEmp.get().getName());
      }
       // find any
  
      Optional<Person> anyEmpAbove40 = persons.stream().filter(emp -> emp.getAge() > 40).findAny();
      if (anyEmpAbove40.isPresent()) {
        System.out.println("Any Employee above age 40: " + anyEmpAbove40.get().getName());
      }

      // find first
    Optional<Person> o1 = persons.stream().filter(emp -> emp.getAge() > 20).findFirst();
    if (o1.isPresent()) {
      System.out.println("Any Employee above age 20: " + o1.get().getName());
    }

      // sort
      List<Person> slist = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
      slist.stream().map(i -> i.getAge()).forEach(System.out::println);
//we create a stream from the array using Stream.of(ll1).
// we use .toArray(Person[]::new) to convert the filtered stream into an array of Person objects
      Person[] ll1 =persons.stream().filter(s->s.getName().endsWith("i")).toArray(Person[]::new);
Stream.of(ll1).map(i -> i.getName()).forEach(System.out::println);

// peek//The peek(i -> System.out.println(i * i)) operation applies the given lambda expression 
//to each element in the stream.
List<Integer> list = Arrays.asList(10, 11, 12);
list.stream().peek(i -> System.out.println(i * i)).collect(Collectors.toList());

Stream<Person> stream = persons.parallelStream(); 
List<Person> evenNumbersArr
      = stream.filter(emp -> emp.getAge() > 40).collect(Collectors.toList());

    for(Person even:evenNumbersArr) { System.out.println(even.getName()); }

    //mapToint
    int sum1 = persons.stream().mapToInt(Person::getAge).sum();
    System.out.println(sum1);
    // maptodouble
    double sum2 = persons.stream().mapToDouble(Person::getAge).sum();
    System.out.println(sum2);
 
    // maptolong
    long sum3 = persons.stream().mapToLong(Person::getAge).sum();
    System.out.println(sum3);
 
    // average
    double sum4 = persons.stream().mapToDouble(Person::getAge).average().getAsDouble();
    System.out.println(sum4);
 
    // collect
    List c2 = persons.stream().map(Person::getName).collect(Collectors.toList());
    System.out.println(c2);
/*
   * Creating a Stream Builder:
We start by creating a Stream.Builder<String> named b.
The Stream.Builder class provides a way to build a stream incrementally by adding elements to it.
Adding Elements to the Builder:
We use b.accept("a"), b.accept("b"), b.accept("c"), and b.accept("d") to add four strings (“a”, “b”, “c”, and “d”) to the builder.
These elements are not part of the stream yet; they are just stored in the builder.
Building the Stream:
Next, we call b.build() to create a stream from the builder.
The stream (s) contains the elements we added earlier: “a”, “b”, “c”, and “d”.
Printing the Stream Elements:
Finally, we use s.forEach(System.out::println) to print each element in the stream
   */
  Stream.Builder<String> b = Stream.builder();
  b.accept("a");
  b.accept("b");
  b.accept("c");
  b.accept("d");
  Stream<String> s = b.build();
  s.forEach(System.out::println);
    /*
    Creating a 2D Array of Strings:
We start with a 2D array of strings called data.
The array contains three subarrays: {"a", "b"}, {"c", "d"}, and {"e", "f"}.
Creating a Stream from the 2D Array:
We use Arrays.stream(data) to create a stream of arrays (Stream<String[]>).
The resulting stream (temp) contains the three subarrays.
Flattening the Stream of Arrays:
Next, we apply .flatMap(x -> Arrays.stream(x)) to the temp stream.
This operation flattens the stream of arrays into a single stream of strings.
The resulting stream (stringStream) contains the elements: "a", "b", "c", "d", "e", and "f".
Filtering the Stream:
We use .filter(x -> "a".equals(x.toString())) to filter the stream.
Only the element "a" passes the filter.
Printing the Filtered Element:
Finally, stream1.forEach(System.out::println) prints the filtered element (which is "a") to the console.
So, the output will be:

a
     */
     // flat map
     String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" } };
     Stream<String[]> temp = Arrays.stream(data);
     Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));
     Stream<String> stream1 = stringStream.filter(x -> "a".equals(x.toString()));
     stream1.forEach(System.out::println);
   }
  /*
   * Creating a Stream Builder:
We start by creating a Stream.Builder<String> named b.
The Stream.Builder class provides a way to build a stream incrementally by adding elements to it.
Adding Elements to the Builder:
We use b.accept("a"), b.accept("b"), b.accept("c"), and b.accept("d") to add four strings (“a”, “b”, “c”, and “d”) to the builder.
These elements are not part of the stream yet; they are just stored in the builder.
Building the Stream:
Next, we call b.build() to create a stream from the builder.
The stream (s) contains the elements we added earlier: “a”, “b”, “c”, and “d”.
Printing the Stream Elements:
Finally, we use s.forEach(System.out::println) to print each element in the stream
   */
}
