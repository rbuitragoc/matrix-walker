package com.wearewaes.asml;

/**
 * Represents a coordinate and a direction to "walk" the matrix
 */
public class Step {
    // TODO unit tests for Step!
    /**
     * Conveniently defaulted to up-leftmost coordinate in a matrix (using a referential visualization)
     */
    private Coordinate coordinate = new Coordinate(0,0);

    /**
     * Conveniently defaulted to RIGHT as being the L-R reading scheme used in the example given
     */
    private Direction direction = Direction.RIGHT;

    public Step() {

    }

    public Step(Coordinate c) {
        this.coordinate = c;
    }

    public Step(Coordinate c, Direction d) {
        this.coordinate = c;
        this.direction = d;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    /**
     * Fluid interface setter for Coordinate
     * @param c a Coordinate to set
     * @return same Step object with a Coordinate set
     */
    public Step withCoordinate(Coordinate c) {
        this.coordinate = c;
        return this;
    }

    /**
     * Fluid interface setter for Direction
     * @param d a Direction to set
     * @return same Step object with a Direction set
     */
    public Step withDirection(Direction d) {
        this.direction = d;
        return this;
    }

    /**
     * Asserts whether Step has hit an edge depending on the current Direction
     * @param size the size of the squared matrix to consider
     * @return true if an edge is hit on any place depending on the Direction; false otherwise
     */
    public boolean hitsEdge(int size) {
        switch(getDirection()) {
            case DOWN: return getCoordinate().getI() == size - 1;
            case LEFT: return getCoordinate().getJ() == 0;
            case UP: return getCoordinate().getI() == 0;
            default: return getCoordinate().getJ() == size - 1; // honoring our mental model of using RIGHT as the default
        }
    }

    /**
     * Attempts to provide a Coordinate based on current Step (Coordinate and Direction are considered)
     * @return a tentative Coordinate to visit next
     */
    Coordinate peek() {
        Coordinate c = getCoordinate();
        int i = c.getI(), j = c.getJ();
        switch(getDirection()) {
            case UP: return new Coordinate(--i, j);
            case DOWN: return new Coordinate(++i, j);
            case LEFT: return new Coordinate(i, --j);
            default: return new Coordinate(i, ++j); // honoring our mental model of using RIGHT as the default
        }
    }

    /**
     * Applies a change in Direction, clockwise.
     * @return true if the change in direction corresponds to a correctly set initial Direction; false otherwise.
     */
    boolean turn() {
        switch(getDirection()) {
            case DOWN: withDirection(Direction.LEFT); return true;
            case UP: withDirection(Direction.RIGHT); return true;
            case LEFT: withDirection(Direction.UP); return true;
            case RIGHT: withDirection(Direction.DOWN); return true;
            default: return false;
        }
    }

    @Override
    public String toString() {
        return new StringBuilder("[").append(this.getCoordinate().toString()).append(" ,").append(this.getDirection()).append("]").toString();
    }
}
