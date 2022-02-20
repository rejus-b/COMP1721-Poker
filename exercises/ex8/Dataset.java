import java.io.IOException;
// import java.Exception.ArithmeticException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Dataset {

    private List<Double> data = new ArrayList<>();

    public Dataset(String filename) throws IOException {

        try (Scanner input = new Scanner(Paths.get(filename))) {

            while (input.hasNextDouble()){
                double value = input.nextDouble();                
                data.add(value);
            }

            input.close();

        }

    }

    public int size(){

        int count;

        return (data.size());

            // Implementation idea = .toArray then .length on the array

            // Initial implemetatino idea waithout using the size() method as it would be self calling 

        // for (int i = 0; i < data.length(); i++){
        //     try{
        //         data.get(i);
        //         count += i;
        //     } catch (Exception e){
        //         return (count); // Returns the total number of data indexes
        //     }

        // }

    }

    public double meanValue() throws ArithmeticException{

        double total = 0;
        double mean;

        if (data.size() == 0){
            throw new ArithmeticException();
        }

        for (int i = 0; i < data.size(); i++){
            total = total + data.get(i);
        }

        mean = total / data.size();
        return (mean);
    }


}