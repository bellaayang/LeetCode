package oa_practice;

public class ConstructWDLString {
    public String constructWdlString(String inputStr) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int w = 0;
        int d = 0;
        int l = 0;

        char[] arr = inputStr.toCharArray();
        for (char c : arr) {
            if (c == 'W') {
                w++;
            }
            if (c == 'D') {
                d++;
            }

            if (c == 'L') {
                l++;
            }
        }

        while (w > 0 || d > 0 || l > 0) {
            if (w > 0) {
                sb.append('W');
                w--;
            }
            if (d > 0) {
                sb.append('D');
                d--;
            }
            if (l > 0) {
                sb.append('L');
                l--;
            }
        }

        return sb.toString();


    }

    
}
