package les1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    File myFile;
    final String name = "DataWrangler/les1data.csv";

    public WriteToFile() {
        this.myFile = new File(name);
    }

    public void writeToFileWithTime(List amount_of_compares, List amount_of_doubles, List sizes, List times ){
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.append("Array size:,");
            fileWriter.append("Running time:,");
            fileWriter.append("Amount of compares:,");
            fileWriter.append("Amount of doubles:\n");
            for(int i = 0; i<sizes.size(); i++){
                fileWriter.append(String.valueOf(sizes.get(i))).append(",");
                fileWriter.append(String.valueOf(times.get(i))).append(",");
                fileWriter.append(String.valueOf(amount_of_compares.get(i))).append(",");
                fileWriter.append(String.valueOf(amount_of_doubles.get(i))).append("\n");
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    public void writeToFile(int[] amount_of_compares, int[] amount_of_doubles, int[] sizes){
        try {
            FileWriter fileWriter = new FileWriter(name);
            fileWriter.append("Array size:,");
            fileWriter.append("Amount of compares:,");
            fileWriter.append("Amount of doubles:\n");
            for(int i = 0; i<sizes.length; i++){
                fileWriter.append(String.valueOf(sizes[i])).append(",");
                fileWriter.append(String.valueOf(amount_of_compares[i])).append(",");
                fileWriter.append(String.valueOf(amount_of_doubles[i])).append("\n");
            }

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
