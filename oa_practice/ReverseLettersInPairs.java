package oa_practice;

public class ReverseLettersInPairs {
    public String reverseLetterPairs(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i += 2) {
            char temp = c[i];
            c[i] = c[i + 1];
            c[i + 1] = temp;
        }

        return new String(c);
    
    }

    
}
