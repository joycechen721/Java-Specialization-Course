package course_2.BabyMiniProject;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import edu.duke.*;

import java.io.File;

public class BabyBirths {
    public static void main (String [] args){
        //totalBirths method check
        FileResource fr = new FileResource("input_files_2/us_babynames_by_year/yob1900.csv");
        totalBirths(fr);
        //getRank method check
        System.out.println(getRank(1971, "Frank", "M"));
        //getName method check
        System.out.println(getName(1982, 450, "M"));
        //whatisnameinyear method check
        whatIsNameInYear("Owen", 1974, 2014, "M");
        //year of highest rank check
        System.out.println(yearOfHighestRank("Mich", "M"));
        //average rank check
        System.out.println(getAverageRank("Robert", "M"));
        //total births ranked higher check
        System.out.println(getTotalBirthsRankedHigher(1990, "Emily", "F"));
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
                totalGirls ++;
            }
            else{
                totalBoys ++;
            }
        }
        System.out.println("total births: " + totalBirths);
        System.out.println("total girl births: " + totalGirls);
        System.out.println("total boy births: " + totalBoys);
    }

    public static int getRank (int year, String name, String gender){
        String fileName = "input_files_2/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        int rank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)) {
                rank++;
                if (rec.get(0).equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public static String getName(int year, int rank, String gender){
        String fileName = "input_files_2/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        int currRank = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)) {
                currRank++;
                if (currRank == rank) return rec.get(0);
            }
        }
        return "NO NAME";
    }

    public static void whatIsNameInYear(String name, int year, int newYear, String gender){
        int currRank = getRank(year, name, gender);
        String newName = getName(newYear, currRank, gender);
        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
    }

    public static int yearOfHighestRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int maxRank = Integer.MAX_VALUE;
        int maxYear = -1;
        for (File f : dr.selectedFiles()){
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.substring(fileName.length() - 8, fileName.length() - 4));
            int currRank = getRank (year, name, gender);
            if (currRank != -1 && currRank < maxRank) {
                maxRank = currRank;
                maxYear = year;
            }
        }
        return maxYear;
    }

    public static double getAverageRank(String name, String gender){
        DirectoryResource dr = new DirectoryResource();
        int rankSum = 0;
        int numYears = 0;
        for (File f : dr.selectedFiles()) {
            numYears++;
            String fileName = f.getName();
            int year = Integer.parseInt(fileName.substring(fileName.length() - 8, fileName.length() - 4));
            rankSum += getRank(year, name, gender);
        }
        return (double) rankSum / numYears;
    }

    public static int getTotalBirthsRankedHigher(int year, String name, String gender){
        int sumBirths = 0;
        int currRank = getRank(year, name, gender);
        for (int i = 1; i < currRank; i++){
            sumBirths += getBirths(year, getName(year, i, gender), gender);
        }
        return sumBirths;
    }

    public static int getBirths(int year, String name, String gender){
        String fileName = "input_files_2/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(fileName);
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(0).equals(name) && rec.get(1).equals(gender)) {
                return Integer.parseInt(rec.get(2));
            }
        }
        return -1;
    }
}
