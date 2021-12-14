package com.epam.training.aleksandr_preobrazhenskiy.collections.optional_task;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Optional #2. Reversed digit");
        Deque<Integer> queue = new ArrayDeque<>();
        System.out.println("Enter number:");
        int number = input.nextInt();

        while (number>0){
            queue.offer(number%10);
            number /= 10;
        }

        System.out.print("Reversed: ");
        while (!queue.isEmpty()){ System.out.print(queue.poll()); }
        System.out.println();

        System.out.println("Optional #4. Poem to the list");
        String poem = String.join("\n"
                , "Some people say a man is made outta mud"
                , "A poor man's made outta muscle and blood"
                , "Muscle and blood and skin and bones"
                , "A mind that's a-weak and a back that's strong"
                , "You load 16 tons, what do you get?"
                , "Another day older and deeper in debt"
                , "St. Peter, don't you call me 'cause I can't go"
                , "I owe my soul to the company store"
        );

        System.out.println("Original poem: \n" + poem + "\n");
        List<String> poemList = Arrays.asList(poem.split("\n"));
        poemList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        System.out.println("Sorted by line length:");
        poemList.forEach(System.out::println);
        System.out.println();

        System.out.println("Optional #8. Words that differ");
        Set<String> words = new HashSet<String>();
        try {
            Scanner sc = new Scanner(new File("text.txt"));
            while(sc.hasNext()){
                // considering apostrophe as a part of a word
                String trimmed = sc.next().toLowerCase(Locale.ROOT).replaceAll("[^a-z']", "");
                if(trimmed.length()>0) { words.add(trimmed); }
            }
        } catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
        words.forEach(System.out::println);
        System.out.println("Total unique words: " + words.size());
    }
}