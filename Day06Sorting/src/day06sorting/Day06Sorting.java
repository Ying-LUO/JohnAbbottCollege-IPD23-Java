/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author YingLuo
 */
public class Day06Sorting {

    /**
     * @param args the command line arguments
     */
    
    
    static ArrayList<Person> people = new ArrayList<>();
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        people.add(new Person("Jerry", 33, 1.78));
        people.add(new Person("Adam", 78, 1.80));
        people.add(new Person("Martha", 55, 1.76));
        people.add(new Person("Elsa", 15, 1.79));
        people.add(new Person("Tom", 31, 1.72));
        people.add(new Person("Barry", 53, 1.83));
        people.add(new Person("Tom", 12, 1.83));
        people.add(new Person("Barry", 34, 1.83));
        
        System.out.println("Original Order \n" + Arrays.deepToString(people.toArray()));
        
        //Collections sort method required the object class implement the Comparable interface
        //If comments out the implement Comparable sentence from person class, then this Collections.sort cannot be used
        Collections.sort(people);
        System.out.println("Order by Age(using Comparable)\n" + Arrays.deepToString(people.toArray()));
        
        //Lambda
        //Comparator interface used to compare object by name
        //Call by Anonymous method or class
        Collections.sort(people, Person.compareByName2);   //Anonymous class
        Collections.sort(people, Person.compareByName3);   //Anonymous method (??Kind of array function)
        //Collections.sort(people, new ComparePersonByName());
        System.out.println("Order by Name(using Comparator)\n" + Arrays.deepToString(people.toArray()));
        
        
        //Comparator interface implement by anonumous method
        Collections.sort(people, Person.compareByHeight);
        //Collections.sort(people, new ComparePersonByName());
        System.out.println("Order by Height(using Comparator)\n" + Arrays.deepToString(people.toArray()));
        
        Collections.sort(people, Person.compareByNameAndThenAge);
        //OR Collections.sort(people, Comparator.comparing(Person::getName).thenComparingInt(Person::getAge));
        System.out.println("Order by Name and then by Age(using Comparator)\n" + Arrays.deepToString(people.toArray()));
        
    }
    
}
