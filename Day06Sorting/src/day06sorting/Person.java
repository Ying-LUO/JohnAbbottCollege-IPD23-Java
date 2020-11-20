/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day06sorting;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author YingLuo
 */
                                        //normally the same as the class name
public class Person implements Comparable<Person>{

    public Person(String name, int age, double heightMeters) {
        this.name = name;
        this.age = age;
        this.heightMeters = heightMeters;
    }
    

    String name;
    private int age;
    double heightMeters;

    public double getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(double heightMeters) {
        this.heightMeters = heightMeters;
    }
   
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person{ name= %s, age= %d, height= %.2f}", name, age, heightMeters);
    }

    @Override
    public int compareTo(Person o) {
        
        /*
        //Comparing by age
        if(this.age == o.age){
         return 0;
        }
        
        if(this.age > o.age){
         return 1;
        }
        
        if(this.age < o.age){
         return -1;
        }
        */
        
        // faster way, logic way is the same as this
        return this.age -o.age;
        
        //Cannot Sort by extra index name since Comparable interface has one compareTo method for sorting, 
        //if it has been used to sort for age, you have to consider another interface Comparator

    }
    
                                                    // Anonymous methods
    static final Comparator<Person> compareByName3 = (Person p1, Person p2) -> p1.name.compareTo(p2.name);
    
    
    
                                                    // Anonymous class
    static final Comparator<Person> compareByName2 = new Comparator<Person>(){
        
        @Override
        public int compare(Person p1, Person p2) {

            return p1.name.compareTo(p2.name);
        }
        
    };
    
     static final Comparator<Person> compareByHeight = (Person p1, Person p2) -> {
         int tag = 0;
         if(p1.heightMeters == p2.heightMeters){
             tag = 0;
         }
         
         if(p1.heightMeters > p2.heightMeters){
             tag = 1;
         }
         
         if(p1.heightMeters < p2.heightMeters){
             tag = -1;
         }
         return tag;
    };
     
     
     static final Comparator<Person> compareByNameAndThenAge = (Person p1, Person p2) -> {
          
         if(p1.name.equals(p2.name)){
             return p1.age -p2.age;
         }else{
            return p1.name.compareTo(p2.name);
         }
    };
    
        //Used to reuse the new instaciated inner class
        static final ComparePersonByName compareByName = new ComparePersonByName();                                         
     
}

// Suggest to use anonymous method or class to implement the comparator, rather than create an inner class which is not recommended
                                            // the object class need to sort, no the same as current class name
class ComparePersonByName implements Comparator<Person>{

        
        //original parameter o1, o2 stands for object1, object2
        @Override
        public int compare(Person p1, Person p2) {
            
      
            // object compareTo method
            /* 
                public int compareTo(Person o)
                    Compares this object with the specified object for order. 
                    Returns a negative integer, zero, or a positive integer as this object is less than, 
                    equal to, or greater than the specified object. 
            */
            return p1.name.compareTo(p2.name);
        }
        
    }