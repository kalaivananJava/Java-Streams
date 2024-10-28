package com.telusko.streamss;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class Streamss1 {
    public static void main(String[] args) {
        // List<Integer> values = new ArrayList<>();
        // for(int i=1;i<=100;i++){
        //     values.add(i);
        // }
        // //filter - give odd numbers
        // values.stream().filter(i -> {
        //    System.out.println("hi");
        //    return true;
        // }).findFirst()).orElse(0);

          List<Integer> values = Arrays.asList(1,2,3,4,5,6);
        //   int result=0;
        //   for(int i:list){
        //     result=result+i*2;
        //   }
        //   System.out.println(values.stream().map(i -> i*2).reduce(0,(c,e) -> c+e));
        
      
        Function<Integer,Integer> f = new Function<Integer,Integer>(){
            public Integer apply(Integer i){
                return i * 2;
            }
        };
        BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
           
            public Integer apply(Integer i,Integer j){
               return i+j;
            }
        };
        Stream s = values.stream();
       // System.out.println(s);

         Stream s1=s.map(f);// return the object of stream...
        Integer result  = (Integer)s1.reduce(0,b);

        //  s.forEach(System.out::println);

        // Stream s2=s1.reduce(0,);
         System.out.println(result);
        
         Stream.of("one", "two", "three", "four")
  .filter(e -> e.length() > 3)
  .peek(e -> System.out.println("Filtered value: " + e))
  .map(String::toUpperCase)
  .peek(e -> System.out.println("Mapped value: " + e)).forEach(System.out::println);

    }
}
