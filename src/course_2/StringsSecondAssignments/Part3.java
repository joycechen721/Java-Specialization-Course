package course_2.StringsSecondAssignments;

public class Part3 {
    public static int countGenes(String dna){
        dna = dna.toLowerCase();
        int startIndex = 0;
        int geneCount = 0;
        while (true){
            String gene = Part1.findGene(dna, startIndex);
            if (gene.isEmpty()){
                break;
            }
            geneCount++;
            startIndex = dna.indexOf(gene, startIndex) + gene.length();
        }
        return geneCount;
    }
}
