package com.wearewaes.asml;

/**
 * Represents a coordinate in a matrix in a convenient, easy way.
 */
public class Coordinate {

    /**
     * Default value set to -1, since 0 is an actual valid value for a coordinate in a matrix.
     */
    private int i = -1;

    /**
     * Default value set to -1, since 0 is an actual valid value for a coordinate in a matrix.
     */
    private int j = -1;

    public Coordinate() {

    }
    public Coordinate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Coordinate) {
            return ((Coordinate) other).getI() == getI() && ((Coordinate) other).getJ() == getJ();
        }

        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder("[").append(i).append(", ").append(j).append("]").toString();
    }
}
