package com.telusko.streamss;

import java.util.Arrays;
import java.util.List;
// import java.util.function.Consumer;
import java.util.function.Consumer;

public class Streamss {
    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(10,20,3,4,5,6);

        // Consumer<Integer> con = new Consumer<Integer>(){
        //     public void accept(Integer n){
        //         System.out.println(li);
        //     }
        // };
//  Consumer<Integer> con = (Integer i) -> System.out.println(i); 
        // li.forEach(new Consumer<Integer>(){
        //     public void accept(Integer i){
        //         System.out.println(i);
        //     }
        // }) ;
//forEach() only accepts Consumer object , and that consumer interface has only accept() so,we are removing 
//that and giving only parameter.
       // li.forEach(i -> System.out.println(i));
      // li.forEach(System.out::println);//doubt

    //  li.forEach(i->doubleIt(i));
       li.forEach(Streamss::doubleIt);
    }
    public static void doubleIt(int i){
        System.out.println(i*2);
    }
}
