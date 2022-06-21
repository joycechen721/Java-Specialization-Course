package course_3.CaesarCipherStuff;

public class WordPlay {
    public static void main (String [] args){
        System.out.println(replaceVowels("method", 'x'));
        System.out.println(emphasize("dna ctgaaactga", 'a') );
    }

    public static boolean isVowel (char ch){
        char lower = Character.toLowerCase(ch);
        return lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u';
    }

    public static String replaceVowels (String phrase, char ch){
        StringBuilder replaced = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = phrase.charAt(i);
            if (isVowel(currChar)) replaced.append(ch);
            else replaced.append(currChar);
        }
        return replaced.toString();
    }

    public static String emphasize (String phrase, char ch){
        StringBuilder replaced = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            char currChar = phrase.charAt(i);
            if (Character.toLowerCase(currChar) == ch){
                if (i % 2 == 0) replaced.append('*');
                else replaced.append('+');
            }
            else replaced.append(currChar);
        }
        return replaced.toString();
    }
}
