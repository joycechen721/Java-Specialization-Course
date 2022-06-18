package course_2.CSVAssignments;
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public static void tester(){
        FileResource fr = new FileResource("input_files_2/exportdata.csv");
        CSVParser parser = fr. getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));
    }

    public static void main (String [] args){
        tester();
    }

    public static String countryInfo(CSVParser parser, String country){ 
        for (CSVRecord record : parser){
            String localCountry = record.get("Country");
            if (localCountry.equals(country)){
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return localCountry + ": " + exports + " : " + value;
            }
        }
        return "NOT FOUND";
    }

    public static void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }

    public static int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem)){
                count++;
            }
        }
        return count;
    }

    public static void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser){
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()){
                System.out.println(record.get("Country") + " " + value);
            }
        }
    }
}
