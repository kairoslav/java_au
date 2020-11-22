package TriangleSquare;

import java.awt.*;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public double getSquare() {
        double semiPerimeter = 0.5 * (getLength(a, b) + getLength(b, c) + getLength(c, a));
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - getLength(a, b)) *
                (semiPerimeter - getLength(b, c)) *
                (semiPerimeter - getLength(a, c)));
    }


    public boolean isIsosceles() {
        return getLength(a, b) == getLength(b, c) ||
                getLength(b, c) == getLength(c, a) ||
                getLength(a, c) == getLength(a, b);
    }

    public static double getLength(Point a, Point b) {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    @Override
    public String toString() {
        return a.toString() + " " + b.toString() + " " + c.toString();
    }
}
