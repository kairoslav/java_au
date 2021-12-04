package leetcode.MDGenerator;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(final String[] args) throws Throwable {
        try {
            LeetCodeSourceData File = new LeetCodeSourceData(args[0]);
            List<Integer> a = new LinkedList<>();
            File.writeToMDFile(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Invalid number of parameters\n%d of 2 arguments recieved%n", args.length);
        }
    }
}
