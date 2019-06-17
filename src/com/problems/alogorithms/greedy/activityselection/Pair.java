package com.problems.alogorithms.greedy.activityselection;

public class Pair implements Comparable<Pair> {
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    private long startTime;
    private long endTime;
    private int key;

    public int getKey() {
        return key;
    }


    public Pair(long startTime, long endTime, int key) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.key = key;
    }


    @Override
    public int compareTo(Pair p) {
        Long value = this.endTime - p.endTime;
        return value.intValue();

    }

    @Override
    public String toString() {
        return "Pair{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
