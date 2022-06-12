package StringsThirdAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

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

    public static StorageResource getAllGenes(String dna){
        StorageResource allGenes = new StorageResource();
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
            allGenes.add(gene);
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return allGenes;
    }

    public static void main (String [] args){
        // System.out.println(Part2.cgRatio("ATGCCATAGGGCCCC"));
        // System.out.println(Part2.countCTG("ATGCTGCTGCATGCTGAG"));

        FileResource fr = new FileResource("input-files/GRch38dnapart.txt");
        String dna = fr.asString();
        System.out.println(Part2.cgRatio("input-files/GRch38dnapart.txt"));
        printAllGenes(dna);
        StorageResource allGenes = getAllGenes(dna);
        Part3.processGenes(allGenes);
        System.out.println(Part2.countCTG(dna));

    }
}
