package com.wearewaes.asml;

import java.util.Arrays;
import java.util.Random;

public class MatrixUtils {
    /**
     * It is assumed  the matrix is n x n size, so this creator method takes only one argument.
     * This method creates an n x n matrix with sequential numbers, starting at 1.
     * @param size the size for the squared matrix
     * @return a matrix (bidimensional array) of integers filled in sequential order, starting at 1
     */
    int[][] generateSequentialMatrix(int size) {
        return generateSequentialMatrix(size, 1);
    }

    /**
     * It is assumed  the matrix is n x n size, so this creator method takes only one argument
     * @param size the size for the squared matrix
     * @param offset the starting numeric value to fill the matrix
     * @return a matrix (bidimensional array) of integers filled in sequential order, starting at the value specified by offset
     * */
    int[][] generateSequentialMatrix(int size, int offset) {
        int[][] matrix = new int[size][size];
        int c = offset;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = c++;
            }
        }
        return matrix;
    }
    /**
     * It is assumed  the matrix is n x n size, so this creator method takes only one argument
     * @param size the size for the squared matrix
     * @return a matrix (bidimensional array) of integers filled in sequential order, starting at the value specified by offset
     * */
    int[][] generateRandomMatrix(int size) {
        Random rnd = new Random();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rnd.nextInt(100);
            }
        }
        return matrix;
    }

    /**
     * Returns a human-readable string of the contents of the matrix passed by parameter.
     * @param matrix the int matrix (bidirectional array)
     * @return a String in human-readable format of the contents of the matrix
     */
    String matrixAsString(int[][] matrix) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            buf.append(Arrays.toString(matrix[i])).append(',').append("\n");
        }

        return buf.toString();
    }
}
