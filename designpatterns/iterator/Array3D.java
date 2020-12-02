package iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Array3D<T> implements Iterable<T> {
    private final T[][][] array;
    private int indexX = 0;
    private int indexY = 0;
    private int indexZ = -1;

    public Array3D(T[][][] array) {
        this.array = array;
    }

    public T[][][] getArray() {
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        int sizeX = array.length;
        int sizeY = array[0].length;
        int sizeZ = array[0][0].length;
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return indexX != sizeX - 1 || indexY != sizeY - 1 || indexZ != sizeZ - 1;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new NoSuchElementException();

                if (indexZ < sizeZ - 1) {
                    return array[indexX][indexY][++indexZ];
                } else if (indexY < sizeY - 1) {
                    indexZ = -1;
                    return array[indexX][++indexY][++indexZ];
                } else if (indexX < sizeX - 1) {
                    indexZ = -1;
                    indexY = -1;
                    return array[++indexX][++indexY][++indexZ];
                } else {
                    return array[sizeX - 1][sizeY - 1][sizeZ - 1];
                }
            }
        };
    }

    public static void main(String[] args) {

    }
}
