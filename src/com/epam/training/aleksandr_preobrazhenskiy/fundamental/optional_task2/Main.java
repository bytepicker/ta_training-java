package com.epam.training.aleksandr_preobrazhenskiy.fundamental.optional_task2;

import java.util.Scanner;
import  java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Dimension: ");

        int n = input.nextInt();
        final int M = 1000;
        Random rand = new Random();

        int[][] matrix = new int[n][n];

        // create matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = ((rand.nextInt(M+M)+1)-M);
            }
        }

        // display matrix
        for(int i=0; i< matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // find MAX element and delete its row and col
        int max = 0, row = 0, col = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println("Max element: " + max + " index: " + row + ":" + col);

        // populate new matrix
        int[][] chopped = new int[n-1][n-1];
        int p = 0;
        for(int i = 0; i < n; i++) {
            if(i == row)
                continue;
            int q = 0;
            for (int j = 0; j < n; j++) {
                if(j == col)
                    continue;
                chopped[p][q] = matrix[i][j];
                ++q;
            }
            ++p;
        }

        // print our new matrix
        for (int[] ints : chopped) {
            for (int j = 0; j < chopped[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
