package modules;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Nhom1
 */
public class Vigenere {

    private final static String text = "abcdefghijklmnopqrstuvwxyz";

    private static int findChar(String p) {
        return text.indexOf(p);
    }

    private static String encryptWord(String input, String key) {
        while (input.length() > key.length()) {
            key += key;
        }
        key = key.substring(0, input.length());

        String enString = "";

        for (int i = 0; i < input.length(); i++) {
            int iInput = findChar(input.charAt(i) + "");
            int kInput = findChar(key.charAt(i) + "");
            int e = (iInput + kInput) % text.length();
            System.out.println("e: " + e);
            enString += text.charAt(e);
        }

        return enString;
    }

    public static String encrypt(String input, String key) {
        String enString = "";

        while (input.length() > key.length()) {
            key += key;
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                key = key.substring(0, i) + " " + key.substring(i);
            }
        }

        key = key.substring(0, input.length());

        ArrayList<String> items = new ArrayList<String>(Arrays.asList(input.split(" ")));
        ArrayList<String> keys = new ArrayList<String>(Arrays.asList(key.split(" ")));

        for (int i = 0; i < items.size(); i++) {
            enString += encryptWord(items.get(i), keys.get(i)) + " ";
        }

        return enString;
    }

    public static String decryptWord(String enString, String key) {
        while (enString.length() > key.length()) {
            key += key;
        }
        key = key.substring(0, enString.length());

        String input = "";

        for (int i = 0; i < enString.length(); i++) {
            int iEn = findChar(enString.charAt(i) + "");
            int kInput = findChar(key.charAt(i) + "");
            int e = (iEn - kInput + text.length()) % text.length();
            input += text.charAt(e);
        }

        return input;
    }

    public static String decrypt(String enString, String key) {
        String input = "";

        while (enString.length() > key.length()) {
            key += key;
        }
        for (int i = 0; i < enString.length(); i++) {
            if (enString.charAt(i) == ' ') {
                key = key.substring(0, i) + " " + key.substring(i);
            }
        }
        key = key.substring(0, enString.length());

        ArrayList<String> items = new ArrayList<String>(Arrays.asList(enString.split(" ")));
        ArrayList<String> keys = new ArrayList<String>(Arrays.asList(key.split(" ")));

        for (int i = 0; i < items.size(); i++) {
            input += decryptWord(items.get(i), keys.get(i)) + " ";
        }

        return input;
    }

}
