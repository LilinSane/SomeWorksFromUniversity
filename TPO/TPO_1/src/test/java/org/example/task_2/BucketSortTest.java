package org.example.task_2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BucketSortTest {

    @Test
    void testBucketSort() {
        BucketSort bucketSort = new BucketSort();
        assertAll(
                () -> assertArrayEquals(new ArrayList<>(Arrays.asList(2, 2, 20, 33, 100)).toArray(),
                        bucketSort.sort(new ArrayList<>(Arrays.asList(20, 33, 2, 100, 2))).toArray()
                ),
                () -> assertArrayEquals(new ArrayList<>(Arrays.asList(2, 11, 68, 80, 167, 189, 192, 228, 245, 385, 463, 477, 511, 544, 585, 590, 596, 606, 626, 644, 661, 699, 752, 757, 794, 823, 882, 898, 913, 938)).toArray(),
                bucketSort.sort(new ArrayList<>(Arrays.asList(661, 385, 626, 463, 898, 228, 192, 606, 68, 167, 189, 80, 477, 757, 245, 644, 882, 590, 794, 2, 752, 585, 511, 596, 913, 11, 823, 544, 699, 938))).toArray()
                ),
                () -> assertArrayEquals(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5)).toArray(),
                        bucketSort.sort(new ArrayList<>(Arrays.asList(3, 0, 4, 2, 1, 5))).toArray()
                )
        );
    }

    @Test
    void testBucketSortEmpty(){
        BucketSort bucketSort = new BucketSort();
        assertArrayEquals(new ArrayList<>().toArray(),
                bucketSort.sort(new ArrayList<>()).toArray()
        );
    }

    @Test
    void testBucketSortZeros(){
        BucketSort bucketSort = new BucketSort();
        assertArrayEquals(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)).toArray(),
                bucketSort.sort(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0))).toArray()
        );
    }

    @Test
    void testBucketSortNull() {
        BucketSort bucketSort = new BucketSort();
        assertThrows(NullPointerException.class, () -> bucketSort.sort(null));
    }

    @Test
    void testBucketSortNegative(){
        BucketSort bucketSort = new BucketSort();
        assertArrayEquals(new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4 ,5)).toArray(),
                bucketSort.sort(new ArrayList<>(Arrays.asList(-1, -3, 2, 4, -5, 3, -2, 1, -4, 5, 0))).toArray()
        );
    }

}
