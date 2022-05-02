package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordsCounter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] split = line.split(" ");

        List<Integer> wordsCounts = new ArrayList<>();
        for (String s : split) {
            wordsCounts.add(s.length());
        }

        System.out.println(wordsCounts);
    }
}
