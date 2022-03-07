package com.dkit.gd2.johnloane;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * OOP CA3
 * @author John Loane
 */
public class App 
{
    public static void main( String[] args )
    {
        //Question 1
        List<Employee> employees = new ArrayList<>();
        addFiveEmployees(employees);
        questionOnePartA(employees);
        questionOnePartB(employees);
        questionOnePartC(employees);
        questionOnePartD(employees);

        //Question 2
        List<Student> students = new ArrayList<>();
        addFourStudents(students);
        questionTwoPartB(students);
        questionTwoPartC(students);
        questionTwoPartD();

        //Question 3
        List<String> oneHundredStrings = new ArrayList<>();
        populateOneHundredStrings(oneHundredStrings);
        questionThreePartA(oneHundredStrings);
        questionThreePartB();

        //Question 4
        compareTwoStudents();
        questionFourPartA();
        questionFourPartB();
        questionFourPartC();
    }

    private static void questionFourPartC()
    {
        //Added equals and hashcode methods to Student class
    }

    private static void questionFourPartB()
    {
        //The hashcodes are different as they are using the default hashCode() method from Object which uses the address
    }

    private static void questionFourPartA()
    {
        //The method returns false as it is just using the default Object equals method which considers two objects to be different if they have different memory addresses
    }

    private static void questionThreePartB()
    {
        //Complexity is O(n) has have to look at each element of the list and add to the Set. Adding to set is O(1)
    }

    private static void questionThreePartA(List<String> oneHundredStrings)
    {
        Set uniqueStrings = new LinkedHashSet();
        for(String current : oneHundredStrings)
        {
            uniqueStrings.add(current);
        }
        System.out.println(uniqueStrings);
    }

    private static void questionTwoPartD()
    {
        //The complexity of adding students to the arrayList is O(1) as long as the list does not need to grow. If the list needs to grow the complexity is O(n)
        //Collection.sort() uses List.sort() which uses mergesort which is nln(n) complexity
    }

    private static void questionTwoPartC(List<Student> students)
    {
        Collections.sort(students, new StudentAgeComparator());
        printStudents(students);
    }

    private static void addFourStudents(List<Student> students)
    {
        Student michael = new Student(1, "Michael", 18);
        students.add(michael);
        Student joanna = new Student(2, "Joanna", 19);
        students.add(joanna);
        Student niall = new Student(3, "Niall", 21);
        students.add(niall);
        Student emily = new Student(4, "Emily", 20);
        students.add(emily);
    }

    private static void questionTwoPartB(List<Student> students)
    {
        Collections.sort(students);
        printStudents(students);
    }

    private static void printStudents(List<Student> students)
    {
        for(Student student : students)
        {
            System.out.println(student);
        }
    }

    private static void questionOnePartD(List<Employee> employees)
    {
        Queue<Employee> waitingList = new LinkedList<>();
        for(Employee employee : employees)
        {
            waitingList.add(employee);
        }
        getNextOnWaitingList(waitingList);
    }

    private static void getNextOnWaitingList(Queue<Employee> waitingList)
    {
        System.out.println(waitingList.poll());
    }

    private static void questionOnePartC(List<Employee> employees)
    {
        Map<String, Integer> namesAndCount = new HashMap<>();
        for(Employee employee : employees)
        {
            if((namesAndCount.get(employee.getFirstName()) != null))
            {
                namesAndCount.put(employee.getFirstName(), namesAndCount.get(employee.getFirstName()+1));
            }
            else
            {
                namesAndCount.put(employee.getFirstName(), 1);
            }
        }
        printNameAndCount(namesAndCount);
    }

    private static void printNameAndCount(Map<String, Integer> namesAndCount)
    {
        for(String name : namesAndCount.keySet())
        {
            System.out.println(name + " " + namesAndCount.get(name));
        }
    }

    private static void questionOnePartB(List<Employee> employees)
    {
        Set<Employee> uniqueEmployees = new HashSet<>();
        for(Employee employee : employees)
        {
            uniqueEmployees.add(employee);
        }
        printUniqueNames(uniqueEmployees);
    }

    private static void printUniqueNames(Set<Employee> uniqueEmployees)
    {
        System.out.println(uniqueEmployees);
    }

    private static void questionOnePartA(List<Employee> employees)
    {
        //Use an ArrayList as it allows fast random access
        pickLuckyWinner(employees);
    }

    private static void pickLuckyWinner(List<Employee> employees)
    {
        System.out.println(employees.get(ThreadLocalRandom.current().nextInt(0, employees.size())));
    }

    private static void addFiveEmployees(List<Employee> employees)
    {
        Employee john = new Employee("John", "Deering");
        employees.add(john);
        Employee james = new Employee("James", "McArthur");
        employees.add(james);
        Employee janet = new Employee("Janet", "Jackson");
        employees.add(janet);
        Employee michael = new Employee("Michael", "Lowry");
        employees.add(michael);
        Employee siobhan = new Employee("Siobhan", "Manning");
        employees.add(siobhan);
    }

    //The method below relates to Question 4
    private static void compareTwoStudents()
    {
        Student alex1 = new Student(1, "Alex", 22);
        Student alex2 = new Student(1, "Alex", 22);
        System.out.println("alex1 hashcode = " + alex1.hashCode());
        System.out.println("alex2 hashcode = " + alex2.hashCode());
        System.out.println("Checking equality between alex1 and alex2 = " + alex1.equals(alex2));
    }

    //This is just a helper method to populate the list of strings for question 3. You do not need to read it to answer any of the questions in the CA
    private static void populateOneHundredStrings(List<String> oneHundredStrings)
    {
        for(int i=0; i < 100; i++)
        {
            if(i / 10 == 0)
            {
                oneHundredStrings.add("Java");
            }
            else if(i / 10 == 1)
            {
                oneHundredStrings.add("Python");
            }
            else if(i / 10 == 2)
            {
                oneHundredStrings.add("C++");
            }
            else if(i / 10 == 3)
            {
                oneHundredStrings.add("Javascript");
            }
            else if(i / 10 == 4)
            {
                oneHundredStrings.add("Ruby");
            }
            else if(i / 10 == 5)
            {
                oneHundredStrings.add("Golang");
            }
            else if(i / 10 == 6)
            {
                oneHundredStrings.add("C#");
            }
            else if(i / 10 == 7)
            {
                oneHundredStrings.add("C");
            }
            else if(i / 10 == 8)
            {
                oneHundredStrings.add("R");
            }
            else if(i / 10 == 9)
            {
                oneHundredStrings.add("Swift");
            }
        }
    }
}
