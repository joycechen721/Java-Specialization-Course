package course_2.StringsSecondAssignments;

public class Part2 {
    public static int howMany(String stringa, String stringb){
        stringb = stringb.toLowerCase();
        stringa = stringa.toLowerCase();
        int occurrences = 0;
        int startIndex = 0;
        while (true){
            int currIndex = stringb.indexOf(stringa, startIndex);
            if (currIndex == -1) break;
            occurrences++;
            startIndex = currIndex + stringa.length();
        }
        return occurrences;
    }
}