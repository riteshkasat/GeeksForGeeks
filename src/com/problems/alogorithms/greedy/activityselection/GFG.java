package com.problems.alogorithms.greedy;

import com.problems.alogorithms.greedy.activityselection.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GFG {
    private List<Pair> times;

    public GFG(List<Pair> times) {
        this.times = times;
    }


    public List<Integer> getMaxCount() {
        Collections.sort(times);
        List<Integer> list = new ArrayList<>();
        list.add(times.get(0).getKey());

        int size = times.size();

        long c = times.get(0).getEndTime();

        for (int i = 0; i < size - 1; i++) {

            Pair next = times.get(i + 1);

            if (c <= next.getStartTime()) {
                c = next.getEndTime();
                list.add(next.getKey());
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTests = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfTests; i++) {
            List<Pair> pairs  = readInput(sc);
            GFG activitySelection = new GFG(pairs);

            List<Integer> result = activitySelection.getMaxCount();
            for (Integer item : result) {
                System.out.print(item + " ");
            }
        }

    }

    public static List<Pair> readInput(Scanner sc) {
        int count = Integer.parseInt(sc.nextLine());
        List<String> l1 = Arrays.asList(sc.nextLine().split(" "));
        List<String> l2 = Arrays.asList(sc.nextLine().split(" "));

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            pairs.add(new Pair(Long.parseLong(l1.get(i)), Long.parseLong(l2.get(i)), i + 1));
        }
        return pairs;
    }
}
