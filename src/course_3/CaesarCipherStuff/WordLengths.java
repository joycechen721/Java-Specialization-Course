package course_3.CaesarCipherStuff;

import edu.duke.FileResource;

public class WordLengths {
    public static void main(String [] args){
        int [] count = new int [31];
        FileResource fr = new FileResource("input_files_3/smallHamlet.txt");
        countWordLengths(fr, count);
        for (int i = 0; i < count.length; i++){
            System.out.println("Word length of " + i + ": " + count[i] + " words.");
        }
        System.out.println(indexOfMax(count));
    }

    public static void countWordLengths(FileResource resource, int [] counts){
        for (String word : resource.words()){
            int length = word.length();
            if(!Character.isLetter(word.charAt(0))) length--;
            if(!Character.isLetter(word.charAt(length - 1))) length--;
            if(length >= 30) counts[30]++;
            else counts[length]++;
        }
    }

    public static int indexOfMax(int [] values){
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < values.length; i++){
            if (values[i] > max) {
                max = values[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
