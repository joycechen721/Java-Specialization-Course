package course_2.StringsFirstAssignments;
import edu.duke.*;

public class Part4 {
    public static void main (String [] args){
        URLResource ur = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        for (String s : ur.lines()) {
            String temp = s.toLowerCase();
            if (temp.indexOf("youtube.com") != -1){
                int startPos = s.indexOf("\"") + 1;
                int endPos = s.indexOf("\"", startPos + 1);
                System.out.println(s.substring(startPos, endPos));
            }
        }
    }
}
