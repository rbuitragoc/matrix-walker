package com.wearewaes.asml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    @DisplayName("returns value of i component of coordinate correctly")
    void testGetI() {
        Coordinate c = new Coordinate(1,2);
        Coordinate e = new Coordinate();
        assertAll(
                () -> assertEquals(1, c.getI()),
                () -> assertEquals(-1, e.getI())
        );
    }

    @Test
    @DisplayName("returns value of j component of coordinate correctly")
    void testGetJ() {
        Coordinate c = new Coordinate(1,2);
        Coordinate e = new Coordinate();
        assertAll(
                () -> assertEquals(2, c.getJ()),
                () -> assertEquals(-1, e.getJ())
        );
    }

    @Test
    @DisplayName("prints coordinate values in a human-readable format")
    void testToString() {
        Coordinate c = new Coordinate(6,7);
        Coordinate e = new Coordinate();
        assertEquals("[6, 7]", c.toString());
        assertEquals("[-1, -1]", e.toString());
    }

    @Test
    @DisplayName("correctly establishes whether two Coordinate objects hold the same coordinate data")
    void testEquals() {
        Coordinate a = new Coordinate(1, 0);
        Coordinate b = new Coordinate(0, 1);
        assertAll(
                () -> assertTrue(new Coordinate(1, 0).equals(a)),
                () -> assertFalse(new Coordinate(1, 0).equals(b)),
                () -> assertFalse(a.equals(b))
        );
    }

}