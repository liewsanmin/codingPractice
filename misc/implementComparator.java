/**
Practicing the Comparator and Comparable interfaces by overriding them
*/

import java.util.*;
class Dog implements Comparator<Dog>, Comparable<Dog>{
    private String name;
    private int age;

    Dog(){};
    Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getDogName(){
        return name;
    }

    public int getDogAge(){
        return age;
    }

    // overriding the compareTo method in Comparable
    public int compareTo(Dog d){
        return (this.name).compareTo(d.name);
    }

    // overriding the compare method in Comparator to sort the age
    public int compare(Dog d, Dog g){
        return d.age - g.age;
    }
}

public class Solution{
    public static void main(String[] args){
        List<Dog> list = new ArrayList<>();

        list.add(new Dog("Sahk", 12));
        list.add(new Dog("Oyet", 2));
        list.add(new Dog("kima", 82));

        Collections.sort(list);
        for(Dog curr : list){
            System.out.print(curr.getDogName() + " ");
        }
        System.out.println();

        Collections.sort(list, new Dog()); // Sorts the array list using comparator
        for(Dog curr : list){
            System.out.print(curr.getDogName() + " " + curr.getDogAge() + " ");
        }
    }
}
