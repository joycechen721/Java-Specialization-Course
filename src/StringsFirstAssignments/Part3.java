package StringsFirstAssignments;

public class Part3 {
    public static boolean twoOccurrences(String stringa, String stringb){
        int firstOcc = stringb.indexOf(stringa);
        int secOcc = stringb.indexOf(stringa, firstOcc + stringa.length());
        if (firstOcc != -1 && secOcc != -1){
            return true;
        }
        return false;
    }

    public static String lastPart(String stringa, String stringb){
        int index = stringb.indexOf(stringa);
        if (index != -1){
            return stringb.substring(index + stringa.length());
        }
        return stringb;
    }
}
