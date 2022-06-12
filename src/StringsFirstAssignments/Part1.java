package StringsFirstAssignments;

public class Part1 {
    public static String findSimpleGene (String gene){
        String result = "No gene combination found.";
        int startIndex = gene.indexOf("ATG");
        int endIndex = gene.indexOf("TAA", startIndex + 3);
        if (startIndex == -1 || endIndex == -1){
            return result;
        }
        if ((endIndex - startIndex - 3) % 3 == 0){
            result = gene.substring(startIndex, endIndex + 3);
        }
        return result;
    }
    
    public static void main(String[]args){
        System.out.println(findSimpleGene("ATGGGTTAA"));
        System.out.println(Part2.findSimpleGene2("gatgctataat", "atg", "taa"));
        System.out.println(Part3.twoOccurrences("atg", "ctgtatgtatg"));
        System.out.println(Part3.lastPart("zoo", "forest"));
        System.out.println(Part3.lastPart("an", "banana"));
        System.out.println(Part3.lastPart("nana", "banana"));
    }  
}
