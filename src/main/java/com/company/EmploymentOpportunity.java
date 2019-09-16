package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//Find little exceptions
//http://codeforces.com/problemset/problem/1214/F
public class EmploymentOpportunity {

    private long countOfCities;
    private int countOfWorkPlaces;
    private long[] citiesWithWorkPlaces;
    private long[][] citiesOfCandidates;

    public EmploymentOpportunity(Scanner scanner) {
        countOfCities = scanner.nextInt();
        countOfWorkPlaces = scanner.nextInt();
        citiesWithWorkPlaces = new long[countOfWorkPlaces];
        citiesOfCandidates = new long[countOfWorkPlaces][2];
        for (int i = 0; i < citiesWithWorkPlaces.length; i++) {
            citiesWithWorkPlaces[i] = scanner.nextInt();
        }
        for (int i = 0; i < citiesOfCandidates.length; i++) {
            citiesOfCandidates[i][0] = scanner.nextInt();
            citiesOfCandidates[i][1] = i + 1;
        }
    }

    public static void main(String[] args) {
        EmploymentOpportunity opportunity = new EmploymentOpportunity(new Scanner(System.in));
        opportunity.getPlacesForPeople();

    }

    public long getPlacesForPeople() {
        sortCities();
        int countOfShifts = findMinValueOfOneAndLastCity();
        shift(countOfShifts);
        long result = getResult();
        printResults(result);
        return result;
    }

    public void sortCities() {
        Arrays.sort(citiesWithWorkPlaces);//O(nlogn)
        Arrays.sort(citiesOfCandidates, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return Long.compare(o1[0], o2[0]);
            }
        });//O(nlogn)
    }

    public void shift(int m) {
        for (int i = 0; i < m; i++) {
            rightShift();
        }
    }

    public void rightShift() {
        long helper1 = citiesOfCandidates[citiesOfCandidates.length - 1][0];
        long helper2 = citiesOfCandidates[citiesOfCandidates.length - 1][1];
        for (int i = citiesOfCandidates.length - 1; i > 0; i--) {
            citiesOfCandidates[i][0] = citiesOfCandidates[i - 1][0];
            citiesOfCandidates[i][1] = citiesOfCandidates[i - 1][1];
        }
        citiesOfCandidates[0][0] = helper1;
        citiesOfCandidates[0][1] = helper2;
    }

    public long getResult() {
        long result = 0;
        for (int i = 0; i < citiesWithWorkPlaces.length; i++) {//O(n)
            if ((citiesWithWorkPlaces[i] == 1 && citiesOfCandidates[i][0] == countOfCities)
                    || ((citiesWithWorkPlaces[i] == countOfCities && citiesOfCandidates[i][0] == 1))) {
                result += 1;
            } else {
                result += (Math.abs(citiesWithWorkPlaces[i] - citiesOfCandidates[i][0]));
            }
        }
        return result;
    }

    public void printResults(long result) {
        System.out.println(result);
        for (int i = 0; i < citiesOfCandidates.length; i++) {
            System.out.print(citiesOfCandidates[i][1] + " ");
        }
    }

    public int findMinValueOfOneAndLastCity() {
        int countOfcitiesWithZero = 0;
        int countOfWorkPlacesWithTen = 0;

        for (int i = 0; i < citiesWithWorkPlaces.length; i++) {
            if (citiesWithWorkPlaces[i] == 1) {
                countOfcitiesWithZero++;
            } else {
                break;
            }
        }

        for (int i = citiesOfCandidates.length - 1; i >= 0; i--) {
            if (citiesOfCandidates[i][0] == countOfCities) {//here no 10!!!
                countOfWorkPlacesWithTen++;
            } else {
                break;
            }
        }

        int m = Math.min(countOfcitiesWithZero, countOfWorkPlacesWithTen);
        return m;
    }

}
