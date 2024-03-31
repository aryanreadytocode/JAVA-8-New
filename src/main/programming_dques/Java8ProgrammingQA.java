package main.programming_dques;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8ProgrammingQA {

    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("9900693210", "9874563210")),
                new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("8900693210", "9874568640")),
                new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("8800693210", "7874563211")),
                new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("9978993210", "7700563210")),
                new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("9988693210", "9830163210")),
                new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("9780693210", "9854563210")),
                new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("9900021210", "9896323210")),
                new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("9630693210", "7896563210")),
                new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("9963293210", "9801203210")),
                new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("9987493210", "3654563210"))
        ).collect(Collectors.toList());

        Map<String, List<Student>> studentL = studentList.stream().collect(Collectors.groupingBy(student -> student.getDept()));


        // find the student whose rank between 50 to 100
        List<Student> students = studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .collect(Collectors.toList());
        System.out.println(students);

        // find student live in karnataka and then sort by name
        List<Student> karnatakaStudent = studentList.stream()
                .filter(student -> student.getCity().equals("Karnataka"))
                .sorted(Comparator.comparing(Student::getFirstName, Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(karnatakaStudent);

        // Find all departments name
        List<String> departmentName = studentList.stream().map(Student::getDept).collect(Collectors.toList());

        // Find all unique departments name
        Set<String> uniqueDept = studentList.stream().map(Student::getDept).collect(Collectors.toSet());

        System.out.println(uniqueDept);

        // find the contact numbers
        List<String> contacts = studentList
                .stream()
                .flatMap(student -> student.getContact().stream().distinct())
                .collect(Collectors.toList());
        System.out.println(contacts);

        //
        // Collection is interface which comtains most common method like add remove size
        // Collections is class act as utility clas which has method like sort stream binarySearch


//        Set
        //HashSet
        //LinkedHashSet

//        SortedSet
//        NavigableSet
//        Queue
//        IdentityHashMap
        ArrayList<Integer> al = new ArrayList<>();

        List<Integer> al1 = Collections.synchronizedList(al);


    }

}
