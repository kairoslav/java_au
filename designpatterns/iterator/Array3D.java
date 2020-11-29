package iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Array3D<T> implements Iterable<T> {
    private final T[][][] array;
    private int indexX = 0;
    private int indexY = 0;
    private  int indexZ = 0;

    public Array3D(T[][][] array) {
        this.array = array;
    }


    @Override
    public Iterator<T> iterator() {
        int sizeX = array.length;
        int sizeY = array[0].length;
        int sizeZ = array[0][0].length;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return indexZ != sizeZ;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                if (indexX != sizeX - 1) {
                    return array[indexX++][indexY][indexZ];
                }
                else {
                    if (indexY != sizeY - 1) {
                        indexX = 0;
                        return array[indexX][indexY++][indexZ];
                    }
                    else {
                        //тут происходит баг с array3, сейчас 2:08 и я пока не знаю как его исправить
                        indexX = 0;
                        indexY = 0; //конкретно вот тут
                        return array[indexX][indexY][indexZ++];
                    }
                }
            }
        };
    }

    public static void main(String[] args) {
        Array3D<Integer> array = new Array3D<>(new Integer[][][]{{{1, 2}, {1, 2}}, {{1, 2}, {1, 2}}});
        Array3D<Integer> array2 = new Array3D<>(new Integer[][][]{{{1}}});
        Array3D<Integer> array3 = new Array3D<>(new Integer[][][]{{{1}, {2}}});



        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
        for (int i: array2) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println(array3.array.length);
        System.out.println(array3.array[0].length);
        System.out.println(array3.array[0][0].length);
        System.out.println();
        for (int i: array3) {
            System.out.println(i);
        }
    }
}
