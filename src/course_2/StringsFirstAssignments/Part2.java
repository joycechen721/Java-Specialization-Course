package course_2.StringsFirstAssignments;

public class Part2 {
    public static String findSimpleGene2 (String gene, String startCodon, String stopCodon){
        String result = "No gene combination found.";
        int startIndex = gene.indexOf(startCodon);
        int endIndex = gene.indexOf(stopCodon, startIndex + 3);
        if (startIndex == -1 || endIndex == -1){
            return result;
        }
        if ((endIndex - startIndex - 3) % 3 == 0){
            result = gene.substring(startIndex, endIndex + 3);
        }
        return result;
    }
}
