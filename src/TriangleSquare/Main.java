package TriangleSquare;

import TriangleSquare.ReadWriteUtils;
import TriangleSquare.Triangle;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static int stringToInt(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        try {
            List<String> file = ReadWriteUtils.read(args[0]);
            Triangle maxTriangle = new Triangle(new Point(0, 0), new Point(0, 0), new Point(0, 0));
            for (String line : file) {
                if (line.matches("-?[0-9]+ -?[0-9]+ -?[0-9]+ -?[0-9]+ -?[0-9]+ -?[0-9]")) {
                    List<String> points = Arrays.asList(line.split(" "));
                    Point a = new Point(stringToInt(points.get(0)), stringToInt(points.get(1)));
                    Point b = new Point(stringToInt(points.get(2)), stringToInt(points.get(3)));
                    Point c = new Point(stringToInt(points.get(4)), stringToInt(points.get(5)));
                    Triangle triangle = new Triangle(a, b, c);
                    if (triangle.isIsosceles()) {
                        if (triangle.getSquare() > maxTriangle.getSquare()) {
                            maxTriangle = triangle;
                        }
                    }
                }
            }
            ReadWriteUtils.write(args[1], maxTriangle.toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(String.format("Invalid number of parameters\n%d of 2 arguments recieved", args.length));
        }
    }
}
