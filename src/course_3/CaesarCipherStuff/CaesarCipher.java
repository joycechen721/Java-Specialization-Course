package course_3.CaesarCipherStuff;

public class CaesarCipher {
    public static void main(String [] args){
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }

    //assuming all alphabetic characters are uppercase letters
    public static String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < input.length(); i++){
            char currChar = input.charAt(i);
            int initPos = alphabet.indexOf(Character.toUpperCase(currChar));
            if (initPos != -1){
                if(Character.isUpperCase(currChar)) encrypted.setCharAt(i, shiftedAlphabet.charAt(initPos));
                else encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(initPos)));
            }
        }
        return encrypted.toString();
    }

    //encrypts every other char starting from 0 with key1, starting from 1 with key2
    public static String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String first = encrypt(input, key1);
        String second = encrypt(input, key2);
        for (int i = 0; i < input.length(); i++){
            if (i % 2 == 0) encrypted.setCharAt(i, first.charAt(i));
            else encrypted.setCharAt(i, second.charAt(i));
        }
        return encrypted.toString();
    }
}
