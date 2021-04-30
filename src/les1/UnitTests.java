package les1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class UnitTests {

    // ArrayChecker Tests
    @Test(expected = IllegalArgumentException.class)
    public void test_array_length(){
        int[] a1 = new int[2];
        int[] a2 = new int[4];

        ArrayChecker ac = new ArrayChecker(a1, a2);
    }

    @Test
    public void test_array_counter(){
        int[] a1 = new int[2];
        int[] a2 = new int[2];

        a1[0] = 1;
        a1[1] = 2;

        a2[0] = 2;
        a2[1] = 3;

        ArrayChecker ac = new ArrayChecker(a1, a2);

        int doublesCount = ac.countDoubles();
        Assert.assertEquals(1, doublesCount);
    }

    // ArrayGenerator Tests
    @Test
    public void test_array_generator(){
        ArrayGenerator ag = new ArrayGenerator();
        ag.generateArraysOfSize(10);

        Assert.assertEquals(10, ag.getArray1().length);
        Assert.assertEquals(10, ag.getArray2().length);
    }


    // Testing it all
    @Test
    public void test_array_doubler_and_generator(){
        int i = 0;
        ArrayGenerator ag = new ArrayGenerator();
        int[] doubles = new int[100];
        while(i < 100){
            ag.generateArraysOfSize(i+1);
            ArrayChecker ac = new ArrayChecker(ag.getArray1(), ag.getArray2());
            doubles[i] = ac.countDoubles();
            System.out.println("Amount of compares: " + ac.getAmount_of_compares());
            i++;
        }
        System.out.println(Arrays.toString(doubles));
    }

    @Test
    public void test_write_data_to_csv(){
        int i = 0;
        ArrayGenerator ag = new ArrayGenerator();
        int[] doubles  = new int[100];
        int[] compares = new int[100];
        int[] sizes    = new int[100];
        while(i < 100){
            ag.generateArraysOfSize(i+1);
            ArrayChecker ac = new ArrayChecker(ag.getArray1(), ag.getArray2());
            doubles[i]      = ac.countDoubles();
            compares[i]     = ac.getAmount_of_compares();
            sizes[i]        = i+1;
            i++;
        }

        WriteToFile writer = new WriteToFile();
        writer.writeToFile(compares, doubles, sizes);
    }

    @Test
    public void test_doubling_test(){
        DoublingTest doublingTest = new DoublingTest();
        doublingTest.main();
    }
}
