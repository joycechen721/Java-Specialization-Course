package StringsThirdAssignments;
import edu.duke.StorageResource;

public class Part3 {
    public static void processGenes(StorageResource sr){
        int charCount = 0;
        int cgCount = 0;
        int maxLength = 0;
        int geneCount = 0;
        for (String s : sr.data()){
            geneCount++;
            if (s.length() > 60){
                System.out.println(s);
                charCount++;
            }
            if (Part2.cgRatio(s) > 0.35){
                System.out.println(s);
                cgCount++;
            }
            maxLength = Math.max(maxLength, s.length());
        }
        System.out.println("Number of genes: " + geneCount);
        System.out.println("Number of strings that are longer than 60 characters: " + charCount);
        System.out.println("Number of strings whose C-G-ratio is higher than 0.35: " + cgCount);
        System.out.println("Length of longest string: " + maxLength);
    }
}
