package com.wearewaes.asml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilsTest {

    @Test
    @DisplayName("Generate a sequential matrix with numbers starting at 1")
    void testGenerateSequentialMatrixFrom1() {
        int size = 2;
        int[][] m = new MatrixUtils().generateSequentialMatrix(size);
        int[][] x = {{1,2},{3,4}};
        assertAll(
                () -> assertEquals(2, m.length),
                () -> assertEquals(1, m[0][0]),
                () -> assertEquals(4, m[1][1]),
                () -> assertArrayEquals(x[0], m[0]),
                () -> assertArrayEquals(x[1], m[1])
        );
    }

    @Test
    @DisplayName("Generate a sequential matrix with numbers starting at a given number")
    void testGenerateSequentialMatrix() {
        int size = 2;
        int offset = 5;
        int[][] m = new MatrixUtils().generateSequentialMatrix(size, offset);
        int[][] x = {{5,6},{7,8}};
        assertAll(
                () -> assertEquals(2, m.length),
                () -> assertEquals(5, m[0][0]),
                () -> assertEquals(8, m[1][1]),
                () -> assertArrayEquals(x[0], m[0]),
                () -> assertArrayEquals(x[1], m[1])
        );
    }

    @Test
    @DisplayName("Generate a square matrix of size 2 with random numbers. The ceiling for random is 100")
    void testGenerateRandomMatrix() {
        int size = 2;
        int [][] m = new MatrixUtils().generateRandomMatrix(size);
        assertAll(
                () -> assertEquals(2, m.length),
                () -> assertTrue(Arrays.stream(m[0]).noneMatch(n -> n > 100)),
                () -> assertTrue(Arrays.stream(m[1]).noneMatch(n -> n > 100))
        );
    }

    @Test
    @DisplayName("Generates a string in a predictable human-readable format of a square matrix of int")
    void testMatrixAsString() {
        int[][] x = {{5,6},{7,8}};
        assertLinesMatch(Arrays.asList("[5, 6],\n[7, 8],\n"), Arrays.asList(new MatrixUtils().matrixAsString(x)));
    }
}