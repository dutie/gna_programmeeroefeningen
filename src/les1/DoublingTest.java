package les1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoublingTest {

    List<Integer> doubles  = new ArrayList<>();
    List<Integer> compares = new ArrayList<>();
    List<Integer> sizes    = new ArrayList<>();
    List<Double> times    = new ArrayList<>();

    public double timeTrial(int n) {
        sizes.add(n);
        ArrayGenerator ag = new ArrayGenerator();
        ag.generateArraysOfSize(n);
        StopWatch timer = new StopWatch();
        ArrayChecker ac = new ArrayChecker(ag.getArray1(), ag.getArray2());
        double time_  = 0;
        int double_   = 0;
        int compares_ = 0;
        double time = 0;
        for(int i = 0; i < 100; i++) {
            ag.generateArraysOfSize(n);
            double_ += ac.countDoubles();
            compares_ += ac.getAmount_of_compares();
            time = timer.elapsedTime();
            time_ += time;
        }
        doubles.add(double_/100);
        compares.add(compares_/100);
        times.add(time_/100);

        return time_/100;
    }

    public void main(){

        for(int n = 250; true; n *=2){
            if(n > 32000) break;
            double time = timeTrial(n);
            System.out.print(""+n+"\t"+time+"\n");
        }
        WriteToFile writer = new WriteToFile();
        writer.writeToFileWithTime(compares, doubles, sizes, times);
    }
}