package TriangleSquareTests;

import TriangleSquare.Point;
import TriangleSquare.Triangle;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void getSquare() {
        Point a = new Point(0 ,0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        Triangle line = new Triangle(a, b, b);
        Triangle dot = new Triangle(a, a, a);
        assertEquals(6, (int) triangle.getSquare());
        assertEquals(0 ,(int) dot.getSquare());
        assertEquals(0, (int) line.getSquare());
    }

    @Test
    public void isIsosceles() {
        Point a = new Point(0 ,0);
        Point b = new Point(3, 0);
        Point c = new Point(0, 4);
        Point b2 = new Point(0, 3);
        Triangle notIsoscelesTriangle = new Triangle(a, b, c);
        Triangle isIsoscelesTriangle = new Triangle(a, b, b2);
        Triangle line = new Triangle(a, b, b);
        Triangle dot = new Triangle(a, a, a);
        assertFalse(notIsoscelesTriangle.isIsosceles());
        assertTrue(isIsoscelesTriangle.isIsosceles());
        assertTrue(line.isIsosceles());
        assertTrue(dot.isIsosceles());
    }

    @Test
    public void getLength() {
        Point a = new Point(0 ,0);
        Point b = new Point(3, 0);
        Point c = new Point(-3, 0);
        assertEquals(Triangle.getLength(a, b), 3, 0.1);
        assertEquals(Triangle.getLength(a, a), 0, 0.1);
        assertEquals(Triangle.getLength(c, b), 6, 0.1);
    }
}