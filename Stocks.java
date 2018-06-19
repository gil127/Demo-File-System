package com.company;

/**
 * Created by gild on 6/4/18.
 */
public class Stocks {

    private static int[] arr = {0, 1, 2, 4, 0, 5};

    public int maxDiff() {
        int maxDiff = arr[1] - arr[0];
        int minElement = arr[0];
        int minElementIndex = 0, maxElementIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - minElement > maxDiff) {
                maxDiff = arr[i] - minElement;
                maxElementIndex = i;
            }

            if (arr[i] < minElement) {
                minElement = arr[i];
                minElementIndex = i;
            }
        }

        System.out.println(String.format(("min element index: %d max element index: %d"), minElementIndex, maxElementIndex));
        return maxDiff;
    }
}
