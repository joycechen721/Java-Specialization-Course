package course_2.StringsThirdAssignments;

public class Part2 {
    public static double cgRatio (String dna){
        int gIndex = 0;
        int gCount = 0;
        while (true){
            int gPos = dna.indexOf("g", gIndex);
            if (gPos == -1) {
                break;
            }
            gCount++;
            gIndex = gPos + 1;
        }

        int cIndex = 0;
        int cCount = 0;
        while (true){
            int cPos = dna.indexOf("c", cIndex);
            if (cPos == -1) {
                break;
            }
            cCount++;
            cIndex = cPos + 1;
        }

        return (double)(gCount + cCount) / dna.length();
    }

    public static int countCTG(String dna){
        int count = 0;
        int startIndex = 0;
        while (true){
            if (dna.indexOf("CTG", startIndex) == -1){
                break;
            }
            count++;
            startIndex = dna.indexOf("CTG", startIndex) + 1;
        }
        return count;
    }
}
