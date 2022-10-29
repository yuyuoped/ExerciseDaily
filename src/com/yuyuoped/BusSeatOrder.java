package com.yuyuoped;

import java.util.*;

public class BusSeatOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Person2> list = new ArrayList<>();
        int i = 0;
        while (sc.hasNext()) {
            String in = sc.nextLine().trim();
            if (in.length() < 5) break;
            String[] str = in.split(" ", 2);
            list.add(new Person2(str[0], Integer.parseInt(str[1]), i++));
        }

        Solution9 solution = new Solution9();
        solution.priority(list);

        sc.close();
    }
}

class Person2 {
    String name;
    int age;
    int number;
    public Person2(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "number = " + number + ", name = " + name + ", age = " + age;
    }

}

class Solution9 {
    public void priority(List<Person2> list) {
        // write your code here
        int order = 1;
        List<Person2> waitForSortPerson = new ArrayList<>();

        for (Person2 person : list) {
            if (person.age > 60 || person.age < 5) {
                person.number = order++;
                System.out.println(person.toString());
            } else {
                waitForSortPerson.add(person);
            }
        }

        waitForSortPerson.sort(Comparator.comparingInt(p -> p.age));

        for (Person2 person : waitForSortPerson) {
            person.number = order++;
        }

        waitForSortPerson.forEach(System.out::println);
    }

}
