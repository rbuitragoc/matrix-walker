package com.wearewaes.asml;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private int[][] matrix;

    private int size;

    private final List<Coordinate> visited = new ArrayList<>();

    public static void main(String[] args) {
        MatrixUtils m = new MatrixUtils();

        // Besides from sequentially generated numbers (to match the example given)
        // you can also generate a matrix full of pseudo-random numbers by calling
        // MatrixUtils.generateRandomMatrix(int size)
        int[][] matrix = m.generateSequentialMatrix(4);

        // Taking a good look at the matrix before launching...
        System.out.println(m.matrixAsString(matrix));

        // a little setup needed...
        Main main = new Main();
        main.setMatrix(matrix);

        // ... and just walk the matrix!
        main.walk();
    }

    void setMatrix(int[][] matrix) {
        this.matrix = matrix;

        // a hard assumption of this implementation is that matrices are always squared
        this.size = matrix.length;
    }

    /**
     * Adds to visited List the place we're in
     *
     * @param place a Coordinate representation of the current place
     */
    void visit(Coordinate place) {
        this.visited.add(place);
    }

    /**
     * Asserts whether a Coordinate has been visited yet
     *
     * @param next the Coordinate of next possible step
     * @return whether the position represented by the Coordinate passed as an argument has been visited before, meaning it has been stored in the visited List.
     */
    boolean isVisited(Coordinate next) {
        //TODO unit tests for isVisited!
        return visited.stream().anyMatch(c -> c.equals(next));
    }

    /**
     * Asserts, based on where you are, the visited steps and the matrix size, whether a change in direction is needed.
     *
     * @param current a current Step that is evaluated against size and #visited list
     * @return true if either the current step represents an edge in the matrix or if the adjacent next coordinate has been visited; false otherwise.
     */
    boolean mustTurn(Step current) {
        //TODO unit tests for mustTurn!

        // if we hit an edge we must turn
        if (current.hitsEdge(size)) {
            return true;
        }

        // peek next
        return isVisited(current.peek());
    }

    /**
     * Asserts whether the next walking step is impossible.
     *
     * @param current the current Step with a given Direction
     * @return true if the next Step implies a turn, then the turn is given and the next Coordinate has been visited; false otherwise.
     */
    boolean mustExit(Step current) {
        //TODO unit tests for mustExit!
        return mustTurn(current) && current.turn() && isVisited(current.peek());
    }

    void walk() {
        // begin at 0,0:
        Step current = new Step(new Coordinate(0, 0));
        // won't call Step.turn() as it's been called by mustExit()
        while (!mustExit(current)) {
            visit(current.getCoordinate());
            // must set Step.coordinate to next possible place
            current.withCoordinate(current.peek());
        }
        // since we had to exit, just visit remaining place
        visit(current.getCoordinate());
        // and print!
        visited.forEach(c -> System.out.println(matrix[c.getI()][c.getJ()]));
    }


}