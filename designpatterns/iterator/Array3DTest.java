package iterator;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class Array3DTest {

    Array3D<Integer> array1 = new Array3D<>(new Integer[][][]{{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}});
    Array3D<Integer> array2 = new Array3D<>(new Integer[][][]{{{1}}});
    Array3D<Integer> array3 = new Array3D<>(new Integer[][][]{{{1}, {2}}});

    @Test
    public void iterator() {

        Object[] array1_expected = {1,2,3,4,5,6,7,8};
        List<Integer> a = new LinkedList<>();
        for (int i :array1) {
            a.add(i);
        }
        assertArrayEquals(a.toArray() , array1_expected);

        Object[] array2_expected = {1};
        a.clear();
        for (int i :array2) {
            a.add(i);
        }
        assertArrayEquals(a.toArray(), array2_expected);

        Object[] array3_expected = {1,2};
        a.clear();
        for (int i :array3) {
            a.add(i);
        }
        assertArrayEquals(a.toArray(), array3_expected);
    }
}