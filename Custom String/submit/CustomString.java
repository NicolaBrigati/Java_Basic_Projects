import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

public class CustomString {
    String myString;
    boolean isSet;

    public CustomString() {
        this.myString = null;
        this.isSet = false;
    }

    public String getString() {
        return isSet ? myString : null;
    }

    public void setString(String string) {
        if (string == null) {
            this.isSet = false;
            this.myString = null;
        } else {
            this.myString = string;
            this.isSet = true;
        }
    }

    public String remove(String arg) {
        if (!isSet || myString == null || myString.isEmpty()) {
            return "";
        }
        if (arg == null || arg.isEmpty()) {
            return myString;
        }
        StringBuilder result = new StringBuilder();
        Set<Character> removeSet = new HashSet<>();
        for (char c : arg.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                removeSet.add(c);
            }
        }
        for (char c : myString.toCharArray()) {
            if (!(removeSet.contains(Character.toLowerCase(c)))) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String reverse(String arg) {
        if (!isSet || myString == null || myString.isEmpty()) {
            return "";
        }
        if (arg == null || arg.isEmpty()) {
            return myString;
        }
        StringBuilder result = new StringBuilder();
        Set<Character> reverseSet = new HashSet<>();
        for (char c : arg.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                reverseSet.add(c);
            }
        }
        for (char c : myString.toCharArray()) {
            if (reverseSet.contains(Character.toLowerCase(c))) {
                if (Character.isUpperCase(c)) {
                    result.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    result.append(Character.toUpperCase(c));
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String filterLetters(char n, boolean more) {
        if (!isSet || myString == null || !Character.isLetter(n)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        char target = Character.toLowerCase(n);
        for (char c : myString.toCharArray()) {
            char lowerC = Character.toLowerCase(c);
            if (Character.isLetter(c)) {
                if (more && lowerC < target) {
                    result.append(c);
                } else if (!more && lowerC > target) {
                    result.append(c);
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
