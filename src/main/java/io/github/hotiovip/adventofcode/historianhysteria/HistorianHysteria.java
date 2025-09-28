package io.github.hotiovip.adventofcode.historianhysteria;

import io.github.hotiovip.adventofcode.Helper;

import java.util.ArrayList;
import java.util.Arrays;

public class HistorianHysteria {

    int[] leftList;
    int[] rightList;

    public HistorianHysteria() {
        String fileData = Helper.readFile("locations.txt");
        if (fileData == null) return;

        ArrayList<int[]> splitFileData = splitFileData(fileData);
        leftList = splitFileData.getFirst();
        rightList = splitFileData.getLast();
        Arrays.sort(leftList);
        Arrays.sort(rightList);

        System.out.println("Day 1: Historian Hysteria");
        calculateDistanceBetweenLists();
        calculateSimilarityScore();
    }

    // Part 1
    private void calculateDistanceBetweenLists() {
        int[] distances = new int[leftList.length];
        for (int i = 0; i < leftList.length; i++) {
            distances[i] = Math.abs(leftList[i] - rightList[i]);
        }

        int distanceBetweenLists = 0;
        for (int distance : distances) {
            distanceBetweenLists += distance;
        }
        System.out.printf("- Part 1: %d".indent(1), distanceBetweenLists);
    }
    // Part 2
    private void calculateSimilarityScore() {
        int similarityScore = 0;

        for (int leftNumber : leftList) {
            int foundInRightList = 0;

            for (int rightNumber : rightList) {
                if (leftNumber == rightNumber) foundInRightList++;
            }

            similarityScore += foundInRightList * leftNumber;
        }

        System.out.printf("- Part 2: %d".indent(1), similarityScore);
    }

    private ArrayList<int[]> splitFileData(String fileData) {
        String[] splittedNumber = fileData.split("\\s+");

        // halbe Länge, weil links und rechts jeweils die Hälfte bekommen
        int[] leftList = new int[splittedNumber.length / 2];
        int[] rightList = new int[splittedNumber.length / 2];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < splittedNumber.length; i++) {
            if (i % 2 == 0) { // even index -> left
                leftList[leftIndex++] = Integer.parseInt(splittedNumber[i]);
            } else {          // odd index -> right
                rightList[rightIndex++] = Integer.parseInt(splittedNumber[i]);
            }
        }

        return new ArrayList<>(Arrays.asList(leftList, rightList));
    }
}