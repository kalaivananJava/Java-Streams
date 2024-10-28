package com.telusko.streamss;

import java.util.*;

public class mapReduce {
    public static void main(String[] args) {
        List<Integer> values=Arrays.asList(1,2,3,4,5,6,10,15,20);
        values.stream().map(i -> i*2)
        .forEach(System.out::println);

        System.out.println(values.stream().reduce(1,(c,e) -> c+e));//22 coz => total =21 + identity=1=22
        System.out.println(values.stream().reduce(0,(c,e) ->Integer.sum(c,e)));
        System.out.println(values.stream().reduce(0,Integer::sum));

        /* i need the numbers which sum of multiples of 5
        int result=0
        for(int i: values){
            if(i%5==0){
             result+=i;
            }
            sout(result);
        } 

         */
        values.stream().filter( i -> i%5==0).forEach(System.out::println);
        System.out.println( values.stream().filter( i -> i%5==0).reduce(0,(c,e) -> c+e));
    
        // i need the value which is first multiple of 5 in the list-> i use findFirst()

        System.out.println(values.stream().filter(i -> i%5==0).findFirst());//Optioal[5]
        //Optional[5] means there is a chance that in the array there is no values that multiples of 5 
        //in that scenario it don't need to provide error so it provides optional[finded value]
        //if there is no value gives Optional.empty

        List<Integer> opt=Arrays.asList(6,7,8,9);
        System.out.println(opt.stream().filter(i -> i%5==0).findFirst());//Optional.empty
        // if not need optional.empty u use orElse(0) or orElse(null)
        System.out.println(opt.stream().filter(i -> i%5==0).findFirst().orElse(null));//null
        int result=0;
        for(int i: values){
            if(i % 5 == 0){
                result= i*2;
                break;
            }
        }

   System.out.println(result);

   //actually in ourpoint of view stream is less efficient but. when stream sees the terminal operations 
   //findFirst() it will only filter first value and map also 1 value. so stream is more efficient.
System.out.println("efficient ");
   System.out.println(values.stream().filter(mapReduce::isDivisible).map(mapReduce::idDouble).findFirst().orElse(0));
    }

    public static boolean isDivisible(int i){
        System.out.println("is divisible "+i);
        return i%5==0;
    }

    public static  int idDouble(int i){
        System.out.println("in idDouble "+i);
        return i*2;
    }
    
}
