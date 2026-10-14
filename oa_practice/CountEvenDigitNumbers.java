package oa_practice;

public class CountEvenDigitNumbers {
    public int solution(int[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (isEven(numbers[i])) {
                result++;
            }
            
        }
        return result;
  
    }

    private boolean isEven (int number) {
        int digits = 0;
        while (number > 0) {
            number = number / 10;
            digits++;
        }

        if (digits % 2 == 0) {
            return true;
        }
        return false;
    }
    
}
