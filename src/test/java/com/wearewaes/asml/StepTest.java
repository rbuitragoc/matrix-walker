package com.wearewaes.asml;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    private Step underTest;

    @BeforeEach
    void setUp() {
        underTest = new Step();
    }

    @AfterEach
    void tearDown() {
        underTest = null;
    }

    @Test
    void getCoordinate() {
    }

    @Test
    void getDirection() {
    }

    @Test
    @DisplayName("provides a tentative Coordinate based on current place and direction")
    void peek() {
        Coordinate c1 = new Coordinate(0,3),
                c2 = new Coordinate(0,2),
                c3 = new Coordinate(2,3),
                c4 = new Coordinate(1, 3),
                c5 = new Coordinate(3, 5),
                c6 = new Coordinate(4, 5),
                c7 = new Coordinate(9, 3),
                c8 = new Coordinate(9, 4);
        assertAll(
                () -> assertEquals(c1, underTest.withCoordinate(c2).peek()),
                () -> assertEquals(c3, underTest.withDirection(Direction.DOWN).withCoordinate(c4).peek()),
                () -> assertEquals(c5, underTest.withDirection(Direction.UP).withCoordinate(c6).peek()),
                () -> assertEquals(c7, underTest.withDirection(Direction.LEFT).withCoordinate(c8).peek())
        );
    }

    @Test
    @DisplayName("asserts whether an edge has been hit")
    void testHitsEdge() {
        final int size = 4;
        Coordinate r1 = new Coordinate(0,2),
                r2 = new Coordinate(0,3),
                d1 = new Coordinate(2,3),
                d2 = new Coordinate(3, 2),
                l1 = new Coordinate(0, 1),
                l2 = new Coordinate(1, 0),
                u1 = new Coordinate(1, 3),
                u2 = new Coordinate(0, 4);

        Step s = new Step();
        assertAll(
                () -> assertFalse(s.withDirection(Direction.RIGHT).withCoordinate(r1).hitsEdge(size)),
                () -> assertTrue(s.withDirection(Direction.RIGHT).withCoordinate(r2).hitsEdge(size)),
                () -> assertFalse(s.withDirection(Direction.DOWN).withCoordinate(d1).hitsEdge(size)),
                () -> assertTrue(s.withDirection(Direction.DOWN).withCoordinate(d2).hitsEdge(size)),
                () -> assertFalse(s.withDirection(Direction.LEFT).withCoordinate(l1).hitsEdge(size)),
                () -> assertTrue(s.withDirection(Direction.LEFT).withCoordinate(l2).hitsEdge(size)),
                () -> assertFalse(s.withDirection(Direction.UP).withCoordinate(u1).hitsEdge(size)),
                () -> assertTrue(s.withDirection(Direction.UP).withCoordinate(u2).hitsEdge(size))
        );
    }

    @Test
    void testToString() {
    }
}