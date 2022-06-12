package CSVAssignments;
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class ColdestDay {
    public static void main (String [] args){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // CSVRecord coldest = coldestHourInFile(parser);
        // System.out.println("The coldest temperature is " + coldest.get("TemperatureF") + "F");

        // System.out.println(fileWithColdestTemperature());

        // System.out.println(lowestHumidityInFile(parser).get("DateUTC"));

        // CSVRecord lowestHumid = lowestHumidityInManyFiles();
        // System.out.println("Lowest humidity was " + lowestHumid.get("Humidity") + " at " + lowestHumid.get("DateUTC"));

        // System.out.println("Average temperature in file is " + averageTemperatureInFile(parser));

        // System.out.println("Average temperature in file with humidity restraint is " + averageTemperatureWithHighHumidityInFile(parser, 80));
    }

    public static CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldest = null;
        for (CSVRecord record : parser){
            if (coldest == null){
                coldest = record;
            }
            double coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
            double temp = Double.parseDouble(record.get("TemperatureF"));
            if (temp < coldestTemp){
                coldest = record;
            }
        }
        return coldest;
    }

    public static String fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldest = null;
        String coldestDay = "";
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if (coldest == null){
                coldest = current;
            }
            double coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
            double temp = Double.parseDouble(current.get("TemperatureF"));
            if (temp < coldestTemp && temp != -9999){
                coldest = current;
                coldestDay = f.getName();
            }
        }
        return "Coldest day was in file " + coldestDay + "\nColdest temperature on that day was " + coldest.get("TemperatureF");
    }

    public static CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowest = null;
        for (CSVRecord record : parser){
            if (lowest == null){
                lowest = record;
            }
            double lowestHumid = Double.parseDouble(lowest.get("Humidity"));
            if (!record.get("Humidity").equals("N/A")){
                double currHumid = Double.parseDouble(record.get("Humidity"));
                if (currHumid < lowestHumid){
                    lowest = record;
                }
            }
        }
        return lowest;
    }

    public static CSVRecord lowestHumidityInManyFiles(){
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowest = null;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            if (lowest == null){
                lowest = current;
            }
            double lowestHumid = Double.parseDouble(lowest.get("Humidity"));
            if (!current.get("Humidity").equals("N/A")){
                double currHumid = Double.parseDouble(current.get("Humidity"));
                if (currHumid < lowestHumid){
                    lowest = current;
                }
            }
            
        }
        return lowest;
    }

    public static double averageTemperatureInFile (CSVParser parser){
        double total = 0;
        int count = 0;
        for (CSVRecord record : parser){
            count++;
            total += Double.parseDouble(record.get("TemperatureF"));
        }
        return total/count;
    }

    public static double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value){
        double total = 0;
        int count = 0;
        for (CSVRecord record : parser){
            if (Double.parseDouble(record.get("Humidity"))>= value){
                count++;
                total += Double.parseDouble(record.get("TemperatureF"));
            }
        }
        return total/count;
    }
}
