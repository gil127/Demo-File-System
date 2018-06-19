package com.company;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by gild on 6/2/18.
 */
public class Lottery {

    private static final int min = 1;
    private static final int max = 43;
    private static final int CARD_SIZE = 6;
    private int currentIndex = 0;
    int[] arr = new int[CARD_SIZE];

    public void initLottery() {
        Arrays.fill(arr, -1);
    }

    public int getRandomNumber() {
        Random rand = new Random();
        int n = rand.nextInt(max) + min;

        while (numberIsAlreadyAppear(n)) {
           n = rand.nextInt(max) + min;
        }

        return n;
    }

    private boolean numberIsAlreadyAppear(int n) {
        boolean appear = false;
        for (int i = 0; i < currentIndex && !appear; i++) {
            if (arr[i] == n) {
                System.out.println("[ERROR]: number already selected, continue to next number");
                appear = true;
            }
        }

        return appear;
    }

    public void addNumberToYourCard(int n) {
        for (int i = currentIndex; i < CARD_SIZE; i++) {
            if (arr[i] == -1) {
                arr[i] = n;
                currentIndex++;
                break;
            }
        }
    }

    public void run() {
        int n;
        for (int i = 0; i < CARD_SIZE; i++) {
            n = getRandomNumber();
            addNumberToYourCard(n);
        }

        showCard();
    }

    public void showCard() {
        for (int i = 0; i < CARD_SIZE; i++) {
            System.out.println("[" + i + "]:" + arr[i]);
        }
    }
}
