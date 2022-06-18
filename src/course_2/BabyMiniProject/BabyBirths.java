package course_2.BabyMiniProject;

import org.apache.commons.csv.CSVRecord;
import edu.duke.*;

public class BabyBirths {
    public static void main (String [] args){
        FileResource fr = new FileResource("input_files_2/us_babynames_by_decade/yob1880s.csv");
        totalBirths(fr);
    }

    //print # of girl names, # of boys names, total names in file
    public static void totalBirths(FileResource fr){
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int births = Integer.parseInt(rec.get(2));
            totalBirths += births;
            if (rec.get(1).equals("F")){
                totalGirls += births;
            }
            else{
                totalBoys += births;
            }
        }
        System.out.println("total births: " + totalBirths);
        System.out.println("total girl births: " + totalGirls);
        System.out.println("total boy births: " + totalBoys);
    }
}
