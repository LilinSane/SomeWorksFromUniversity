package org.example.task_2;

import lombok.SneakyThrows;

import java.util.*;

public class BucketSort {
    public BucketSort() {
    }

    @SneakyThrows
    public List<Integer> sort(List<Integer> array){
        int numberOfBuckets = (int) Math.sqrt(array.size());
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        int maxValue = getMaxValue(array);
        int minValue = getMinValue(array);

        for(int i = 0; i < array.size(); i++) {
            buckets.add(new ArrayList<>());
        }

        for(int i : array){
            buckets.get(hash(i, minValue, maxValue, numberOfBuckets)).add(i);
        }

        for(List<Integer> bucket  : buckets){
            bucket.sort(comparator);
        }

        List<Integer> sortedArray = new LinkedList<>();

        for(List<Integer> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

        return sortedArray;
    }

    private int hash(int i, int min ,int max, int numberOfBuckets) {
        return (int) ((double) (i - min) / (max - min + 1) * (numberOfBuckets - 1));
    }

    @SneakyThrows
    private int getMaxValue(List<Integer> array) {
        int maxValue = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    @SneakyThrows
    private int getMinValue(List<Integer> array) {
        int minValue = Integer.MAX_VALUE;
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }
}
