package main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8FrequentProgrammingQA {

    public static void main(String[] args) {
        String input = "ILovejavatechie";

        /*get the character and thier counts*/
        Map<String, Long> map = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        /*find all duplicate element from a given string*/

        List<String> duplicateKey = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicateKey);

        /*find unique element*/

        List<String> uniqueEle = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().filter(s -> s.getValue() ==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(uniqueEle);

        /*find first non repeat element*/
        String firstNonRepeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(s -> s.getValue() == 1)
                .findFirst()
                .get().getKey();
        System.out.println(firstNonRepeat);

        /*find first repeat element*/
        String firstRepeat = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream().filter(s -> s.getValue() > 1)
                .findFirst()
                .get().getKey();
        System.out.println(firstRepeat);

        /* find second-highest number from given string*/
        int[] numbers = {5,9,11,2,8,21,1};






    }
}
