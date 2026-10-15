package oa_practice;

public class RepeatedGroupedDigitSum {
    public String repeatedGroupedDigitSum(String number, int k) {
        // write your code here
        while (number.length() > k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < number.length(); i += k) {
                int sum = 0;
                for (int j = i; j < Math.min(i + k, number.length()); j++) {
                    sum += number.charAt(j) - '0';
                }
                sb.append(sum);
            }
            number = sb.toString();
        }

        return number;
    }   
    
}
