package les1;

import java.util.Random;

public class ArrayGenerator {
    private int[] array1;
    private int[] array2;
    private int size;

    public ArrayGenerator() {
    }

    /**
     * @param size is an integer that is given to generate two new random integer arrays with this length.
     */
    public void generateArraysOfSize(int size){
        this.size = size;
        Random rd = new Random();
        array1 = new int[size];
        array2 = new int[size];

        for(int i = 0; i < size; i++){
            array1[i] = rd.nextInt(size);
            array2[i] = rd.nextInt(size);
        }
    }

    public int[] getArray1() {
        return array1.clone();
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public int[] getArray2() {
        return array2.clone();
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
