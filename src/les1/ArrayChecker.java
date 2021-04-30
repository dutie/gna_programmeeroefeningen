package les1;

public class ArrayChecker {
    /**
     *
     * @invar array1 != null && array1.length == array2.length
     * @invar array2 != null && array2.length == array1.length
     *
     */
    private int[] array1;
    private int[] array2;
    private int amount_of_compares = 0;


    /**
     * @param a1 is an array of integers that has the same length as @param{a2}
     * @param a2 is an array of integers that has the same length as @param{a1}
     *
     * @throws IllegalArgumentException when arrays do not have the same length.
     *      | if a1.length != a2.length
     */
    public ArrayChecker(int[] a1, int[] a2) {
        if(a1.length != a2.length) throw new IllegalArgumentException("Arrays do not have the same length!");
        array1 = a1;
        array2 = a2;
    }

    public int countDoubles(){
        int cnt = 0;

        for(int i : array1){
            for(int j : array2){
                amount_of_compares++;
                if(i == j) cnt++;
            }
        }

        return cnt;
    }

    public int getAmount_of_compares() {
        return amount_of_compares;
    }

    public void setAmount_of_compares(int amount_of_compares) {
        this.amount_of_compares = amount_of_compares;
    }

    public int[] getArray1() {
        return array1;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public int[] getArray2() {
        return array2;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }
}
