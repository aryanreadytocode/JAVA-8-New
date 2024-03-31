package main;

import java.awt.dnd.DragGestureEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiQA {

    public static void main(String[] args) {
        int[] arr = {5,4,2,5,6,4};
        Set<Integer> rses = Arrays.stream(arr).boxed().collect(Collectors.toSet());
//        List<Student> studentList = Stream.of(
//                new Student(1, "Rohi")
//        )
    }
}
