package io.github.hotiovip.adventofcode.rednosedreports;

import io.github.hotiovip.adventofcode.Helper;

import java.util.Arrays;

public class RedNosedReports {
    public RedNosedReports() {
        System.out.println("Day 2: Red-Nosed Reports");
        CalculateSafeReports();
    }

    private void CalculateSafeReports() {
        String fileData = Helper.readFile("reports.txt");
        if (fileData == null) return;

        String[] fileDataLines = fileData.split("\\r?\\n");
        int safeReports = 0;
        for (int i = 0; i < fileDataLines.length; i++) {
            int[] splittedLines = Helper.parseStringArrayToInt(fileDataLines[i].split("\\s+"));
            for (int j = 0; j < splittedLines.length; j++) {
                int difference = splittedLines[j];
                if (j != 0) difference = Math.abs(splittedLines[j] - splittedLines[j - 1]);
            }
        }
    }
}
