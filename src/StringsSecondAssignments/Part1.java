package StringsSecondAssignments;

import edu.duke.FileResource;

public class Part1 {
    public static int findStopCodon(String dna, int startIndex, String stopCodon){
        dna = dna.toLowerCase();
        int currIndex = dna.indexOf(stopCodon, startIndex);
        while (currIndex != -1){
            if ((currIndex - startIndex - 3) % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return dna.length();
    }

    public static String findGene(String dna, int start){
        dna = dna.toLowerCase();
        String gene = "";
        int startIndex = dna.indexOf("atg", start);
        if (startIndex == -1) return gene;

        int taa = findStopCodon(dna, startIndex, "taa");
        int tag = findStopCodon(dna, startIndex, "tag");
        int tga = findStopCodon(dna, startIndex, "tga");

        int stopIndex = Math.min(taa, Math.min(tag, tga));
        if (stopIndex == dna.length()) return gene;
        else{
            gene = dna.substring(startIndex, stopIndex + 3);
        }
        return gene;
    }

    public static void printAllGenes(String dna){
        dna = dna.toLowerCase();
        int startIndex = 0;
        String gene = "";
        while (true){
            if (startIndex < dna.length()){
                gene = findGene(dna, startIndex);
            }
            if (gene.isEmpty()){
                break;
            }
            System.out.println(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
    }
    
    public static void main (String [] args){
        FileResource fr = new FileResource("input-files/brca1line.txt");
        String dna = fr.asString();
        System.out.println(findStopCodon(dna, 0, "TGA"));
        // System.out.println(findGene("", 0));
        printAllGenes(dna);
        System.out.println(Part2.howMany("GAA", dna));
        System.out.println(Part3.countGenes(dna));
    }
}
