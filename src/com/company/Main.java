package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the number of points: ");
        int a = scanner.nextInt();

        if (a <= 1) {
            System.out.println("Two points minimum!");
        } /*else if (a == 2) {
            System.out.println("[1, 2]");
        }*/ else {

            int[][] coordinates = new int[a][2];
//            int[] arrayOfCoordinates = new int[a * 2];

            input(coordinates);

            output(coordinates);
//
//            arrayChange(coordinates, arrayOfCoordinates);
//
//            maxDistance(arrayOfCoordinates);

            double maxDistance = 0;
            double formulaOfDistance;
            int[] furthestPoints = new int[2];

            for (int i = 0; i < coordinates.length - 1; i++) {
                for (int j = i + 1; j < coordinates.length; j++) {
                    formulaOfDistance = sqrt(pow((coordinates[j][0] - coordinates[i][0]) , 2) + pow((coordinates[j][1] - coordinates[i][1]) , 2));
                    if(formulaOfDistance>maxDistance) {
                        maxDistance = formulaOfDistance;
                        furthestPoints[0] = i + 1;
                        furthestPoints[1] = j + 1;
                    }
                }
            }
            System.out.println(Arrays.toString(furthestPoints));

        }
    }

    private static void maxDistance(int[] arrayOfCoordinates) {
        double maxDistance = 0;
        int[] furthestPoints = new int[2];

        for (int i = 0; i < arrayOfCoordinates.length / 2 - 1; i++) {
            int temp = i + 1;
            for (int j = i * 2; j < arrayOfCoordinates.length - 2; j += 2) {
                double formulaOfDistance = sqrt(pow((arrayOfCoordinates[j + 2] - arrayOfCoordinates[i * 2]), 2) + pow((arrayOfCoordinates[j + 3] - arrayOfCoordinates[i * 2 + 1]), 2));
                temp++;
                if (formulaOfDistance > maxDistance) {
                    maxDistance = formulaOfDistance;
                    furthestPoints[0] = i + 1;
                    furthestPoints[1] = temp;

                }
            }
        }

        System.out.print("Max distance between points " + furthestPoints[0] + " and " + furthestPoints[1]);
    }

    private static int[] arrayChange(int[][] coordinates, int[] arrayOfCoordinates) {
        int k = 0;

        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < coordinates[i].length; j++) {
                arrayOfCoordinates[k] = coordinates[i][j];
                k++;
            }
        }

        return arrayOfCoordinates;
    }

    private static void output(int[][] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            System.out.print(i+1 + ") x, y:");
            for (int j = 0; j < 2; j++) {
                System.out.format("%4d", coordinates[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] input(int[][] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            for (int j = 0; j < 2; j++) {
                coordinates[i][j] = (int) (Math.random() * 19 - 10);
            }
        }
        return coordinates;
    }
}